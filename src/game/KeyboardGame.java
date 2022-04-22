package game;

import java.util.Scanner;

public class KeyboardGame {
	@SuppressWarnings("resource")
	public boolean readChar(char affirmativeValue) {
		Scanner keyboard = new Scanner(System.in);
		char c = keyboard.next().charAt(0);
		if (affirmativeValue == c) {
			return true;
		}
		return false;
	}
}
