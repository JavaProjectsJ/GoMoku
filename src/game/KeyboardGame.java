package game;

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
	 * @return true when the char is the affirmative value
	 */
	public boolean readChar(char affirmativeValue) {
		char c = keyboard.next().charAt(0);
		if (affirmativeValue == c) {
			return true;
		}
		reset();
		return false;
	}

	/**
	 * Method that read an int
	 * 
	 * @return an int
	 */
	public int readInt() {
		int i = keyboard.nextInt();
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
