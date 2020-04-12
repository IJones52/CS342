import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] ints = {12,5,2,7,0,1};
		System.out.println(Arrays.toString(ints));
		int[] sorted = Sorting.shellSort(ints);
		System.out.println(Arrays.toString(sorted));
	}
}
