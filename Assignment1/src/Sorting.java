import java.util.ArrayList;

public class Sorting {
	/**
	 * Instance variables to count passes, comparisions and swaps for each sort;
	 * */
	private static int passes;
	private static int comparisons;
	private static int swaps;
	private static ArrayList<String> output;
	/**
	 * An implementation of the bubble sort algorithim, for arrays.
	 * @param an int array to sort
	 * @return the sorted int array
	 * */
	public static LinkedNode<Integer> bubbleSort(LinkedNode<Integer> head) {
		//Reset all the counters
		passes = 0;
		comparisons =0;
		swaps=0;
		int totalSwap =0;
		int totalComp = 0;
		output = new ArrayList<String>();
        boolean wasChanged=true;
        	while( wasChanged ) {
        		//Reset the counters
        		comparisons =0;
        		swaps=0;
            	//Count the number of passes of this loop
            	passes++;
            	LinkedNode<Integer>current = head;
                LinkedNode<Integer> previous = null;
                LinkedNode<Integer> next = head.getNext();
                wasChanged = false;
 
                while ( next != null ) {
                	//Count the number of comparisons here
                	comparisons++;
                    if (current.getElement() > next.getElement()) {
                    	//Count a swap here
                    	swaps++;
                        wasChanged = true;
                      //Swap the pointers
                        if ( previous != null ) {
                        	LinkedNode<Integer> temp = next.getNext();
                        	previous.setNext(next);
                        	next.setNext(current);
                        	current.setNext(temp);
                        } 
                        else {
                        	//If we don't have a previous swap pointers and set up a previous
                        	LinkedNode<Integer> temp = next.getNext();
                        	head = next;
                        	next.setNext(current);
                        	current.setNext(temp);
                        }
                        //Move forward
                        previous = next;
                        next = current.getNext();
                    } else { 
                    	//Move forward
						previous = current;
	                    current = next;
	                    next = next.getNext();
                    }
                } 
                //Add the total and save the output
                
                output.add("     k     "+passes + "    " + comparisons + "        " + swaps);
                totalSwap += swaps;
                totalComp += comparisons;
            } 
        	output.add("   " + "Total:" + "    " + passes + "   " +totalComp + "    "+totalSwap);
        return head;
    }
	
	/**
	 * An implementation of the shell sort algorithim, for LinkedList, usingthe knuths increment sequence.
	 * @param an node
	 * @return the starting node of the sorted list
	 * */
	public static LinkedNode<Integer> shellSort(LinkedNode<Integer> head) {
		//Reset all the counters
		passes = 0;
		comparisons =0;
		swaps=0;
		int totalSwap =0;
		int totalComp = 0;
		int totalPasses=0;
		int n = 11;
		
		output = new ArrayList<String>();
        boolean wasChanged=true;
        	while( n >0 ||wasChanged) {
        		//Reset the counters
       
        		if(n<1) {
        			n=1;
        		}
           		int k = calculateK(n);
            	//Count the number of passes of this loop
            	passes++;
            	LinkedNode<Integer>current = head;
                LinkedNode<Integer> previous = null;
                LinkedNode<Integer> nextPrev = pickNextNode(head,k);
                if(nextPrev == null) {
                	n--;
                	continue;
                }
                
                LinkedNode<Integer> next = nextPrev.getNext();

                wasChanged = false;
                //All works correctly until we hit 1
                while ( next != null  && current != null) {
                	//Count the number of comparisons here
                	comparisons++;
                    if (current.getElement() > next.getElement()) {
                    	//Count a swap here
                    	swaps++;
                    	//WasChanged becomes true
                    	wasChanged = true;
                    	//if n is 1 we need to swap differently to avoid circular pointers
                    	if(n==1) {
                            //Swap the pointers
                            if ( previous != null ) {
                            	LinkedNode<Integer> temp = next.getNext();
                            	previous.setNext(next);
                            	next.setNext(current);
                            	current.setNext(temp);
                            } 
                            else {
                            	//If we don't have a previous swap pointers and set up a previous
                            	LinkedNode<Integer> temp = next.getNext();
                            	head = next;
                            	next.setNext(current);
                            	current.setNext(temp);
                            }
                            //Move forward
                            previous = next;
                            next = current.getNext();
                            continue;
                    	}
                    	//Otherwise we can use the long-range swap
                    	
                    	
                    	//Update the pointers
                    	LinkedNode<Integer> temp = next.getNext();
                    	next.setNext(current.getNext());
                    	nextPrev.setNext(current);
                    	current.setNext(temp);
                    		//If we have a previous set up its pointer otherwise set previous
                    		if(previous != null) {
                    			previous.setNext(next);
                    			previous = previous.getNext();
                    		}
                    		else {
                    			previous = next;
                    			head = next;
                    		}
                    	//Swap the pointers for current and next and move forward
                    	LinkedNode<Integer> temp2 = current.getNext();
                    	LinkedNode<Integer> temp3 = next.getNext();
                    	nextPrev = current;
                    	current =  temp3;
                    	next = temp2;                 	
                    	}
                    else {
                    	if(previous != null) {
                    		previous = previous.getNext();
                    	}
                    	else {
                    		previous = current;
                    		head = current;
                    	}
                    	
                    	//Move forward
                    	current = current.getNext();
                    	nextPrev = nextPrev.getNext();
                    	next = next.getNext();

                    }

                   } 
             
                //Decrement the sequence
                if(!wasChanged) {
                    //Add the total and save the output
                    output.add("    "+k+"     "+passes + "    " + comparisons + "        " + swaps);
                    totalSwap += swaps;
                    totalComp += comparisons;
                    totalPasses += passes;
                	n--;
                	passes=0;
             		comparisons =0;
            		swaps=0;
                }
                
            } 
        	output.add("   " + "Total:" + "    " + totalPasses + "   " +totalComp + "    "+totalSwap);
        return head;
	}

	
	/**
	 * @return the Arraylist containing strings to build the output
	 * */
	public static ArrayList<String> getOutput(){
		return output;
	}
	
	
	/**
	 * A method to pick the next node based on the knuths increment sequence
	 * @param the head, and a value k in the sequence
	 * @return the node BEFORE the desired node
	 * */
	private static LinkedNode<Integer> pickNextNode(LinkedNode<Integer> head, int k) {
		int count =0;
		LinkedNode<Integer> temp = head;
		while(temp != null && count < k-1) {
			temp = temp.getNext();
			count ++;
		}
		return temp;
	}
	
	/**
	 * A method to calculate for the value in knuths increment sequence
	 * @param a number to input in the calculation
	 * @return the number in the sequence
	 * */
	private static int calculateK(int n) {
		return (int) ((Math.pow(3, n)-1)/2);
	}

}
