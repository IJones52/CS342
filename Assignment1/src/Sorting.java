
public class Sorting {

	/**
	 * An implementation of the bubble sort algorithim, for arrays.
	 * @param an int array to sort
	 * @return the sorted int array
	 * */
	public static int[] bubbleSort(int[] arr) {
		boolean sorted = false;
		int n = arr.length;
		for(int i = n; i >0 && !sorted; i--) {
			sorted = true;
			for(int j=0; j < i-1;j++) {
				if(arr[j] > arr[j+1]) {
					swap(j,j+1,arr);
					sorted = false;
				}
			}
		}
		return arr;
	}
	/**
	 * An implementation of the shell sort algorithim, for arrays, usingthe knuths increment sequence.
	 * @param an int array to sort
	 * @return the sorted int array
	 * */
	//You want to start from a high number in the sequence and go down, idk how we decide that?
	public static int[] shellSort(int[] arr) {
		boolean sorted = false;
		int n = arr.length;
		for(int i = n; i >0 && !sorted; i--) {
			//Count the number of passses of this loop
			sorted = true;
			//Declare the knuths increment sequence variable based off a variable k starting at 1
			//Make sure it doesn't go out of bounds
			for(int j=0,  k = j+1, sequence = (int) ((Math.pow(3, k)-1)/2); j < i-1 && sequence < i;j++) {	
				//Note comparisons here
				if(arr[j] > arr[j+sequence]) {
					//Note the exchanges here
					swap(j,j+1,arr);
					sorted = false;
				}
			}
		}
		return arr;
	}
	/**
	 * A method to swap the location of two items in an array
	 * @param the indexes of the values to swap, an array
	 * */
	private static void swap(int pos1, int pos2, int[] arr) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
}
