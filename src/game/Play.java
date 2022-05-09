package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Play {
	AsciiArt ascii = new AsciiArt();
	HallOfFame hof = new HallOfFame();
	KeyboardGame keyboardGame = new KeyboardGame();
	static List<Player> playerList = new ArrayList<>();
	Player player1;
	Player player2;
	boolean status = true;
	boolean game = true;
	boolean playerTurn = true;
	boolean possibleMove = false;
	boolean exit = false;
	boolean random = false;
	boolean valid = false;
	static boolean deadHeat = false;

	@SuppressWarnings("resource")
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
						player1 = new BotString(name, true);
						player2 = new BotString(name, false);
						playerList = Arrays.asList(player1, player2);
					} else {
						player2 = new BotString(name, true);
						player1 = new BotString(name, false);
						playerList = Arrays.asList(player2, player1);
					}
				} else {
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

		/* Start the game */
		while (status) {
			clearConsole();
			do {
				System.out.println("Insert the coordinates " + playerList.get(playerTurn).getName());
				position = playerList.get(playerTurn).returnCoordinates(board);
			} while (!validator.validatePosition(position, board));
			board.insertPiece(position[1], position[0], playerList.get(playerTurn).getPiece());
			if (validator.validateWin(board) || board.deadHeat()) {
				status = false;
				if (!status && board.deadHeat()) {
					deadHeat = true;
				}
			} else {
				status = true;
			}
			board.insertPiece(position[1], position[0], playerList.get(playerTurn).getPiece());
			playerTurn = (playerTurn == 0) ? 1 : 0;
			board.showBoard();
		}
		playerTurn = (playerTurn == 0) ? 1 : 0;
		showResult(playerTurn);
		System.out.println();
		ascii.asciiArt(2);
		hof.hallOfFame(playerList, playerTurn);
		new Main().reset();
	}

	public final void clearConsole() {
		System.out.println();
	}

	public static String showResult(int playerTurn) {
		String str;
		if (deadHeat) {
			System.out.println();
			str = String.format("Player %s, %s played vs Player %s, %s but nobody won, you have done a dead heat.",
					playerTurn + 1, playerList.get(playerTurn).getName(), (((playerTurn == 0) ? 1 : 0) + 1),
					playerList.get((playerTurn == 0) ? 1 : 0).getName());
			System.out.println();
			/*
			 * deadHeat have to be set as false but idk where set it as false
			 * as there is a problem which is that if i set it here as false when
			 * HallOfFame access to this function it just will just enter in the else
			 * so prolly best idea is leaving it as true if enters here for making it work
			 * right.
			 */
		} else {
			System.out.println();
			str = String.format("Player %s, %s won vs Player %s, %s!", playerTurn + 1,
					playerList.get(playerTurn).getName(), (((playerTurn == 0) ? 1 : 0) + 1),
					playerList.get((playerTurn == 0) ? 1 : 0).getName());
			System.out.println();
		}
		System.out.println(str);
		return str;
	}

	public boolean isPossibleToMove() {
		return exit;
	}
}
