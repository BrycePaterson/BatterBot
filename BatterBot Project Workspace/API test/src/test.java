import jars.ResponseTemplate;


public class test {

	public static void main(String[] args) {
		String[] sentence0 = {"This is a test: "," and another test: "};
		String[][] bucket0 = {{"1,2"},{"3,4"}};
		String[] keys0 = {"test"};

		ResponseTemplate response = new ResponseTemplate(sentence0, bucket0, keys0);

	}

}
