package edu.ics211.h12;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.File;
import java.io.IOException;

public class ReadDoc {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Make sure you include the input file as the argument");
			System.exit(1);
		}
		File f = new File(args[0]);
		Scanner infile = null;
		try {
			infile = new Scanner(f);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		ArrayList<String> wordList = new ArrayList<String>();
		while (infile.hasNext()) {
			String pword = infile.next();
			// System.out.println(pword);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < pword.length(); i++) {
				char ch = pword.charAt(i);
				if (Character.isJavaIdentifierStart(ch)) {
					sb.append(ch);
				}
			}
			String fixStr = sb.toString();
			if (fixStr.length() > 0) {
				wordList.add(fixStr);
			}
		}
		analyze(wordList);
		// wordList contains the words to be added to the BST
	}

	public static void analyze(ArrayList<String> wordList) {
		long startTime = System.currentTimeMillis();
		BinarySearchTree<String, Long> bst = new BinarySearchTree<String, Long>(wordList);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("adding nodes took " + totalTime + "ms");
		System.out.println("the tree has " + bst.countNodes() + " unique strings");
		System.out.println("the tree has depth " +bst.height());
		WordFrequency bstArr[] = bst.toArray();
		java.util.Arrays.sort(bstArr);
		Collections.reverse(Arrays.asList(bstArr));
		
		for(int i = 0; i<10; i++){
			if(bstArr[i] == null) break;
			System.out.println(bstArr[i]);
		}

	}
}
