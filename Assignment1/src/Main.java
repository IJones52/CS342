import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		LinkedNode<Integer> rand100 = new LinkedNode<Integer>();
		rand100 = readValues(rand100, new File("inputs/random100.txt"));		
		long start = System.currentTimeMillis();
		rand100 =Sorting.shellSort(rand100);
		long end = System.currentTimeMillis();
		ArrayList<String> rand100Output = resultShellSort();
		float sec = (end-start)/1000F;
		writeOutput(rand100Output,"rand100",sec);
		displayList(rand100);
		
		LinkedNode<Integer> rand1000 = new LinkedNode<Integer>();
		rand1000 = readValues(rand1000, new File("inputs/random1000.txt"));
		start = System.currentTimeMillis();
		rand1000 =Sorting.shellSort(rand1000);
		end = System.currentTimeMillis();
		ArrayList<String> rand1000Output = resultShellSort();
		sec = (end-start)/1000F;
		writeOutput(rand1000Output,"rand1000",sec);
		displayList(rand1000);
		
		LinkedNode<Integer> rand10000 = new LinkedNode<Integer>();
		rand10000 = readValues(rand10000, new File("inputs/random10000.txt"));
		start = System.currentTimeMillis();
		rand10000=Sorting.shellSort(rand10000);
		end = System.currentTimeMillis();
		ArrayList<String> rand10000Output = resultShellSort();
		sec = (end-start)/1000F;
		writeOutput(rand10000Output,"rand10000",sec);
		displayList(rand10000);
		
		

	}
	
	public static LinkedNode<Integer> readValues(LinkedNode<Integer> start, File file){
		try {
			Scanner sc = new Scanner(file);
			LinkedNode<Integer> temp = start;
			while(sc.hasNextInt()) {
				start.setNext(new LinkedNode<Integer>(sc.nextInt()));
				start = start.getNext();
			}
			sc.close();
			return temp.getNext();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("file not found exception");
			return null;
		}

	}
	
	public static void displayList(LinkedNode<Integer> list) {
		System.out.println(list.toString());
	}
	
	public static void writeOutput(ArrayList<String> output, String inputName,float time) {
		try {
			File outputFile = new File("Output.txt");
			FileWriter writer = new FileWriter(outputFile,true);
			writer.write("Input: " + inputName+"\n");
			writer.write("Time Taken: "+ time+" seconds\n");
			writer.write("     k  pass     cmp     exch\n");
			writer.write("-----------------------------\n");
			for(int i = 0; i < output.size()-1; i ++) {
				writer.write(output.get(i) + "\n");
			}
			writer.write("-----------------------------\n");
			writer.write(output.get(output.size()-1)+"\n");
			writer.write("\n\n");
			writer.close();
			System.out.println("File generated");
		}
		catch(IOException e) {
			System.out.println("Error occured in output generation");
		}

		
	}
	
	public static ArrayList<String> resultShellSort() {	
		return Sorting.getOutput();
	}
}
