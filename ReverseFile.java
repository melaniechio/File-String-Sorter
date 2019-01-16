package ExtraCredit;

import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class ReverseFile {

	// generate strings of random lengths
	public static String ranStrings() {
		String ranString = "";
		char ranChar;
		
		for (int j = 0; j < (int)(Math.random()*((10-3)+1)+3); j++){
			ranChar = (char)('a' + (int)('z' - 'a')*Math.random());
			ranString = ranString + ranChar;
		}
		return ranString;
	}
	
	public static void main(String [] args) throws Exception {
		File file = new File("randStrings.txt");
		file.createNewFile();
		PrintWriter output = new PrintWriter(file);
		
		// adding 100 strings of random lengths to file
		for (int i = 0; i < 100; i++) {
			output.println(ranStrings());
		}
		output.close();
		
		// adding strings from file into an arraylist and bubble sorting them
		Scanner input = new Scanner(file);
		ArrayList<String> ranStrings = new ArrayList<>();
		while (input.hasNextLine()) {
			ranStrings.add(input.nextLine());
		}
		input.close();
		
		for (int i = 0; i < ranStrings.size()-1; i++) {
			for (int j = 0; j < ranStrings.size()-i-1; j++) {
				if (ranStrings.get(j).compareTo(ranStrings.get(j+1)) > 0) {
					String temp = ranStrings.get(j);
					ranStrings.set((j),ranStrings.get(j+1));
					ranStrings.set(j+1, temp);
				}
			}
		}
		
		// adding sorted strings back into file
		PrintWriter finalOutput = new PrintWriter(file);
		for (int i = 0; i < ranStrings.size(); i++) {
			finalOutput.println(ranStrings.get(i));
		}
		finalOutput.close();
	}
	
}
