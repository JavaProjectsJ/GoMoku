package game;

import java.util.Scanner;

public class KeyboardGame {
	Scanner keyboard = new Scanner(System.in);

	public boolean readChar(char affirmativeValue) {
		char c = keyboard.next().charAt(0);
		if (affirmativeValue == c) {
			return true;
		}
		return false;
	}

	public int readInt() {
		int i = keyboard.nextInt();
		return i;
	}
}
