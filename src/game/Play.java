package game;

import java.util.Scanner;

public class Play {

	public static void main(String[] args) {
		// PRESENTAR EL JUEGO Y OPCIONES //
		// GOMUKU BY JOSE
		// MOSTRAR PRESENTACION
		// ESPERAR 3 SEG
		// BORRAR PRESENTACION
		// MOSTRAR OPCIONES
		System.out.println(
				" ██████╗  ██████╗ ███╗   ███╗ ██████╗ ██╗  ██╗██╗   ██╗    ██████╗ ██╗   ██╗         ██╗ ██████╗ ███████╗███████╗\n"
						+ "██╔════╝ ██╔═══██╗████╗ ████║██╔═══██╗██║ ██╔╝██║   ██║    ██╔══██╗╚██╗ ██╔╝         ██║██╔═══██╗██╔════╝██╔════╝\n"
						+ "██║  ███╗██║   ██║██╔████╔██║██║   ██║█████╔╝ ██║   ██║    ██████╔╝ ╚████╔╝          ██║██║   ██║███████╗█████╗  \n"
						+ "██║   ██║██║   ██║██║╚██╔╝██║██║   ██║██╔═██╗ ██║   ██║    ██╔══██╗  ╚██╔╝      ██   ██║██║   ██║╚════██║██╔══╝  \n"
						+ "╚██████╔╝╚██████╔╝██║ ╚═╝ ██║╚██████╔╝██║  ██╗╚██████╔╝    ██████╔╝   ██║       ╚█████╔╝╚██████╔╝███████║███████╗\n"
						+ " ╚═════╝  ╚═════╝ ╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═╝ ╚═════╝     ╚═════╝    ╚═╝        ╚════╝  ╚═════╝ ╚══════╝╚══════╝\n"
						+ "                                                                                                                 \n");
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Choose your Go Moku Board:\n" + "\t15.- New board\n" + "\t19.- Traditional board\n"
				+ "Choose your option: ");

		int option = keyboard.nextInt();

		NewGame(option);
	}

	public static void NewGame(int option) {
		Scanner keyboard = new Scanner(System.in);
		boolean playerTurn = false;
		boolean game = true;
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
		// DENTRO DE UN WHILE MIENTRAS EL JUEGO CONTINUE
		// Primer movimiento del primer jugador

		// HACER FUNCION VALIDATE LA CUAL VA A TENER UN TRY & CATCH
		// Y COMPROBARÁ SI LOS VALORES DADOS SON CORRECTOS O NO
		// TAMBIEN HACER UNA COMPROBACIÓN POR SI LA FICHA NO SEA = 0
		while (game) {
			if (!playerTurn) {
				clearConsole();
				System.out.println("GIVE ME THE COORDINATES " + player1.getName());
				int[] position = coordinates();
				board.insertPiece(position[0], position[1], player1.symbolPiece);
				board.showBoard();
				playerTurn = true;
			} else if (playerTurn) {
				clearConsole();
				System.out.println("GIVE ME THE DATA " + player2.getName());
				int[] position = coordinates();
				board.insertPiece(position[0], position[1], player2.symbolPiece);
				board.showBoard();
				playerTurn = false;
			}
		}
		System.out.println("GAME OVER");
		FinishGame();
		ShowResult();
	}

	public static void validate(int[] position) {
		/* Validate if position is in the board size 
		 * and if the position is empty */
		if (position[0] < 0 || position[0] > board.getTableSize || position[1] < 0 || position[1] > board.getTableSize) {
			System.out.println("The position is not valid");
		} else if (board.getPiece(position[0], position[1]) != 0) {
			System.out.println("The position is not empty");
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

	public static void FinishGame() {
	}

	public static void ShowResult() {
	}
}