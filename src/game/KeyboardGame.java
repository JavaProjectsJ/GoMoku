package game;

import java.util.Scanner;

public class KeyboardGame {
	Scanner keyboard = new Scanner(System.in);

	@SuppressWarnings("resource")
	public boolean readChar(char affirmativeValue) {
		char c = keyboard.next().charAt(0);
		if (affirmativeValue == c) {
			return true;
		}
		return false;
	}
}
