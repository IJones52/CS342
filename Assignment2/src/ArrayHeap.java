import java.util.Arrays;

public class ArrayHeap<T> {
	/**
	 * Fields for this class
	 * */
	@SuppressWarnings("unchecked")
	private T[] heap;
	private static int count = 0;
	
	
	public ArrayHeap(int size){
		heap = (T[]) new Object[size];
	}
	
	/**
	 *A method to add elements to the heap
	 *@param an element to add 
	 * */
	public void addElement(T element) {
		if(count == heap.length) {
			resize();
		}
		heap[count] = element;
		count++;
		if(count > 1) {heapifyAdd();}
	}
	
	
	/**
	 * A method that upon catching overflow will double the size of the array
	 * */
	private void resize() {
		T[] heap2 = (T[]) new Object[heap.length *2];
		for(int i =0; i < heap.length; i++) {
			heap2[i] = heap[i];
		}
		heap  = heap2;
	}
	
	
	/**
	 * A helper method that will reorder the heap upon adding a new element
	 * */
	private void heapifyAdd() {
		T temp;
		int next = count-1;
		
		while(next != 0 && (((Comparable)heap[next]).compareTo(heap[(next-1)/2]) < 0)) {
			temp = heap[next];
			heap[next] = heap[(next-1)/2];
			next = (next-1)/2;
			heap[next]= temp;
					
		}
		    
	}
	
	/**
	 * A method that removes the minimum element from the min heap
	 * @return the minimum element
	 * */
	public T removeMin() {
		//Check for underflow
		if(heap[0] == null) {
			return null;
		}
		
		T minElement = heap[0];
		heap[0] = heap[count-1];
		heap[count-1] = null;
		heapifyRemove();
		count --;
		return minElement;                                                                                                
	}
	
	/**
	 * A helper method that reorders the heap after the smallest element is removed
	 * */
	private void heapifyRemove() {
		T temp = heap[0];
		int parent = 0, left = 1, right = 2;
		while(parent < count &left <count && right<count) {
			if(heap[left] == null && heap[right] == null) {
				parent = count;
			}
			else if(heap[right] == null && (((Comparable)heap[parent]).compareTo(heap[left]) < 0)) {
				swap(parent,left);
				parent = left;
				left = 2*parent +1;
			}
			else if((((Comparable)heap[left]).compareTo(heap[right]) < 0) && (((Comparable)heap[left]).compareTo(heap[parent]) < 0)) {
				swap(parent,left);
				parent = left;
				left = 2*parent+1;
			}
			else if((((Comparable)heap[right]).compareTo(heap[left]) < 0) &&  (((Comparable)heap[right]).compareTo(heap[parent]) < 0)) {
				swap(parent,right);
				parent = right;
				right = 2*parent+1;
			}
			else {
				parent = count;
			}
		}
		
	}
	
	/**
	 * A method that swaps positions of elements in the heap
	 * */
	private void swap(int pos1, int pos2) {
		T temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}
	
	
	/**
	 * A method to see the heap for testing
	 * @return the array of the heap
	 * */
	public String toString() {
		return Arrays.toString(heap);
	}
}
