import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
	//Random 100
	LinkedNode<Integer> rand100 = new LinkedNode<Integer>();
	rand100 = readValues(rand100, new File("inputs/random100.txt"));		
	long start = System.currentTimeMillis();
	rand100 =Sorting.shellSort(rand100);
	long end = System.currentTimeMillis();
	ArrayList<String> rand100Output = resultShellSort();
	float sec = (end-start)/1000F;
	writeOutput(rand100Output,"rand100",sec);
	displayList(rand100);
	//Random 1000
	LinkedNode<Integer> rand1000 = new LinkedNode<Integer>();
	rand1000 = readValues(rand1000, new File("inputs/random1000.txt"));
	start = System.currentTimeMillis();
	rand1000 =Sorting.shellSort(rand1000);
	end = System.currentTimeMillis();
	ArrayList<String> rand1000Output = resultShellSort();
	sec = (end-start)/1000F;
	writeOutput(rand1000Output,"rand1000",sec);
	displayList(rand1000);
	//Random 10000
	LinkedNode<Integer> rand10000 = new LinkedNode<Integer>();
	rand10000 = readValues(rand10000, new File("inputs/random10000.txt"));
	start = System.currentTimeMillis();
	rand10000=Sorting.shellSort(rand10000);
	end = System.currentTimeMillis();
	ArrayList<String> rand10000Output = resultShellSort();
	sec = (end-start)/1000F;
	writeOutput(rand10000Output,"rand10000",sec);
	displayList(rand10000);
	//In order 100
	LinkedNode<Integer> inorder100 = new LinkedNode<Integer>();
	inorder100 = readValues(inorder100, new File("inputs/inorder100.txt"));		
	 start = System.currentTimeMillis();
	 inorder100 =Sorting.shellSort(inorder100);
	end = System.currentTimeMillis();
	ArrayList<String> inorder100Output = resultShellSort();
	sec = (end-start)/1000F;
	writeOutput(inorder100Output,"inorder100",sec);
	displayList(inorder100);
	//In order 1000
	LinkedNode<Integer> inorder1000 = new LinkedNode<Integer>();
	inorder1000 = readValues(inorder1000, new File("inputs/inorder1000.txt"));
	start = System.currentTimeMillis();
	inorder1000 =Sorting.shellSort(inorder1000);
	end = System.currentTimeMillis();
	ArrayList<String> inorder1000Output = resultShellSort();
	sec = (end-start)/1000F;
	writeOutput(inorder1000Output,"inorder1000",sec);
	displayList(inorder1000);
	//In order 10000
	LinkedNode<Integer> inorder10000 = new LinkedNode<Integer>();
	inorder10000 = readValues(inorder10000, new File("inputs/inorder10000.txt"));
	start = System.currentTimeMillis();
	inorder10000=Sorting.shellSort(inorder10000);
	end = System.currentTimeMillis();
	ArrayList<String> inorder10000Output = resultShellSort();
	sec = (end-start)/1000F;
	writeOutput(inorder10000Output,"inorder10000",sec);
	displayList(inorder10000);
	//Reverse 100
	LinkedNode<Integer> reverse100 = new LinkedNode<Integer>();
	reverse100 = readValues(reverse100, new File("inputs/reverse100.txt"));		
	 start = System.currentTimeMillis();
	 reverse100 =Sorting.shellSort(reverse100);
	end = System.currentTimeMillis();
	ArrayList<String> reverse100Output = resultShellSort();
	sec = (end-start)/1000F;
	writeOutput(reverse100Output,"reverse100",sec);
	displayList(reverse100);
	//Reverse 1000
	LinkedNode<Integer> reverse1000 = new LinkedNode<Integer>();
	reverse1000 = readValues(reverse1000, new File("inputs/reverse1000.txt"));
	start = System.currentTimeMillis();
	reverse1000 =Sorting.shellSort(reverse1000);
	end = System.currentTimeMillis();
	ArrayList<String> reverse1000Output = resultShellSort();
	sec = (end-start)/1000F;
	writeOutput(reverse1000Output,"reverse1000",sec);
	displayList(reverse1000);
	//Reverse 10000
	LinkedNode<Integer> reverse10000 = new LinkedNode<Integer>();
	reverse10000 = readValues(reverse10000, new File("inputs/reverse10000.txt"));
	start = System.currentTimeMillis();
	reverse10000=Sorting.shellSort(reverse10000);
	end = System.currentTimeMillis();
	ArrayList<String> reverse10000Output = resultShellSort();
	sec = (end-start)/1000F;
	writeOutput(reverse10000Output,"reverse10000",sec);
	displayList(reverse10000);
		

	}
	
	/**
	 * Reads the values from the given file
	 * @param a file the head of a list
	 * @return the head of a list with the values in the file
	 * */
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
	
	
	/**
	 * Takes the list and prints the toString function
	 * @param a head node
	 * */
	public static void displayList(LinkedNode<Integer> list) {
		System.out.println(list.toString());
	}
	
	/**
	 * A method that appends the output of a given list to a file
	 * @param the output list, the name of the list, the time taken to sort
	 * */
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
			System.out.println("Text appended");
		}
		catch(IOException e) {
			System.out.println("Error occured in output generation");
		}

		
	}
	
	
	/**
	 * Gets the output of the sort
	 * @return an arrayList with the sorting info
	 * */
	public static ArrayList<String> resultShellSort() {	
		return Sorting.getOutput();
	}
}
