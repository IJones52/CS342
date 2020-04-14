
public class LinkedNode<Integer>{
	//A toString would be helpful
	int element;
	LinkedNode<Integer> next;
	
	public LinkedNode(){
		
	}
	public LinkedNode(int num) {
		element = num;
	}
	
	public LinkedNode<Integer> getNext(){
		return next;
	}
	
	public void setNext(LinkedNode<Integer> node) {
		next = node;	
	}
	
	public int getElement() {
		return element;
		
	}
	public void setElement(int num) {
		element = num;
	}
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
