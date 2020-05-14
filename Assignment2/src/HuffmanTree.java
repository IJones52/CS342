
public class HuffmanTree{
	private PriorityQueue<String> queue;
	private int count = 0;

	
	public HuffmanTree(){
		//Start the size as 8 and add to it
		queue = new PriorityQueue<String>(8);
	}
	
	public void addNode(String charachter, int frequency ) {
		queue.addElement(charachter, frequency);
		count ++;
	}
	
	public void buildTree() {
		while(count > 0) {
			
			HuffmanTreeNode<String> left = queue.removeMin();
			HuffmanTreeNode<String> right = queue.removeMin();
			if(right != null && left != null) {
				HuffmanTreeNode<String> sum = new HuffmanTreeNode<String>("", left.getPriority()+right.getPriority());
				sum.left = left;
				sum.right = right;
				queue.addElement(sum);
				count--;
			}
			else if(right == null) {
				HuffmanTreeNode<String> sum = new HuffmanTreeNode<String>("", left.getPriority());
				sum.left = left;
				sum.right = right;
				queue.addElement(sum);
				count--;
			}
		}

	}
	
	public HuffmanTreeNode<String> getRoot(){
		HuffmanTreeNode<String> root =queue.removeMin();
		queue.addElement(root);
		return root;
	}
	
	public String buildHuffmanEncodings(HuffmanTreeNode<String> root, String sequence, String letter) {
		if(root != null) {
			if (root.left != null) {buildHuffmanEncodings(root.left,sequence +"0",letter);}
			else if(root.right != null) {buildHuffmanEncodings(root.right,sequence+"1",letter);}
			else {System.out.println(sequence);}
		}
		return sequence;
	
	}
	
	public String toString() {
		return queue.toString();
	}
	
	
}
