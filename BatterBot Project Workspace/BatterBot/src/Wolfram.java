import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;


public class Wolfram {
	private WAEngine engine;
	private WAQuery query;
	
	public Wolfram(){
		engine = new WAEngine();
        
        // These properties will be set in all the WAQuery objects created from this WAEngine.
        engine.setAppID("256R69-2WE2YEV89V");
        engine.addFormat("plaintext");
        
        query = engine.createQuery();
	}

	public String[] getSynonyms(String search){
        
        query.setInput("synonyms "+search);
        
        try {
			WAQueryResult queryResult = engine.performQuery(query);
			
			for (WAPod pod : queryResult.getPods()) {
                if (!pod.isError() && pod.getTitle().equals("Result")) {
                	for (WASubpod subpod : pod.getSubpods()) {
                		for (Object element : subpod.getContents()) {
                			if (element instanceof WAPlainText) {
                				String response = ((WAPlainText) element).getText();
                				String[] synonyms = getWords(response);
                				return synonyms;
                			}
                		}
                	}
                }
            }
		} catch (WAException e) {
			e.printStackTrace();
		}
        
        return null;
	}

	
	public static String[] getWords(String text){
		String[] words = new String[10];
		String word;
		for(int i=0;i<10;i++){
			if(text.contains(" ")){
				word = text.substring(0, text.indexOf(' '));
				if(!word.equals("|"))
					words[i] = word;
				else
					i--;
				text = text.substring(text.indexOf(' ')+2);
			} else{
				words[i] = text;
				return words;
			}
		}
		return words;
	}	

}
