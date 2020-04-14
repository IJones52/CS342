import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		LinkedNode<Integer> rand100 = new LinkedNode<Integer>();
		rand100 = readValues(rand100, new File("inputs/random100.txt"));
		displayList(rand100);
		int[] ints = {12,5,2,7,0,1};
		System.out.println(Arrays.toString(ints));
		int[] sorted = Sorting.shellSort(ints);
		System.out.println(Arrays.toString(sorted));
	}
	
	static LinkedNode<Integer> readValues(LinkedNode<Integer> start, File file){
		try {
			Scanner sc = new Scanner(file);
			LinkedNode<Integer> temp = start;
			while(sc.hasNextInt()) {
				start.setNext(new LinkedNode<Integer>(sc.nextInt()));
				start = start.getNext();
			}
			sc.close();
			return temp.next;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("file not found exception");
			return null;
		}

	}
	
	static void displayList(LinkedNode<Integer> list) {
		System.out.println(list.toString());
	}
}
