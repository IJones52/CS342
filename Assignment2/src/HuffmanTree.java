import java.util.ArrayList;

public class HuffmanTree{
	private PriorityQueue<String> queue;
	private int count = 0;
	private ArrayList<String[]> codes =new ArrayList<String[]>();
	

	/**
	 * Builds a new huffman tree object and creates the queue
	 * */
	public HuffmanTree(){
		//Start the size as 8 and add to it
		queue = new PriorityQueue<String>(8);
	}
	
	/**
	 * Adds a new element to the priority queue
	 * */
	public void addNode(String charachter, int frequency ) {
		queue.addElement(charachter, frequency);
		count ++;
	
	}
	
	
	/**
	 * Makes the prioirty queue into a proper tree
	 * */
	public void buildTree() {
		//While there is a left and right node, create a new node which is the sum of the two and re add them to the queue
		while(count > 1) {
			
			HuffmanTreeNode<String> left = queue.removeMin();
			HuffmanTreeNode<String> right = queue.removeMin();
	
			HuffmanTreeNode<String> sum = new HuffmanTreeNode<String>("-", left.getPriority()+right.getPriority());
			sum.left = left;
			sum.right = right;
			queue.addElement(sum);
			count--;

		} 

	}
	
	/**
	 * A method to return the root node of the tree
	 * @return a huffman tree node which is the root of the tree
	 * */
	public HuffmanTreeNode<String> getRoot(){
		HuffmanTreeNode<String> root = queue.removeMin();
		queue.addElement(root);
		return root;
	}
	
	/**
	 * A method that traverses the tree in order to build the code for each letter, then adds them to the list of codes
	 * @param the root node of the tree and an empty string to build
	 * */
	public void buildHuffmanEncodings(HuffmanTreeNode<String> root, String sequence) {
		if(root == null) {return;}
		else {
			//If we're at a leaf take note of the code
			if(root.left == null && root.right ==null) {
				String[] code = {root.getElement().toString(),sequence};
				codes.add(code);
				return;
	
			}
			else {
			//Traverse left and right
			buildHuffmanEncodings(root.left,sequence +"0" );
			buildHuffmanEncodings(root.right, sequence+"1");
			return;}
		}
		
	
	}
	
	/**
	 * A method to return the huffman codes for each letter
	 * @return an array list of String tuples
	 * */
	public ArrayList<String[]> getHuffmanCodes(){
		return codes;
	}
	
	/**
	 * A method that returns the string form of the queue of which the tree is built on
	 * @return the queue in string from
	 * */
	public String toString() {
		return queue.toString();
				
	}
	
	

	
}
