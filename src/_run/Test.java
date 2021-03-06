package _run;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Test {

	public static String[] fileNames;
	static final String src = "input";													// Files
	static String consoleInput = "1";

	public static void main(String[] args) throws IOException {

		File folder = new File(src);													
		final String[] mask = {".txt", ".fb2"};											// Mask
		fileNames = folder.list(new FilenameFilter() {								
			@Override
			public boolean accept(File folder, String name) {
				for(String s : mask)
					if(name.toLowerCase().endsWith(s)) return true;
				return false;
			}
		});

		Scanner scan = new Scanner(System.in);
		int counter = 0;

		/*		////////////////////////////////////////////////////////////////////////////////// Dictionary
			for(String fileName : fileNames){
				System.out.println("File: "+fileName + " loaded;");							
				File curFile  = new File (src + "\\" + fileName);								 
				dictionary.Indexation.scanFile(curFile);												
			}
			dictionary.Dictionary.writeToFile();
			dictionary.Dictionary.serialize();

			////////////////////////////////////////////////////////////////////////////////// Matrix of Incidence
			for(String fileName : fileNames){
				System.out.println(counter +" is for Document: "+fileName);							
				File curFile  = new File (src + "\\" + fileName);								 
				matrixOfIncidence.Indexation.scanFile(curFile, counter++);												
			}
			matrixOfIncidence.Matrix.writeToFile();
			matrixOfIncidence.Matrix.serialize();
			System.out.println("Try to search some word in Matrix of Incidence (_ for exit): ");
			while(true){
				System.out.print("Search word: ");
				consoleInput =  scan.nextLine().toLowerCase();
				if(!consoleInput.equals("_"))
					matrixOfIncidence.Matrix.searchWord(consoleInput.toLowerCase());
				else
					break;
			}
			consoleInput=" ";
			System.out.println("Matrix of Incidence boolean search (_ for exit): ");
			System.out.println("words in lowercase + AND, OR, NOT operators.");
			while(true) {
				System.out.print("Search query: ");
				consoleInput =  scan.nextLine();
				int[] result = new int[fileNames.length];
				if(!consoleInput.equals("_")) {
					String[] parts = consoleInput.split(" ");
					for(int i=0; i<parts.length;	) {
						switch(parts[i]) {
							case "AND" : 
								if (parts[i+1].equals("NOT")) {
									int[] notScndArg = matrixOfIncidence.Matrix.operatorNOT(parts[i+2]);
									result = matrixOfIncidence.Matrix.operatorAND(result, notScndArg);
									i += 3;
								}else {
									result = matrixOfIncidence.Matrix.operatorAND(result, matrixOfIncidence.Matrix.word(parts[i+1]));
									i += 2;
								}
								break;
							case "OR" : 
								if (parts[i+1].equals("NOT")) {
									int[] notScndArg = matrixOfIncidence.Matrix.operatorNOT(parts[i+2]);
									result = matrixOfIncidence.Matrix.operatorOR(result, notScndArg);
									i += 3;
								}else {
									result = matrixOfIncidence.Matrix.operatorOR(result, matrixOfIncidence.Matrix.word(parts[i+1]));
									i += 2;
								}
								break;
							case "NOT" :  
								result = matrixOfIncidence.Matrix.operatorNOT(parts[i+1]);
								i += 2;
								break;
							default : 
								result = matrixOfIncidence.Matrix.word(parts[i]);
								i += 1;
								break;
						}
					}
					System.out.println(Arrays.toString(result));
				}else
					break;
			}

			////////////////////////////////////////////////////////////////////////////////// Inverted Index
			for(String fileName : fileNames){
				System.out.println("Document: "+fileName);							
				File curFile  = new File (src + "\\" + fileName);								 
				invertedIndex.Indexation.scanFile(curFile);												
			}
			invertedIndex.InvIndex.writeToFile();
			invertedIndex.InvIndex.serialize();
			consoleInput=" ";
			System.out.println("Inverted Index boolean search (_ for exit): ");
			while(true) {
				System.out.print("Search query: ");
				consoleInput =  scan.nextLine();
				TreeSet<String> result = new TreeSet<String>();
				if(!consoleInput.equals("_")) {
					String[] parts = consoleInput.split(" ");
					for(int i=0; i<parts.length;	) {
						switch(parts[i]) {
							case "AND" : 
								if (parts[i+1].equals("NOT")) {
									TreeSet<String> notScndArg = invertedIndex.InvIndex.operatorNOT(parts[i+2]);
									result = invertedIndex.InvIndex.operatorAND(result, notScndArg);
									i += 3;
								}else {
									result = invertedIndex.InvIndex.operatorAND(result, invertedIndex.InvIndex.word(parts[i+1]));
									i += 2;
								}
								break;
							case "OR" : 
								if (parts[i+1].equals("NOT")) {
									TreeSet<String> notScndArg = invertedIndex.InvIndex.operatorNOT(parts[i+2]);
									result = invertedIndex.InvIndex.operatorOR(result, notScndArg);
									i += 3;
								}else {
									result = invertedIndex.InvIndex.operatorOR(result, invertedIndex.InvIndex.word(parts[i+1]));
									i += 2;
								}
								break;
							case "NOT" :  
								result = invertedIndex.InvIndex.operatorNOT(parts[i+1]);
								i += 2;
								break;
							default : 
								result = invertedIndex.InvIndex.word(parts[i]);
								i += 1;
								break;
						}
					}
					System.out.println(result);
				}else
					break;
			}
		
		////////////////////////////////////////////////////////////////////////////////// Two Word Index
		for(String fileName : fileNames){
			System.out.println("Document: "+fileName);							
			File curFile  = new File (src + "\\" + fileName);								 
			twoWordIndex.Indexation.scanFile(curFile);												
		}
		twoWordIndex.TwoWordIndex.writeToFile();
		twoWordIndex.TwoWordIndex.serialize();
		consoleInput=" ";
		System.out.println("Two Word Index Phrase Search (_ for exit): ");
		while(true) {
			System.out.print("Search query: ");
			consoleInput =  scan.nextLine();
			TreeSet<String> result = new TreeSet<String>();
			if(!consoleInput.equals("_")) {
				try {
					result = twoWordIndex.TwoWordIndex.phraseSearch(consoleInput.toLowerCase());
					System.out.println(result);
				}catch(Exception e) {
					System.out.println(e);
				}
			}else {
				break;
			}
		}
		*/
		////////////////////////////////////////////////////////////////////////////////// Coordinate Inverted Index
		
		for(String fileName : fileNames){
			System.out.println("Document: "+fileName);							
			File curFile  = new File (src + "\\" + fileName);								 
			coordInvIndex.Indexation.scanFile(curFile);												
		}
		coordInvIndex.CoordInvIndex.writeToFile();
		coordInvIndex.CoordInvIndex.serialize();
		consoleInput=" ";
		System.out.println("Coordinate Inverted Index Phrase And Distance Search (_ for exit): "); 
		System.out.println("PLEASE use numbers only for indicating distances (~ A B 123 C)");
		while(true) {
			System.out.print("Search query: ");
			consoleInput =  scan.nextLine();
			TreeSet<String> result = new TreeSet<String>();
			if(!consoleInput.equals("_")) {
				try { 
					String[] inputs = consoleInput.toLowerCase().split(" ");
					ArrayList<String> words = new ArrayList<String>();
					ArrayList<Integer> distances = new ArrayList<Integer>();
					for(int i=0; i<inputs.length;	) {
						if ((i+1)< inputs.length) {
							if (inputs[i+1].matches("^[+-]?\\d+$")) {
								words.add(inputs[i]);
								distances.add(Integer.parseInt(inputs[i+1]));
								i += 2;
							}else { 
								words.add(inputs[i]);
								distances.add(1);
								i += 1;
							}
						}else {
							words.add(inputs[i]);
							break;
						}
					}
					System.out.println(words);
					System.out.println(distances);
					result = coordInvIndex.CoordInvIndex.search(words, distances);
					System.out.println(result);
				}catch(Exception e) {
					System.out.println(e);
				}
			}else {
				break;
			}
		}
		
		scan.close();
	}

}
