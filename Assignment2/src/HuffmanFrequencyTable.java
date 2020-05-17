import java.util.ArrayList;

public class HuffmanFrequencyTable {
	/**
	 * Fields for the class
	 * */
	private String[][] table;
	private HuffmanTree tree;
	private String input;
	/**
	 * A method that generates a new huffman frequency table based off an input string
	 * @param a string to build the table from
	 * */
	public HuffmanFrequencyTable(String input) {
		this.input = input;
		tree = new HuffmanTree();
		table = new String[input.length()][3];
		for(int i =0; i < input.length(); i++) {
			int occurences = getOccurrences(input, input.charAt(i));
			//If we have a duplicate don't add, otherwise add
			if(occurences > 1 && checkDuplicates(table, input.charAt(i))) {
				continue;
			}
			else {
				table[i][0] = "" + input.charAt(i);
				table[i][1] = "" + occurences;
			}
		}
		for(int i = 0; i < input.length(); i++) {
			if(table[i][0] == null) {continue;}
			tree.addNode(table[i][0], Integer.parseInt(table[i][1]));
		}
		tree.buildTree();
		tree.buildHuffmanEncodings(tree.getRoot(),"");
		
		for(int i =0; i <input.length(); i++) {
			table[i][2] = getCode(table[i][0]);
		}
	}
	
	
	/**
	 * A method that gets the code for each letter
	 * */
	private String getCode(String string) {
		for(int i =0; i< tree.getHuffmanCodes().size(); i++) {
			if(tree.getHuffmanCodes().get(i)[0] == string) {
				return tree.getHuffmanCodes().get(i)[1];
			}			
		}
		return null;
	}

	/**
	 * A helper method for building a the table
	 * @return the number of occurrences of a char in a string
	 * @param the input string and the character
	 * */
	private static int getOccurrences(String input, char letter) {
		int count = 0;
		for(int i =0; i<input.length(); i++) {
			if(input.charAt(i) == letter) {count++;}
		}
		return count;
	}
	
	/**
	 * A helper method for building the table
	 * @param the table and the letter
	 * @return true if the letter is a duplicate, false otherwise
	 * */
	private static boolean checkDuplicates(String[][] table, char letter) {
		for(int i = 0; i < table.length; i ++) {
			if(table[i][0] != null && table[i][0].equals(""+letter)) {return true;}
		}
		return false;
	}
	
	
	
	/**
	 * A method that iterates over the array table and builds the output string
	 * @return a table with all the huffman coding information
	 * */
	public String toString() {
		String returnString = "======================================\n";
		returnString  +=      "char     frequency      code\n";
		returnString  +=      "--------------------------------------\n";
		for(int i =0; i< table.length; i++) {
			if(table[i][0] != null) {
				returnString+= table[i][0]+"        "+table[i][1]+"              "+ table[i][2]+"\n";
			}
		}
		returnString +=  "======================================\n";
		//Add in the encoded bit stream, the total bits, with and without huffman and compression ratio and decoded string
		return returnString;
	}
	
	/**
	 * A helper method to get the table
	 * @return the huffman frequency table
	 * */
	public String[][] getTable(){
		return table;
	}
	
	/**
	 * A helper method to return the input string
	 * @return the input strintg
	 * */
	public String getInput() {
		return input;
	}
	/**
	 * A helper method to return the huffman tree
	 * @return the huffman tree for the table
	 * */
	public HuffmanTree getTree() {
		return tree;
	}
	
	public double calculateCompressionRatio() {
		double numerator = 0;
		double denominator =0;
		for(int i =0; i < table.length; i++) {
			if(table[i][0]==null) {continue;}
			numerator += table[i][2].length() * Integer.parseInt(table[i][1]);
			denominator += Integer.parseInt(table[i][1]);
		}
		return numerator/denominator;
	}

}
