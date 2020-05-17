
public class PriorityQueue<T> extends ArrayHeap<HuffmanTreeNode<T>> {

	/**
	 * Builds a new priority queue of a given size
	 * */
	public PriorityQueue(int size) {	
		super(size);

	}
	
	/**
	 * Add a new element to the priority queue, makes an new HuffmanTreeNode and adds it to the hepa
	 * @param an element and a priority
	 * */
	public void addElement(T element, int priority) {
		HuffmanTreeNode<T> node = new HuffmanTreeNode<T>(element, priority);
		addElement(node);
	}
	
	/**
	 * A metheod to dequeue items from the priority queue
	 * @return the element of the priority queue
	 * */
	
	public T removeNext() {
		HuffmanTreeNode<T> node = removeMin();
		return node.getElement();
	}
	

	


}
