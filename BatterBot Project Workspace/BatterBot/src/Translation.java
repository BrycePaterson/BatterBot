import com.gtranslate.Language;
import com.gtranslate.Translator;



public class Translation {
	
	private Translator translate;
	
	/**
	 * Contructor
	 */
	public Translation(){
		translate = Translator.getInstance();	
	}
	
	/**
	 * Returns the input translated into English from French
	 * @param french
	 * @return
	 */
	public String frenchToEnglish(String french){   
	    return translate.translate(french, Language.FRENCH, Language.ENGLISH);	    
	}
	
	/**
	 * Return the input translated into French from English
	 * @param english
	 * @return
	 */
	public String englishToFrench(String english){
		return translate.translate(english, Language.ENGLISH, Language.FRENCH);
	}

}
