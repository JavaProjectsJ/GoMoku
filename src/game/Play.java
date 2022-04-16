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
		// Crear el tablero
		// board.createBoard(option);
		// Crear los jugadores
		System.out.println("Which is your name player 1?");
		String player1_name = keyboard.nextLine();
		System.out.println("Which is your name player 2?");
		String player2_name = keyboard.nextLine();

		Player player1 = new Player(player1_name, 1);
		Player player2 = new Player(player2_name, 2);

		// System.out.println(player1.getName());
		// System.out.println(player1.getSymbolPiece());
		// System.out.println(player2.getName());
		// System.out.println(player2.getSymbolPiece());

		clearConsole();

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
				String coordinates = keyboard.nextLine(); // a7b12;
				int x = coordinates.charAt(0) - 1;
				int y = coordinates.charAt(2) - 1;
				board.insertPiece(x, y, player1.symbolPiece);
				board.showBoard();
				playerTurn = true;
			} else if (playerTurn) {
				clearConsole();
				System.out.println("GIVE ME THE DATA " + player2.getName());
				int x = keyboard.nextInt() - 1;
				int y = keyboard.nextInt() - 1;
				board.insertPiece(x, y, player2.symbolPiece);
				board.showBoard();
				playerTurn = false;
			}
		}
		System.out.println("GAME OVER");
		FinishGame();
		ShowResult();
	}

	public static void validate(int option) {
	}

	public final static void clearConsole() {
		System.out.println();
	}

	public static void FinishGame() {
	}

	public static void ShowResult() {
	}
}