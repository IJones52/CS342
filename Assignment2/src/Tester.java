
public class Tester {

	public static void main(String[] args) {
		if(args.length >0) {
			String input = args[0];
			HuffmanFrequencyTable table = new HuffmanFrequencyTable(input);
			System.out.println(table);
			System.out.println("Encoded Bit Stream: " + table.getEncodeBitStream());
			System.out.println("Total number of bits without Huffman Coding (8-bits per charachter): " + 8*input.length() );
			System.out.println("Total number of bits with Huffman Coding: " + table.getEncodeBitStream().length());
			double compressionRatio = (8*input.length())/table.getEncodeBitStream().length();
			System.out.println("Compression Ratio: " + compressionRatio);
			System.out.println("Decoded String:" + table.decodeTree(table.getEncodeBitStream()));
		}
		String input = "Eerie eyes seen near lake.";
		HuffmanFrequencyTable table = new HuffmanFrequencyTable(input);
		System.out.println(table);
		System.out.println("Encoded Bit Stream: " + table.getEncodeBitStream());
		System.out.println("Total number of bits without Huffman Coding (8-bits per charachter): " + 8*input.length() );
		System.out.println("Total number of bits with Huffman Coding: " + table.getEncodeBitStream().length());
		double compressionRatio = (8*input.length())/table.getEncodeBitStream().length();
		System.out.println("Compression Ratio: " + compressionRatio);
		System.out.println("Decoded String:" + table.decodeTree(table.getEncodeBitStream()));
		
		/*int[] test = {124,1325,21,3,1,12,2};
		ArrayHeap<Integer> heap = new ArrayHeap<Integer>(10);
		for(int i=0; i < test.length;i++) {
			heap.addElement(test[i]);
		}
		System.out.println(heap.toString());
		heap.removeMin();
		System.out.println(heap.toString());
		
		
	
		PriorityQueue<String> queue = new PriorityQueue<String>(10);
		for(int i = 0; i < test.length; i++) {
			queue.addElement("-", test[i]);
		}
		System.out.println(queue.toString());
		queue.removeMin();
		System.out.println(queue.toString());
		
		HuffmanTree tree = new HuffmanTree();
		String testStr = "uniq str";
		for(int i =0; i< testStr.length(); i++) {
			tree.addNode(testStr.charAt(i)+"", i);
		}
		System.out.println(tree.toString());
		tree.buildTree();
		System.out.println(tree.toString());*/

	}
}
