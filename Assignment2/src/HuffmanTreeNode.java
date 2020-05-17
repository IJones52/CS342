
public class HuffmanTreeNode<T> implements Comparable<T> {

	/**
	 * Fields for the class
	 * */
	private T element;
	private int priority;
	HuffmanTreeNode<T> left;
	HuffmanTreeNode<T> right;
	
	
	/**
	 * Constructs a new huffman tree node with starting based of a given priority and element
	 * @param an integer value for priority and an object for the element
	 * */
	public HuffmanTreeNode(T elem, int prior) {
		element = elem;
		priority = prior;
	}
	
	
	/**
	 * Getter and setter methods
	 * */
	public T getElement() {
		return element;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		 this.priority = priority;
	}
	
	
	/**
	 * A method for comparing nodes to each other
	 * @param a node to compare against
	 * @return 1 for higher priority, 0 for equal, and -1 for lower priority
	 * */

	@Override
	public int compareTo(T o) {
		if(o instanceof HuffmanTreeNode<?>) {
			HuffmanTreeNode<?> node = (HuffmanTreeNode<?>) o;
			if(priority > node.getPriority()) {
				return 1;
			}
			else if(priority  < node.getPriority()) {
				return -1;
			}
			else {return 0;}
		}
		return 0;
	}
	
	/**
	 * A method that returns the value of the node in the form element + priority
	 * @return the values in the node
	 * */
	public String toString() {
		return "Element: " + element.toString() + "    Priority: " + priority;
	}

	
}
