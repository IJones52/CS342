
public class Encoder {
	/**
	 * A method to build a string of huffman codes based on the input string for the table
	 * @return the input string as huffman codes
	 * 
	 * */
	public static String getEncodeBitStream(String input, String[][] table) {
		String stream = "";
		for(int i = 0; i < input.length(); i++) {
			for(int j = 0; j < table.length; j++) {
				if(table[j][0] != null && table[j][0].equals(input.charAt(i)+"")) {
					stream += table[j][2];
				}
			}
		}
		return stream;
	}
	
}
