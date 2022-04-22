package game;

import java.util.Scanner;

public class KeyboardGame {
	Scanner keyboard = new Scanner(System.in);

	public void reset() {
		keyboard.reset();
	}

	public boolean readChar(char affirmativeValue) {
		char c = keyboard.next().charAt(0);
		if (affirmativeValue == c) {
			return true;
		}
		reset();
		return false;
	}

	public int readInt() {
		int i = keyboard.nextInt();
		reset();
		return i;
	}
}
