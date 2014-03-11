import edu.stanford.nlp.tagger.maxent.MaxentTagger;

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
		
		if(kwl.size() == 0){
			String tag = POSTag(unchanged);
			if(contains(tag,"_NNP")){
				memTable.put("Name", ProperNoun(tag));
				kwl.addKey("_NNP");
			}else if(contains(tag,"_VB")){
				memTable.put("Action", VerbBase(tag));
				kwl.addKey("_VB");
			}else{
				kwl.addKey("null");
			}
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
	}
	
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
	}
	
	public String VerbBase(String input){
		input = input.substring(0, input.indexOf("_VB"));
		String verb = input.substring(input.lastIndexOf(" "), input.length())+"ing";
		return verb;
	}
}