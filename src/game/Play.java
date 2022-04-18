package game;

import java.util.Scanner;

public class Play {
	static boolean game = true;
	static boolean playerTurn = true;
	static boolean possibleMove = false;

	public static void asciiArt() {
		System.out.printf(
				"                                                                                                                 \n"
						+ " ██████╗  ██████╗ ███╗   ███╗ ██████╗ ██╗  ██╗██╗   ██╗    ██████╗ ██╗   ██╗         ██╗ ██████╗ ███████╗███████╗\n"
						+ "██╔════╝ ██╔═══██╗████╗ ████║██╔═══██╗██║ ██╔╝██║   ██║    ██╔══██╗╚██╗ ██╔╝         ██║██╔═══██╗██╔════╝██╔════╝\n"
						+ "██║  ███╗██║   ██║██╔████╔██║██║   ██║█████╔╝ ██║   ██║    ██████╔╝ ╚████╔╝          ██║██║   ██║███████╗█████╗  \n"
						+ "██║   ██║██║   ██║██║╚██╔╝██║██║   ██║██╔═██╗ ██║   ██║    ██╔══██╗  ╚██╔╝      ██   ██║██║   ██║╚════██║██╔══╝  \n"
						+ "╚██████╔╝╚██████╔╝██║ ╚═╝ ██║╚██████╔╝██║  ██╗╚██████╔╝    ██████╔╝   ██║       ╚█████╔╝╚██████╔╝███████║███████╗\n"
						+ " ╚═════╝  ╚═════╝ ╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═╝ ╚═════╝     ╚═════╝    ╚═╝        ╚════╝  ╚═════╝ ╚══════╝╚══════╝\n"
						+ "                                                                                                                 \n");
	}

	public static void main(String[] args) {
		// PRESENTAR EL JUEGO Y OPCIONES //
		// GOMUKU BY JOSE
		// MOSTRAR PRESENTACION
		// ESPERAR 3 SEG
		// BORRAR PRESENTACION
		// MOSTRAR OPCIONES
		int option = 0;
		asciiArt();
		Scanner keyboard = new Scanner(System.in);

		do {
			System.out.printf("Choose your Go Moku Board:\n" + "\t1.- New board (15x15)\n"
					+ "\t2.- Traditional board (19x19)\n" + "\t3.- Exit\n" + "Choose your option: ");
			option = keyboard.nextInt();
			System.out.println();
			switch (option) {
			case 1:
				newGame(15);
				break;
			case 2:
				newGame(19);
				break;
			case 3:
				System.out.println("Stopping the game execution");
				break;
			default:
				System.out.println("Invalid option\nTry it again!\n");
				break;
			}
		} while (option != 3);
	}

	public static void newGame(int option) {
		int[] position;
		boolean exit = false;
		Scanner keyboard = new Scanner(System.in);
		Board board = new Board(option);
		/* Create the players */
		System.out.println("Which is your name player 1?");
		String player1_name = keyboard.nextLine();
		System.out.println("Which is your name player 2?");
		String player2_name = keyboard.nextLine();

		Player player1 = new Player(player1_name, 1);
		Player player2 = new Player(player2_name, 2);

		clearConsole();

		/* Create the board */
		board.showBoard();

		/* Start the game */
		while (game) {
			if (playerTurn) {
				clearConsole();
				do {
					try {
						System.out.println("Insert the coordinates " + player1.getName());
						position = coordinates();
						possibleMove = validatePosition(position, board);
						board.insertPiece(position[0], position[1], player1.symbolPiece);
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
						System.out.println("Insert the coordinates " + player2.getName());
						position = coordinates();
						possibleMove = validatePosition(position, board);
						board.insertPiece(position[0], position[1], player2.symbolPiece);
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
		System.out.println("Game over");
		showResult();
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