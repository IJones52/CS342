
public class Tester {

	public static void main(String[] args) {
	/*	if(args != null) {
			HuffmanFrequencyTable table = new HuffmanFrequencyTable(args[0]);
			System.out.println(table.toString());
		}*/
		String input = "Eerie eyes seen near lake.";
		HuffmanFrequencyTable table = new HuffmanFrequencyTable(input);
		System.out.println(table);
		
		int[] test = {52,125, 3456,12,32,35,856,13,2};
		ArrayHeap<Integer> heap = new ArrayHeap<Integer>(10);
		for(int i=0; i < test.length;i++) {
			heap.addElement(test[i]);
		}
		System.out.println(heap.toString());
		heap.removeMin();
		System.out.println(heap.toString());
		
		
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10);
		for(int i = 0; i < test.length; i++) {
			queue.addElement(0, test[i]);
		}
		System.out.println(queue.toString());
		queue.removeMin();
		System.out.println(queue.toString());

	}
}
