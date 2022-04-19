package game;

import java.util.Scanner;

public class Play {
	static boolean game = true;
	static boolean playerTurn = true;
	static boolean possibleMove = false;
	static boolean exit = false;
	static Player bot1;
	static Player bot2;
	static Player human1;
	static Player human2;

	public static void asciiArt(int option) {
		switch (option) {
		case 1:
			System.out.printf(
					"                                                                                                                 \n"
							+ " ██████╗  ██████╗ ███╗   ███╗ ██████╗ ██╗  ██╗██╗   ██╗    ██████╗ ██╗   ██╗         ██╗ ██████╗ ███████╗███████╗\n"
							+ "██╔════╝ ██╔═══██╗████╗ ████║██╔═══██╗██║ ██╔╝██║   ██║    ██╔══██╗╚██╗ ██╔╝         ██║██╔═══██╗██╔════╝██╔════╝\n"
							+ "██║  ███╗██║   ██║██╔████╔██║██║   ██║█████╔╝ ██║   ██║    ██████╔╝ ╚████╔╝          ██║██║   ██║███████╗█████╗  \n"
							+ "██║   ██║██║   ██║██║╚██╔╝██║██║   ██║██╔═██╗ ██║   ██║    ██╔══██╗  ╚██╔╝      ██   ██║██║   ██║╚════██║██╔══╝  \n"
							+ "╚██████╔╝╚██████╔╝██║ ╚═╝ ██║╚██████╔╝██║  ██╗╚██████╔╝    ██████╔╝   ██║       ╚█████╔╝╚██████╔╝███████║███████╗\n"
							+ " ╚═════╝  ╚═════╝ ╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═╝ ╚═════╝     ╚═════╝    ╚═╝        ╚════╝  ╚═════╝ ╚══════╝╚══════╝\n"
							+ "                                                                                                                 \n");
			break;
		case 2:
			System.out.printf(
					"                                                                                                                 \n"
							+ " ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗ \n"
							+ "██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗\n"
							+ "██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝\n"
							+ "██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗\n"
							+ "╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║\n"
							+ " ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝\n"
							+ "                                                                          \n");
			break;
		}
	}

	public static char readChar(String validCharacters) {
		Scanner keyboard = new Scanner(System.in);
		char c;
		boolean exit = true;
		do {
			c = keyboard.next().charAt(0);
			for (int i = 0; i < validCharacters.length(); i++) {
				if (c == validCharacters.charAt(i)) {
					exit = false;
				}
			}
		} while (exit);
		return c;
	}

	public static void menu() {
		int option = 0;
		exit = false;
		Scanner keyboard = new Scanner(System.in);

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

	public static void main(String[] args) {
		// PRESENTAR EL JUEGO Y OPCIONES //
		// GOMUKU BY JOSE
		// MOSTRAR PRESENTACION
		// ESPERAR 3 SEG
		// BORRAR PRESENTACION
		// MOSTRAR OPCIONES
		asciiArt(1);
		menu();
	}

	@SuppressWarnings({ "unused", "resource" })
	public static int players(int option) {
		exit = false;
		Scanner keyboard = new Scanner(System.in);
		String name = "";
		boolean random = false;
		String player1_name = "";
		String player2_name = "";
		int b = (int)(Math.random()*(2-1+1)+1);

		System.out.println("\nWould you like to randomize who will start?");
		char randomize = readChar("y");
		if(randomize == 'y') {
			random = true;
		}

		do {
			System.out.println();
			switch (option) {
			case 1:
				if (random) {
					if(b == 1) {
						bot1 = new Bot(name, b);
						bot2 = new Bot(name, b + 1);
					} else if (b == 2) {
						bot1 = new Bot(name, b);
						bot2 = new Bot(name, b - 1);
					}
				} else {
					bot1 = new Bot(name, 1);
					bot2 = new Bot(name, 2);
				}
				exit = true;
				break;
			case 2:
				System.out.println("Which is your name player 1?");
				player1_name = keyboard.nextLine();
				human1 = new Human(player1_name, 1);
				bot1 = new Bot(name, 2);
				exit = true;
				break;
			case 3:
				System.out.println("Which is your name player 1?");
				player1_name = keyboard.nextLine();
				human1 = new Human(player1_name, 1);
				System.out.println("Which is your name player 2?");
				player2_name = keyboard.nextLine();
				human2 = new Human(player1_name, 2);
				exit = true;
				break;
			default:
				System.out.println("Invalid option\nTry it again!\n");
				exit = false;
				break;
			}
		} while (!exit);
		return option;
	}

	public static void newGame(int option) {
		int[] position;
		exit = false;
		Scanner keyboard = new Scanner(System.in);
		Board board = new Board(option);
		/* Create the players */
		System.out.printf("How would you like to play?\n" + "\t1.- Bot vs Bot\n"
				+ "\t2.- Human vs Bot\n" + "\t3.- Human vs Human\n" + "Choose your option: ");
		int playerOption = players(keyboard.nextInt());

		/* Clear the console a bit */
		clearConsole();

		/* Create the board */
		board.showBoard();

		/* Start the game */
		while (game) {
			if (playerTurn) {
				clearConsole();
				do {
					try {
						if (playerOption == 1) {
							System.out.println("Insert the coordinates " + bot1.getName());
						} else if (playerOption == 2 || playerOption == 3) {
							System.out.println("Insert the coordinates " + human1.getName());
						}
						position = coordinates();
						possibleMove = validatePosition(position, board);
						if (playerOption == 1) {
							board.insertPiece(position[0], position[1], bot1.symbolPiece);
						} else if (playerOption == 2 || playerOption == 3) {
							board.insertPiece(position[0], position[1], human1.symbolPiece);
						}
						exit = true;
					} catch (Exception e) {
						keyboard.reset();
						System.out.println(e.getMessage());
						exit = false;
					}
				} while (!exit);
				validateWin(board);
				board.showBoard();
			}
			clearConsole();
			if (playerTurn) {
				do {
					try {
						if (playerOption == 1) {
							System.out.println("Insert the coordinates " + bot2.getName());
						} else if (playerOption == 2) {
							System.out.println("Insert the coordinates " + bot1.getName());
						} else if(playerOption == 3) {
							System.out.println("Insert the coordinates " + human2.getName());
						}
						position = coordinates();
						possibleMove = validatePosition(position, board);
						if (playerOption == 1) {
							board.insertPiece(position[0], position[1], bot2.symbolPiece);
						} else if (playerOption == 2) {
							board.insertPiece(position[0], position[1], bot1.symbolPiece);
						} else if(playerOption == 3) {
							board.insertPiece(position[0], position[1], human2.symbolPiece);
						}
						exit = true;
					} catch (Exception e) {
						keyboard.reset();
						System.out.println(e.getMessage());
						exit = false;
					}
				} while (!exit);
				board.showBoard();
			}
		}
		asciiArt(2);
		showResult();
		reset();
	}

	public static void reset() {
		System.out.println("Would you like to play again?");
		char valid = readChar("y");
		if (valid == 'y') {
			menu();
		}
	}

	public static boolean validatePosition(int[] position, Board board) throws Exception {
		possibleMove = false;
		/* Validate if position is in the board size */
		if (position[0] < 0 || position[0] > 14 || position[1] < 0 || position[1] > 14) {
			System.out.println("The position is not in the board size");
			throw new Exception("Try again");
			/* Validate if the position is empty */
		} else if (board.getPiece(position[0], position[1]) != 0) {
			System.out.println("The position is not empty");
			throw new Exception("Try again");
		} else {
			possibleMove = true;
		}
		return possibleMove;
	}

	public static void validateWin(Board board) {
		validateHorizontalToWin(board);
		validateVerticalToWin(board);
		validateDiagonalToWin(board);
		validateReversedDiagonalToWin(board);
	}

	public static void validateHorizontalToWin(Board board) {
		/* Validate if in the horizontal line are 5 pieces */
		for (int i = 0; i < board.getTableSize(); i++) {
			for (int j = 0; j < board.getTableSize() - 4; j++) {
				if (board.getPiece(i, j) != 0) {
					if (board.getPiece(i, j) == board.getPiece(i, j + 1)
							&& board.getPiece(i, j) == board.getPiece(i, j + 2)
							&& board.getPiece(i, j) == board.getPiece(i, j + 3)
							&& board.getPiece(i, j) == board.getPiece(i, j + 4)) {
						finishGame();
					}
				}
			}
		}
	}

	public static void validateVerticalToWin(Board board) {
		/* Validate if in the vertical line are 5 pieces */
		for (int i = 0; i < board.getTableSize(); i++) {
			for (int j = 0; j < board.getTableSize() - 4; j++) {
				if (board.getPiece(j, i) != 0) {
					if (board.getPiece(j, i) == board.getPiece(j + 1, i)
							&& board.getPiece(j, i) == board.getPiece(j + 2, i)
							&& board.getPiece(j, i) == board.getPiece(j + 3, i)
							&& board.getPiece(j, i) == board.getPiece(j + 4, i)) {
						finishGame();
					}
				}
			}
		}
	}

	public static void validateDiagonalToWin(Board board) {
		/* Validate if in the diagonal line are 5 pieces */
		for (int i = 0; i < board.getTableSize() - 4; i++) {
			for (int j = 0; j < board.getTableSize() - 4; j++) {
				if (board.getPiece(i, j) != 0) {
					if (board.getPiece(i, j) == board.getPiece(i + 1, j + 1)
							&& board.getPiece(i, j) == board.getPiece(i + 2, j + 2)
							&& board.getPiece(i, j) == board.getPiece(i + 3, j + 3)
							&& board.getPiece(i, j) == board.getPiece(i + 4, j + 4)) {
						finishGame();
					}
				}
			}
		}
	}

	public static void validateReversedDiagonalToWin(Board board) {
		/* Validate if in the reversed diagonal line are 5 pieces */
		for (int i = 0; i < board.getTableSize() - 4; i++) {
			for (int j = 4; j < board.getTableSize(); j++) {
				if (board.getPiece(i, j) != 0) {
					if (board.getPiece(i, j) == board.getPiece(i + 1, j - 1)
							&& board.getPiece(i, j) == board.getPiece(i + 2, j - 2)
							&& board.getPiece(i, j) == board.getPiece(i + 3, j - 3)
							&& board.getPiece(i, j) == board.getPiece(i + 4, j - 4)) {
						finishGame();
					}
				}
			}
		}
	}

	public static int[] coordinates() {
		Scanner keyboard = new Scanner(System.in);
		String coordinates = keyboard.nextLine();
		String[] coordinates_split = coordinates.split(",");
		int[] positions = new int[2];
		positions[0] = Integer.parseInt(coordinates_split[0]) - 1;
		positions[1] = Integer.parseInt(coordinates_split[1]) - 1;
		return positions;
	}

	public final static void clearConsole() {
		System.out.println();
	}

	public static void finishGame() {
		playerTurn = false;
		game = false;
	}

	public static void showResult() {
	}
}