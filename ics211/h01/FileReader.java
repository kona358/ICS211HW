package edu.ics211.h01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
	//takes string of filename as input
	public static int getCharInFile(String fileName) {
		//the number of characters in the file, will be updated by the end.
		int numOfChar = 0;
		// creates new file object 
		File f = new File(fileName);
		//create a null scanner here so that the scanner is not local to the try/catch loop
	      Scanner infile = null;
	      
	      try {
	         infile = new Scanner(f);
	      }
	      //IOException catches both incorrect file names and whether the program has access to the file.
	      catch (IOException e) {
	         System.out.println("The file " + fileName + " was not found, or you do not have access to this file");
	         System.out.println("Check to make sure your argument is a valid filename");
	         //return -1 as no file will ever have a length of -1
	         return -1;
	      }
	   
		  // gets the length of the next line, then adds that number to the var
    	  //hasnextline checks if the next line exists.
	      while (infile.hasNextLine()) {
	         numOfChar+=infile.nextLine().length();
	      }
	      return numOfChar;
	}
}
