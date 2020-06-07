import java.util.Arrays;

public class HashTable {
	private LinkedNode<String>[] table;
	private int collisions;

	/**
	 * The constructor for HashTable. Generates a hashtable with a fixed size
	 * @param the size of the table
	 * */
	public HashTable(int size) {
		table =  (LinkedNode<String>[]) new LinkedNode[size];
	}
	
	/**
	 * A method to generate a hashcode for a string utilizing only the methods taught in class
	 * It does not generate perfectly unique hashcodes
	 * @param a string input
	 * @return the hashcode for the strnig
	 * 
	 * */
	public int hashCode(String input) {
		String alphagram = getAlphagram(input);
		char[] alphaArr = alphagram.toCharArray();
		int code;
		//Start  by using the folding/shifting method
		code =  alphaArr[alphaArr.length/7]* alphaArr[alphaArr.length/6]*alphaArr[alphaArr.length/5] * alphaArr[alphaArr.length/4] * alphaArr[alphaArr.length/3] * alphaArr[alphaArr.length/2] * alphaArr[alphaArr.length-1];
		//Make it length dependent
		code = code /alphaArr.length;
		code = code*31;
		//Do mid-squared method
		code = Math.abs(code * code);
		//Do the division method
		code = code % table.length;
		
		return code;
		
		
	}
	
	/**
	 * A method to place objects into the hashtable
	 * @param a string to pass into the hashtable
	 * */
	public void hash(String input) {
		int code = hashCode(input);
		String alphagram = getAlphagram(input);
		
		if(table[code] == null) {
			table[code] = new LinkedNode<String>(alphagram,input);
		}
		else {	
			LinkedNode<String> newHead = new LinkedNode<String>(alphagram,input);
			//Only count a collision if the alphagrams are different, if the alphagrams are the same it is in the right place
			if(!table[code].containsAlphagram(alphagram)) {
				collisions++;
			}
			newHead.setNext(table[code]);
			table[code] = newHead;
			
		}
	}
	
	/**
	 * A method that returns the string in alphabetical order
	 * @param any string
	 * @return the alphabetically sorted string
	 * */
	public String getAlphagram(String original) {
		char[] str = original.toCharArray();
		Arrays.sort(str);
		return new String(str);
	}
	
	public int getCollisions() {

		return collisions;
	}
	
	/**
	 * A method that finds anagrams of a given string
	 * @param an input string
	 * @return all anagrams of that string, if they are in the dictionary
	 * */
	public String findAnagrams(String input) {
		int hash = hashCode(input);
		String alphagram = getAlphagram(input);
		String output = "";
		if(table[hash] != null) {
			LinkedNode<String> node = table[hash];
			while(node != null) {
				if(node.getAlphagram().equals(alphagram) && !node.getElement().equals(input)) {
					output += node.getElement() + ", ";
				}
				node = node.getNext();
			}
			if(output.equals("")) {
				return "No anagrams detected";
			}
			return output;
		}
		else {
			return "No anagrams detected";
		}
	}
	

}
