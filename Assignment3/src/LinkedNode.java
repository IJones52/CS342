public class LinkedNode<String>{
	/**
	 * The variables for this class
	 * */
	private String element;
	private String alphagram;
	private LinkedNode<String> next;
	
	/**
	 * Constructor that constructs an empty  linked node
	 * */
	public LinkedNode(){
		
	}
	
	/**
	 * A Constructor that constructs a linked node with a specifed element value
	 * @param the desired element
	 * */
	public LinkedNode(String alpha, String str) {
		element = str;
		alphagram = alpha;
	}
	
	/**
	 * A method to return the next node
	 * @return the next node
	 * */
	public LinkedNode<String> getNext(){
		return next;
	}
	
	/**
	 * A method to set the next node
	 * @param the desired node to link
	 * */
	public void setNext(LinkedNode<String> node) {
		next = node;	
	}
	
	/**
	 * A method that returns the element of the node
	 * @return the node's element
	 * */
	public String getElement() {
		return element;
		
	}
	
	
	/**
	 * A method that sets the element of a node
	 * @param the desired element
	 * */
	public void setElement(String str) {
		element = str;
	}
	
	
	/**
	 * A method that returns the alphagram of the node
	 * @return the node's alphagram
	 * */
	public String getAlphagram() {
		return alphagram;
		
	}
	
	
	/**
	 * A method that sets the alphagram of a node
	 * @param the desired alphagram
	 * */
	public void setAlphagram(String str) {
		alphagram = str;
	}
	/**
	 * A method that returns the contents of the a linked node and the nodes linked to it in the form of a string
	 * @return the string containing the nodes elements
	 * */
	public java.lang.String toString() {
		java.lang.String values = "" + getElement() + " ";
		LinkedNode<String> next = getNext();
		while(next != null) {
			values += next.getElement() + " ";
			next = next.getNext();
		}
		return values;
	}
	
	public boolean containsAlphagram(String input) {
		LinkedNode<String> current = this;
		while(current != null) {
			if(current.getAlphagram().equals(input)){return true;}
			current = current.next;
		}
		return false;
	}
}