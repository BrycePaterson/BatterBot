import edu.stanford.nlp.tagger.maxent.MaxentTagger;


public class demo {

	public static void main(String[] args) {
		MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");
		// The sample string
		 
		String sample = "My name is Bryce. I want to test if a longer sentence takes longer to parse.  This is a test.";
		 
		// The tagged string
		 
		String tagged = tagger.tagString(sample);
		 
		// Output the result
		 
		System.out.println(tagged);
		
	}

}
