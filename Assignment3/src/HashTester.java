import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class HashTester {
	/**
	 * About my hashfunction. Theoretically it runs in O(1) time. There are no loops and no other methods that depend on the length of the file. 
	 * But it does end up taking more time than the java Hashtable class
	 * 
	 * */
	public static void main(String[] args) {
	if(args.length > 1) {
			try {
	
				File input = new File(args[0]);
				File output = new File(args[1]);
				output.delete();
				output = new File(args[1]);
				File words = new File("words.txt");
		

				Scanner sc = new Scanner(words);
		
	
				HashTable table  = new HashTable(199997);
				Hashtable<String, String> javaTable = new Hashtable<String, String>(199997);
				long start = System.currentTimeMillis();
				while(sc.hasNext()) {
	

					//Take the next string and clean all non-letters and set to lowercase
					String str = sc.next();
					str = str.replaceAll("[^a-zA-Z0-9]", "");
					str = str.toLowerCase();
					
					//Put it into the hashtable
					table.hash(str);
				}
				long end = System.currentTimeMillis();				
				System.out.println("Hashing completed with " + table.getCollisions() + " collisions. Hashing took: " + (end-start) + " milliseconds");
				
				 sc = new Scanner(words);
				 start = System.currentTimeMillis();
				 while(sc.hasNext()) {
						

						//Take the next string and clean all non-letters and set to lowercase
						String str = sc.next();
						str = str.replaceAll("[^a-zA-Z0-9]", "");
						str = str.toLowerCase();
						
						//Put it into the hashtable
						javaTable.put(table.getAlphagram(str), str);
					}
				 end = System.currentTimeMillis();
				 System.out.println("Java Hashtable class hashing took " + (end-start)  + " milliseconds");
				
				//Read the input
				sc  = new Scanner(input);
				FileWriter writer = new FileWriter(output);
				while(sc.hasNext()) {
					//Select next input
					String in = sc.next();
					in = in.replaceAll("[^a-zA-Z0-9]", "");
					in = in.toLowerCase();
					//Get all anagrams of the input, write to output
					String anagrams = table.findAnagrams(in);
					//Write the anagarams
					writer.write(in + ": "+ anagrams + "\n");
					
					
				}
				writer.close();
				sc.close();
				System.out.println("Output written to: " + output.getAbsolutePath());
			}
			catch(IOException e) {
				System.out.println("Input file error");
			}
		}
	
		else {
			System.out.println("Try running again like: \"HashTester inputfile outputfile\"");
		}
	}
}
