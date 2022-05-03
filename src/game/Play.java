package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Play {
	AsciiArt ascii = new AsciiArt();
	HallOfFame hof = new HallOfFame();
	KeyboardGame keyboardGame = new KeyboardGame();
	List<Player> playerList = new ArrayList<>();
	Player player1;
	Player player2;
	boolean status = true;
	boolean game = true;
	boolean playerTurn = true;
	boolean possibleMove = false;
	boolean exit = false;
	boolean random = false;
	boolean valid = false;

	/* Pasar los menus a una clase main.... */
	public void menu() {
		show();
		exit = false;

		chooseBoard(keyboardGame);
	}

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
				+ " - The winner will be the first player that align 5 pieces in a vertical,"
				+ " horizontal or crosswise line,\nif there are more than 5 pieces the player will also win\n"
				+ " - Coordinates have to be written like in chess, example: A,2! You have been advertised\n\u001B[0m");
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

	@SuppressWarnings({ "unused", "resource" })
	public List<Player> players(int option) {
		boolean exit = false;
		boolean random = false;
		Scanner keyboard = new Scanner(System.in);
		String name = "";
		String player1_name = "";
		String player2_name = "";
		int randomPiece = (int) (Math.random() * (2 - 1 + 1) + 1);
		System.out.println("\nWould you like to randomize who will start?");
		if (keyboardGame.readChar('y')) {
			random = true;
		} else {
			random = false;
		}
		do {
			System.out.println();
			switch (option) {
			case 1:
				if (random) {
					if (randomPiece == 1) {
						// bot1 = new Bot(name, 1, true);
						// bot2 = new Bot(name, 2, false);
						player1 = new BotString(name, true);
						player2 = new BotString(name, false);
						playerList = Arrays.asList(player1, player2);
					} else {
						// bot2 = new Bot(name, 1, true);
						// bot1 = new Bot(name, 2, false);
						player2 = new BotString(name, true);
						player1 = new BotString(name, false);
						playerList = Arrays.asList(player2, player1);
					}
				} else {
					// bot1 = new Bot(name, 1, true);
					// bot2 = new Bot(name, 2, false);
					player1 = new BotString(name, true);
					player2 = new BotString(name, false);
					playerList = Arrays.asList(player1, player2);
				}
				exit = true;
				break;
			case 2:
				System.out.println("Which is your name player 1?");
				player1_name = keyboard.nextLine();
				if (random) {
					if (randomPiece == 1) {
						player1 = new Human(player1_name, true);
						player2 = new BotString(name, false);
						playerList = Arrays.asList(player1, player2);
					} else {
						player1 = new BotString(name, true);
						player2 = new Human(player1_name, false);
						playerList = Arrays.asList(player2, player1);
					}
				} else {
					player1 = new Human(player1_name, true);
					player2 = new BotString(name, false);
					playerList = Arrays.asList(player1, player2);
				}

				exit = true;
				break;
			case 3:
				System.out.println("Which is your name player 1?");
				player1_name = keyboard.nextLine();
				System.out.println("\nWhich is your name player 2?");
				player2_name = keyboard.nextLine();
				if (random) {
					if (randomPiece == 1) {
						player1 = new Human(player1_name, true);
						player2 = new Human(player2_name, false);
						playerList = Arrays.asList(player1, player2);
					} else {
						player1 = new Human(player2_name, true);
						player2 = new Human(player1_name, false);
						playerList = Arrays.asList(player2, player1);
					}
				} else {
					player1 = new Human(player1_name, true);
					player2 = new Human(player2_name, false);
					playerList = Arrays.asList(player1, player2);
				}
				exit = true;
				break;
			default:
				System.out.println("Invalid option\nTry it again!\n");
				exit = false;
				break;
			}
		} while (!exit);
		keyboardGame.keyboard.reset();
		return playerList;
	}

	public void newGame(int option) {
		Board board = new Board(option);
		Validator validator = new Validator();
		int playerTurn = 0;
		int[] position;

		/* Create the players */
		System.out.printf("How would you like to play?\n" + "\t1.- Bot vs Bot\n" + "\t2.- Human vs Bot\n"
				+ "\t3.- Human vs Human\n" + "Choose your option: ");
		int playerOption = keyboardGame.readInt();
		players(playerOption);

		/* Clear the console a bit */
		clearConsole();

		/* Create the board */
		board.showBoard();

		/* Reset the keyboard */
		keyboardGame.keyboard.reset();

		/* Start the game */
		while (status) {
			clearConsole();
			try {
				System.out.println("Insert the coordinates " + playerList.get(playerTurn).getName());
				position = playerList.get(playerTurn).returnCoordinates(board);
				validator.validatePosition(position, board);
				board.insertPiece(position[0], position[1], playerList.get(playerTurn).getPiece());
				status = (validator.validateWin(board)) ? false : true;
				playerTurn = (playerTurn == 0) ? 1 : 0;
				position = playerList.get(playerTurn).returnCoordinates(board);
			} catch (Exception e) {
				keyboardGame.keyboard.reset();
				// System.out.println(e.getMessage());
			}
			board.showBoard();
		}
		ascii.asciiArt(2);
		showResult();
		reset();
		hof.hallOfFame(playerList);
	}

	public void reset() {
		System.out.println("Would you like to play again?");
		valid = keyboardGame.readChar('y');
		if (valid) {
			menu();
		}
	}

	public final void clearConsole() {
		System.out.println();
	}

	public void showResult() {
	}
}