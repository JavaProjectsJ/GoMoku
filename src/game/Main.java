package game;

public class Main {
	boolean exit = false;
	boolean valid = false;
	static boolean firstGame = true;
	KeyboardGame keyboardGame = new KeyboardGame();

	private void chooseBoard(KeyboardGame keyboard) {
		int option;
		do {
			System.out.printf("Choose your Go Moku Board:\n" + "\t1.- New board [15x15]\n"
					+ "\t2.- Traditional board [19x19](Bot is not implemented)\n" + "\t3.- Exit\n"
					+ "Choose your option: ");
			option = keyboard.readInt();
			System.out.println();
			switch (option) {
			case 1:
				new Play().newGame(15);
				exit = true;
				break;
			case 2:
				new Play().newGame(19);
				exit = true;
				break;
			case 3:
				System.out.println("Stopping the game execution");
				exit = true;
				break;
			default:
				System.out.println("Invalid option\nTry it again!\n");
				exit = false;
				break;
			}
		} while (!exit);
	}

	public void menu(boolean firstGame) {
		show(firstGame);
		exit = false;

		chooseBoard(keyboardGame);
	}

	public void rules() {
		System.out.println("\033[38;5;177mImportant notice!\n"
				+ " - The winner will be the first player that align 5 pieces in a vertical,"
				+ " horizontal or crosswise line,\nif there are more than 5 pieces the player will also win\n"
				+ " - Coordinates have to be written like in chess, example: A,2! You have been advertised\n\u001B[0m");
	}

	public void show(boolean firstGame) {
		if (firstGame) {
			new AsciiArt().asciiArt(1);
			rules();
		} else {
			System.out.println();
		}
	}

	public void reset() {
		System.out.println("Would you like to play again?");
		valid = keyboardGame.readChar('y');
		if (valid) {
			menu(false);
		}
	}

	public static void main(String[] args) {
		new Main().menu(true);
	}
}
