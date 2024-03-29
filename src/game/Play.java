package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class that create the board, players and start the game
 * 
 * @author jmpfbmx
 * @version 1.0
 * @since 1.0
 */
public class Play {
	/**
	 * It is used for printing my custom art
	 * 
	 * @see AsciiArt
	 */
	AsciiArt ascii = new AsciiArt();
	/**
	 * It is used for writing to files
	 * 
	 * @see HallOfFame
	 */
	HallOfFame hof = new HallOfFame();
	/**
	 * It creates the keyboard
	 * 
	 * @see KeyboardGame
	 */
	KeyboardGame keyboardGame = new KeyboardGame();
	/**
	 * It stores the players that are playing
	 */
	static List<Player> playerList = new ArrayList<>();
	/**
	 * It creates the 1st player
	 */
	Player player1;
	/**
	 * It creates the 2nd player
	 */
	Player player2;
	/**
	 * It is used for exiting the game once that someone has won or if a dead heat
	 * was
	 * done.
	 */
	boolean status = true;
	/**
	 * It is set as true when in a game a dead heat was done.
	 */
	boolean deadHeat = false;

	/**
	 * It generates the players that are going to play and if they will start
	 * randomly,
	 * they will also be stored in a list.
	 * 
	 * @param option
	 * @see Player
	 * @see BotString
	 * @see Human
	 * @return the player list
	 */
	public List<Player> players(int option) {
		boolean exit = false;
		boolean random = false;
		String name = "";
		String player1_name = "";
		String player2_name = "";
		int randomPiece = (int) (Math.random() * (2 - 1 + 1) + 1);
		System.out.println("\nWould you like to randomize who will start?");
		random = keyboardGame.readChar('y', 'n');
		keyboardGame.reset();
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
				player1_name = keyboardGame.readString();
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
				player1_name = keyboardGame.readString();
				System.out.println("\nWhich is your name player 2?");
				player2_name = keyboardGame.readString();
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

	/**
	 * It creates the board, clears the console a bit and also starts the game
	 * 
	 * @param option
	 */
	public void newGame(int option) {
		Board board = new Board(option);
		Validator validator = new Validator();
		int playerTurn = 0;
		int[] position;

		System.out.printf("How would you like to play?\n" + "\t1.- Bot vs Bot\n" + "\t2.- Human vs Bot\n"
				+ "\t3.- Human vs Human\n" + "Choose your option: ");
		int playerOption = keyboardGame.readInt();
		players(playerOption);

		clearConsole();

		board.showBoard();

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
		showResult(playerTurn, deadHeat);
		System.out.println();
		ascii.asciiArt(2);
		hof.hallOfFame(playerList, playerTurn, deadHeat);
		new Main().reset();
	}

	/**
	 * It inserts a blank line
	 */
	public final void clearConsole() {
		System.out.println();
	}

	/**
	 * It shows who played and who win.
	 * 
	 * @param playerTurn
	 * @param deadHeat
	 * @return a String saying if someone won or if was a dead heat.
	 */
	public static String showResult(int playerTurn, boolean deadHeat) {
		String str;
		if (deadHeat) {
			System.out.println();
			str = String.format("Player %s, %s played vs Player %s, %s but nobody won, you have done a dead heat.",
					playerTurn + 1, playerList.get(playerTurn).getName(), (((playerTurn == 0) ? 1 : 0) + 1),
					playerList.get((playerTurn == 0) ? 1 : 0).getName());
			System.out.println();
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
}
