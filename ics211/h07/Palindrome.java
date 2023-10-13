package edu.ics211.h07;

import java.util.concurrent.ThreadLocalRandom;

public class Palindrome {

	public static void main(String[] args) {
		int choice = ThreadLocalRandom.current().nextInt(1, 4);
		StackInterface<Character> stack = null;

		switch (choice) {
			case 1:
				stack = new ArrayStack<Character>();
				System.out.println("The type of stack is ArrayStack");

				break;
			case 2:
				stack = new LinkedStack<Character>();
				System.out.println("The type of stack is LinkedStack");
				break;
			case 3:
				stack = new JavaStandardLibraryStack<Character>();
				System.out.println("The type of stack is JavaStandardLibraryStack");

		}
		/*
		 * Use selection statement with three cases for the choice of stack:
		 * ArrayStack, LinkedStack or JavaStandardLibraryStack.
		 * For each case, be sure to display what type of stack is being used.
		 * For each choice, you need to properly construct stack.
		 */
		if (args.length == 0) {
			runTests(stack);
		} else {
			for (String arg : args) {
				try {
					System.out.println("Is \"" + arg + "\" a palindrome? " + isPalindrome(stack, arg));
				} catch (FullStackException e) {
					System.out
							.println("The String " + arg + " overflows the ArrayStack which has a max of 6 characters");
				} finally { // to clear out stack in case String is not a palindrome
					while (!stack.empty()) {
						stack.pop();
					}
				}
			}
		}
	}

	private static boolean isPalindrome(StackInterface<Character> stack, String testStr) {
		for (Character ch : testStr.toCharArray()) {
			if (Character.isLetter(ch)) {
				stack.push(ch);
			}

		}

		for (Character ch2 : testStr.toCharArray()) {
			if (Character.isLetter(ch2)) {
				if (Character.toUpperCase(ch2) != Character.toUpperCase(stack.pop())) {
					return false;
				}

			}
		}
		return true;
	}

	private static void runTests(StackInterface<Character> stack) {
		String[] testStrings = { "radar", "racecar", "Was it a car or a cat I saw?", "radars", "cat", "palindrome",
				"starwars" };
		for (String test : testStrings) {
			try {
				System.out.println("Is \"" + test + "\" a palindrome? " + isPalindrome(stack, test));
			} catch (FullStackException e) {
				System.out.println(
						"The String \"" + test + "\" overflows the ArrayStack which has a max of 6 characters");
			} finally { // clear stack when String is not a palindrome
				while (!stack.empty()) {
					stack.pop();
				}
			}
		}
	}

}
