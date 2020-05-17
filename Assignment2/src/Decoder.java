
public class Decoder {
	/**
	 * A method to take the encoded huffman string and traverse the tree to decode it
	 * @return the original input string
	 * */
	public static String decodeTree(String encoded, HuffmanTree tree) {
		HuffmanTreeNode<String> root = tree.getRoot();
		HuffmanTreeNode<String> temp = root;
		String decoded = "";
		for(int i = 0; i < encoded.length()+1; i++) {
			if(temp.left == null && temp.right == null) {
				decoded += temp.getElement();
				temp = root;
			
			}
			if(i < encoded.length() && encoded.charAt(i) == '0') {
				temp = temp.left;
			}
			else {
				temp = temp.right;
			}
		}
		return decoded;
		
	}
}
