import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Tester {

	public static void main(String[] args) {
		//If we get a console input build a table off it
		if(args.length >0) {
			try {
				//Delete the existing output
				File output = new File("output.txt");
				output.delete();
				//make a new output
				output = new File("output.txt");
				FileWriter myWriter = new FileWriter(output);
			
				
				//Build table, write the necessary info to the output file
				String input = args[0];
				HuffmanFrequencyTable table = new HuffmanFrequencyTable(input);
				myWriter.write(table.toString());
				myWriter.write("Encoded Bit Stream: " + Encoder.getEncodeBitStream(table.getInput(), table.getTable()) + "\n");
				myWriter.write("Total number of bits without Huffman Coding (8-bits per charachter): " + 8*input.length() + "\n");
				myWriter.write("Total number of bits with Huffman Coding: " + Encoder.getEncodeBitStream(table.getInput(), table.getTable()).length() + "\n");
				double compressionRatio = (8*input.length())/Encoder.getEncodeBitStream(table.getInput(), table.getTable()).length();
				myWriter.write("Compression Ratio: " + table.calculateCompressionRatio() + "\n");
				myWriter.write("Decoded String:" + Decoder.decodeTree(Encoder.getEncodeBitStream(table.getInput(), table.getTable()), table.getTree())+ "\n");
				myWriter.close();
				System.out.println("Output written to output.txt");
			}
			catch(IOException e) {
				
			}
			
		}
		//If don't have a console input just build a table based on a string
		else {
			try {
				//Delete the existing table
				File output = new File("output.txt");
				output.delete();
				//Make a new output
				output = new File("output.txt");
				FileWriter myWriter = new FileWriter(output);
				
				//Build table, write the necessary info to the output
				String input = "Eerie eyes seen near lake.";
				HuffmanFrequencyTable table = new HuffmanFrequencyTable(input);
				myWriter.write(table.toString());
				myWriter.write("Encoded Bit Stream: " + Encoder.getEncodeBitStream(table.getInput(), table.getTable()) + "\n");
				myWriter.write("Total number of bits without Huffman Coding (8-bits per charachter): " + 8*input.length() + "\n");
				myWriter.write("Total number of bits with Huffman Coding: " + Encoder.getEncodeBitStream(table.getInput(), table.getTable()).length() + "\n");
				double compressionRatio = (8*input.length())/Encoder.getEncodeBitStream(table.getInput(), table.getTable()).length();
				myWriter.write("Compression Ratio: " + table.calculateCompressionRatio() + "\n");
				myWriter.write("Decoded String:" + Decoder.decodeTree(Encoder.getEncodeBitStream(table.getInput(), table.getTable()), table.getTree())+ "\n");
				myWriter.close();
				System.out.println("Output written to output.txt");
			}
			catch(IOException e) {
				
			}
			
		}
		

	}
}
