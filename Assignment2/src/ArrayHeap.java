import java.util.Arrays;

public class ArrayHeap<T> {
	/**
	 * Fields for this class
	 * */
	@SuppressWarnings("unchecked")
	protected T[] heap;
	private int count = 0;
	
	
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
		
		while(next != 0 && (((Comparable)heap[next]).compareTo(heap[(next-1)/2]) <= 0)) {
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
		if(heap[0] == null || count <1) {
			return null;
		}
		
		T minElement = heap[0];
		heap[0] = heap[count-1];
		heapifyRemove();
		heap[count-1]=null;
		count --;
		return minElement;                                                                                                
	}
	
	/**
	 * A helper method that reorders the heap after the smallest element is removed
	 * */
	
	private void heapifyRemove() {
		T temp;
		int parent = 0, left = 1, right = 2;
		int next;
		//Select a starting location for the next
		if ((heap[left] == null) && (heap[right] == null))
            next = count;
        else if (heap[right] == null) {
            next = left;
        }
        else if (((Comparable)heap[left]).compareTo(heap[right]) < 0) {
            next = left;
        }
        else if(((Comparable)heap[right]).compareTo(heap[left]) < 0){
            next = right;
        }
        else {
        	next = left;
        }
        temp = heap[parent];
        //Swap until we can't move anymore, if it is equal, make it a child
        while ((next < count) && (((Comparable)heap[next]).compareTo(temp) <= 0))
            {
                //Set the indices 
        		heap[parent] = heap[next];
                parent = next;
                left = 2 * parent + 1;
                right = 2 * (parent + 1);
                //Pick next index
                if ((left > count-1 || heap[left] == null) && (right > count -1 || heap[right] == null)) {
                    next = count;
                }
                else if (right > count-1 || heap[right] == null) {
                    next = left;
                }
                else if (((Comparable)heap[left]).compareTo(heap[right]) < 0) {
                    next = left;
                }
                else {
                    next = right;
                }
            }
            heap[parent] = temp;
		
	}

	
	
	/**
	 * A method to see the heap for testing
	 * @return the array of the heap
	 * */
	public String toString() {
		return Arrays.toString(heap);
	}
	
	/**
	 * A helper method to get he heap
	 * @return the array which is the heap
	 * */
	public T[] getHeap() {
		return heap;
	}
}
