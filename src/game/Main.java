package game;

/**
 * Main class
 * 
 * @author jmpfbmx
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class Main {
	/**
	 * Is used for exiting from the menu.
	 */
	boolean exit = false;

	/**
	 * Is used for reseting the game.
	 */
	boolean valid = false;

	/**
	 * If it is the first game, rules and asciiArt will be printed.
	 */
	static boolean firstGame = true;

	/**
	 * It just create the keyboard.
	 */
	KeyboardGame keyboardGame = new KeyboardGame();

	/**
	 * This is the main menu of my game,
	 * you can choose the board you would like to use
	 * or if you want to exit from the game.
	 * 
	 * @param keyboard (For choosing the board or if you want to exit).
	 */
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

	/**
	 * It just call shows and chooseBoard method.
	 * 
	 * @param firstGame (Is needed for don't showing once again the rules and the
	 *                  ascii art)
	 */
	public void menu(boolean firstGame) {
		show(firstGame);
		exit = false;

		chooseBoard(keyboardGame);
	}

	/**
	 * It just contain the rules of the games.
	 */
	public void rules() {
		System.out.println("\033[38;5;177mImportant notice!\n"
				+ " - The winner will be the first player that align 5 pieces in a vertical,"
				+ " horizontal or crosswise line,\nif there are more than 5 pieces the player will also win\n"
				+ " - Coordinates have to be written like in chess, example: A,2! You have been advertised\n\u001B[0m");
	}

	/**
	 * It just show for the first time you execute the game the ascii art and the
	 * rules of it.
	 * 
	 * @param firstGame (Is needed for don't showing once again the rules and the
	 *                  ascii art)
	 */
	public void show(boolean firstGame) {
		if (firstGame) {
			new AsciiArt().asciiArt(1);
			rules();
		} else {
			System.out.println();
		}
	}

	/**
	 * It just reset the game
	 */
	public void reset() {
		System.out.println("Would you like to play again?");
		valid = keyboardGame.readChar('y');
		if (valid) {
			menu(false);
		}
	}

	/**
	 * It just call the menu sending a true to it.
	 * 
	 * @param args (Is used when you want to run the game using custom java
	 *             arguments)
	 */
	public static void main(String[] args) {
		new Main().menu(true);
	}
}
