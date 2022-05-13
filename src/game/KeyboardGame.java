package game;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Custom keyboard class
 * 
 * @author jmpfbmx
 * @version 1.0
 * @since 1.0
 */
public class KeyboardGame {
	/**
	 * Generate the keyboard.
	 */
	Scanner keyboard = new Scanner(System.in);

	/**
	 * Method for resetting the keyboard
	 */
	public void reset() {
		keyboard.reset();
	}

	/**
	 * Method that read a char and if it is the affirmative value
	 * returns a true
	 * 
	 * @param affirmativeValue
	 * @param negativeValue
	 * @return true when the char is the affirmative value
	 */
	public boolean readChar(char affirmativeValue, char negativeValue) {
		char c;
		boolean exit = false;
		do {
			System.out.printf("Valid values are %s - %s\n", affirmativeValue, negativeValue);
			c = keyboard.next().charAt(0);
			if (c == affirmativeValue || c == negativeValue) {
				exit = true;
				if (c == affirmativeValue) {
					return true;
				} else if (c == negativeValue) {
					return false;
				}
			}
		} while (!exit);
		reset();
		return false;
	}

	/**
	 * Method that read an int
	 * 
	 * @return an int
	 */
	public int readInt() {
		int i = 0;
		boolean exit = false;
		do {
			try {
				i = keyboard.nextInt();
				exit = true;
			} catch (InputMismatchException e) {
				reset();
			}
		} while (!exit);
		reset();
		return i;
	}

	/**
	 * Method that read a String
	 * 
	 * @return a String
	 */
	public String readString() {
		String s = keyboard.nextLine();
		return s;
	}
}
