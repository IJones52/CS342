
public class LinkedNode<Integer>{
	/**
	 * The variables for this class
	 * */
	private int element;
	private LinkedNode<Integer> next;
	
	/**
	 * Constructor that constructs an empty  linked node
	 * */
	public LinkedNode(){
		
	}
	
	/**
	 * A Constructor that constructs a linked node with a specifed element value
	 * @param the desired element
	 * */
	public LinkedNode(int num) {
		element = num;
	}
	
	/**
	 * A method to return the next node
	 * @return the next node
	 * */
	public LinkedNode<Integer> getNext(){
		return next;
	}
	
	/**
	 * A method to set the next node
	 * @param the desired node to link
	 * */
	public void setNext(LinkedNode<Integer> node) {
		next = node;	
	}
	
	/**
	 * A method that returns the element of the node
	 * @return the node's element
	 * */
	public int getElement() {
		return element;
		
	}
	
	
	/**
	 * A method that sets the element of a node
	 * @param the desired element
	 * */
	public void setElement(int num) {
		element = num;
	}
	
	/**
	 * A method that returns the contents of the a linked node and the nodes linked to it in the form of a string
	 * @return the string containing the nodes elements
	 * */
	public String toString() {
		String values = "" + getElement() + " ";
		LinkedNode<Integer> next = getNext();
		while(next != null) {
			values += next.getElement() + " ";
			next = next.getNext();
		}
		return values;
	}
}
