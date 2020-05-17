import java.util.ArrayList;

public class HuffmanTree{
	private PriorityQueue<String> queue;
	private int count = 0;
	private ArrayList<String[]> codes =new ArrayList<String[]>();
	

	
	public HuffmanTree(){
		//Start the size as 8 and add to it
		queue = new PriorityQueue<String>(8);
	}
	
	public void addNode(String charachter, int frequency ) {
		queue.addElement(charachter, frequency);
		count ++;
	
	}
	
	public void buildTree() {
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
	
	public HuffmanTreeNode<String> getRoot(){
		HuffmanTreeNode<String> root = queue.removeMin();
		queue.addElement(root);
		return root;
	}
	
	
	public void buildHuffmanEncodings(HuffmanTreeNode<String> root, String sequence) {
		if(root == null) {return;}
		else {
			if(root.left == null && root.right ==null) {
				String[] code = {root.getElement().toString(),sequence};
				codes.add(code);
				return;
	
			}
			else {
			
			buildHuffmanEncodings(root.left,sequence +"0" );
			buildHuffmanEncodings(root.right, sequence+"1");
			return;}
		}
		
	
	}
	
	public ArrayList<String[]> getHuffmanCodes(){
		return codes;
	}
	
	public String toString() {
		return queue.toString();
				
	}
	
	

	
}
