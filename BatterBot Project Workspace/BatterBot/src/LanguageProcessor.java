import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.ie.crf.*;
import edu.stanford.nlp.ie.AbstractSequenceClassifier;

/**
 * Our implementation of the Language Processor is relatively simple. The
 * Language Processor takes in the user input as a String. The Language
 * Processor then loops through a list of all of the known keywords, and
 * searches through the user input looking for each one. Every keyword that is
 * found is then stored in a list, which is passed to the Response Selector.
 * 
 * @author Yasha
 * @author Ephraim
 */
public class LanguageProcessor implements LanguageProcessorInterface, SharedData
{

	MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");
	String serializedClassifier = "taggers/english.all.3class.distsim.crf.ser";
	@SuppressWarnings("rawtypes")
	AbstractSequenceClassifier classifier = CRFClassifier.getClassifierNoExceptions(serializedClassifier);
	
	public KeyWordList extractKeyWords(String input) 
	{
		String unchanged = input;
		input = input.toLowerCase();
		
		String[] masterkeys = masterKeys.getKeys(); //masterKeys as array of strings
		KeyWordList kwl = new KeyWordList(); //KeyWordList which is returned by the function
		
		for(int i=0; i<masterkeys.length; i++)
		{
			if(contains(input,masterkeys[i]))
			{
				kwl.addKey(masterkeys[i]);
			}
		} //Add word in input to KeyWordList if it is in masterKeys
		
		//add Proper noun and Action from input to memory using POS tagger
		String tag = POSTag(unchanged);
		if(contains(tag,"_NNP "))
			memTable.put("_NNP", ProperNoun(tag));
		if(contains(tag,"_VB "))
			memTable.put("_VB", VerbBase(tag));
		
		//add any Locations and Organisations to memory using the NER classifier
		String NER = classify(unchanged);
		if(contains(NER,"/LOCATION")){
			memTable.put("_loc", location(NER));
			kwl.addKey("_loc");
		}
		if(contains(NER,"/ORGANIZATION")){
			memTable.put("_org", organization(NER));
			kwl.addKey("_org");
		}
		
		if(kwl.size() == 0){
			//Add any Proper Nouns of Verb Bases to the keyword list
			if(memTable.containsKey("_NNP")){
				kwl.addKey("_NNP");
			}else if(memTable.containsKey("_VB")){
				kwl.addKey("_VB");
			}else kwl.addKey("null");
		}
		return kwl;
	}
	
	public boolean contains(String input, String key)
	{
		return input.toLowerCase().contains(key.toLowerCase());
	} // Returns true if the input String contains the key String (case insensitive)
	
	public String POSTag(String input){
		String tagged = tagger.tagString(input);
		return tagged;
	}//Return the String with the POS tagged
	
	public String classify(String input){
		return classifier.classifyToString(input);
	}//return the String with the NER tagged
	
	public String ProperNoun(String input){
		String properNoun; 
		input = input.substring(0, input.indexOf("_NNP"));
		if(contains(input," "))
			properNoun = input.substring(input.lastIndexOf(" "), input.length());
		else{
			properNoun = input.substring(0, input.length());
			properNoun = " "+properNoun;
		}
		return properNoun;
	}//return the properNoun from the POS tagged string
	
	public String VerbBase(String input){
		String verb; 
		input = input.substring(0, input.indexOf("_VB "));
		if(contains(input," "))
			verb = input.substring(input.lastIndexOf(" "), input.length());
		else{
			verb = input.substring(0, input.length());
			verb = " "+verb;
		}
		verb = verb +"ing";
		return verb;
	}//return the verb base from the POS tagged string
	
	public String location(String input){
		String loc; 
		input = input.substring(0, input.indexOf("/LOCATION"));
		if(contains(input," "))
			loc = input.substring(input.lastIndexOf(" "), input.length());
		else{
			loc = input.substring(0, input.length());
			loc = " "+loc;
		}
		return loc;
	}//return the location from the NER tagged string
	
	public String organization(String input){
		String org; 
		input = input.substring(0, input.indexOf("/ORGANIZATION"));
		if(contains(input," "))
			org = input.substring(input.lastIndexOf(" "), input.length());
		else{
			org = input.substring(0, input.length());
			org = " "+org;
		}
		return org;
	}//return the organisation from the NER tagged string
}
