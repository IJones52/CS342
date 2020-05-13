
public class PriorityQueue<T> extends ArrayHeap<HuffmanTreeNode<T>> {

	public PriorityQueue(int size) {
		super(size);
	}
	
	public void addElement(T element, int priority) {
		HuffmanTreeNode<T> node = new HuffmanTreeNode<T>(element, priority);
		addElement(node);
	}
	
	public T removeNext() {
		HuffmanTreeNode<T> node = removeMin();
		return node.getElement();
	}

}
