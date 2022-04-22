package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Play {
	boolean game = true;
	boolean playerTurn = true;
	boolean possibleMove = false;
	boolean exit = false;
	boolean random = false;
	boolean valid = false;
	KeyboardGame keyboardGame = new KeyboardGame();

	List<Player> playerList = new ArrayList<>();
	AsciiArt ascii = new AsciiArt();

	HallOfFame hof = new HallOfFame();

	public void menu() {
		show();
		exit = false;

		chooseBoard(keyboardGame.keyboard);
	}

	private void chooseBoard(Scanner keyboard) {
		int option;
		do {
			System.out.printf("Choose your Go Moku Board:\n" + "\t1.- New board (15x15)\n"
					+ "\t2.- Traditional board (19x19)\n" + "\t3.- Exit\n" + "Choose your option: ");
			option = keyboard.nextInt();
			System.out.println();
			switch (option) {
			case 1:
				newGame(15);
				exit = true;
				break;
			case 2:
				newGame(19);
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

	public void rules() {
		System.out.println("\033[38;5;177mImportant notice!\n"
				+ "The winner will be the first player that align 5 pieces in a vertical,"
				+ " horizontal or crosswise line,\nIf there are more than 5 pieces the player will also win\n\u001B[0m");
	}

	public static void main(String[] args) {
		new Play().menu();
	}

	public void show() {
		// PRESENTAR EL JUEGO Y OPCIONES //
		// GOMUKU BY JOSE
		// MOSTRAR PRESENTACION
		// ESPERAR 3 SEG
		// BORRAR PRESENTACION
		// MOSTRAR OPCIONES
		if (!valid) {
			ascii.asciiArt(1);
			rules();
		} else {
			System.out.println();
		}
	}

	public void newGame(int option) {
		int[] position;
		exit = false;
		Board board = new Board(option);
		/* Create the players */
		System.out.printf("How would you like to play?\n" + "\t1.- Bot vs Bot\n" + "\t2.- Human vs Bot\n"
				+ "\t3.- Human vs Human\n" + "Choose your option: ");
		int playerOption = keyboardGame.readInt();
		Game game = new Game(playerOption);

		/* Clear the console a bit */
		clearConsole();

		/* Create the board */
		board.showBoard();

		Validator validator = new Validator();

		int playerTurn = 0;
		/* Start the game */
		while (game.status) {
			clearConsole();
			try {
				System.out.println("Insert the coordinates " + game.playerList.get(playerTurn).getName());
				position = coordinates();
				possibleMove = validator.validatePosition(position, board);
				board.insertPiece(position[0], position[1], game.playerList.get(playerTurn).getSymbolPiece());
				playerTurn = (playerTurn == 0) ? 1 : 0;
				if (validator.validateWin(board)) {
					game.status = false;
				}
			} catch (Exception e) {
				keyboardGame.keyboard.reset();
				System.out.println(e.getMessage());
			}
			board.showBoard();
			// game.setStatus(false);
		}
		ascii.asciiArt(2);
		showResult();
		reset();
		hof.hallOfFame(game);
	}

	public void reset() {
		System.out.println("Would you like to play again?");
		valid = keyboardGame.readChar('y');
		if (valid) {
			menu();
		}
	}

	@SuppressWarnings("resource")
	public int[] coordinates() {
		Scanner keyboard = new Scanner(System.in);
		String coordinates = keyboard.nextLine();
		String[] coordinates_split = coordinates.split(",");
		int[] positions = new int[2];
		positions[0] = Integer.parseInt(coordinates_split[0]) - 1;
		positions[1] = Integer.parseInt(coordinates_split[1]) - 1;
		return positions;
	}

	public final void clearConsole() {
		System.out.println();
	}

	public void showResult() {
	}
}
