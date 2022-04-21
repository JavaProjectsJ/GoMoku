package game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Play {
	boolean game = true;
	boolean playerTurn = true;
	boolean possibleMove = false;
	boolean exit = false;
	boolean random = false;
	KeyboardGame keyboardGame = new KeyboardGame();


	List<Player> playerList = new ArrayList<>();

	public void asciiArt(int option) {
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
							+ "                   ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗                   \n"
							+ "     ▀▄   ▄▀      ██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗    ▄ ▀▄   ▄▀ ▄   \n"
							+ "    ▄█▀███▀█▄     ██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝    █▄███████▄█   \n"
							+ "   █▀███████▀█    ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗    ███▄███▄███   \n"
							+ "   █ █▀▀▀▀▀█ █    ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║    ▀█████████▀   \n"
							+ "      ▀▀ ▀▀        ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝     ▄▀     ▀▄    \n"
							+ "                                                                                                              \n");
			break;
		}
	}
>>>>>>> Update



	public void menu() {
		show();
		int option = 0;
		exit = false;
		Scanner keyboard = new Scanner(System.in);

		chooseBoard(keyboard);
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
		ascii.asciiArt(1);
		rules();
	}

	public void newGame(int option) {
		int[] position;
		exit = false;
		Scanner keyboard = new Scanner(System.in);
		Board board = new Board(option);
		final int randomPlayer = new Random().nextInt(2) + 1;
		/* Create the players */
		System.out.printf("How would you like to play?\n" + "\t1.- Bot vs Bot\n" + "\t2.- Human vs Bot\n"
				+ "\t3.- Human vs Human\n" + "Choose your option: ");
		int playerOption = keyboard.nextInt();
		Game game = new Game(playerOption);

		/* Clear the console a bit */
		clearConsole();

		/* Create the board */
		board.showBoard();

		Validator validator = new Validator();

		/* Start the game */
		while (game.status) {
			clearConsole();
			System.out.println("Insert the coordinates " + game.playerList.get(0).getName());
			game.setStatus(false);
		}
//			if (playerTurn) {
//				clearConsole();
//				do {
//					try {
//						if (random) {
//							if (playerOption == 1) {
//								if (randomPlayer == 1) {
//									System.out.println("Insert the coordinates " + bot1.getName());
//								} else {
//									System.out.println("Insert the coordinates " + bot2.getName());
//								}
//							} else if (playerOption == 2) {
//								if (randomPlayer == 1) {
//									System.out.println("Insert the coordinates " + human1.getName());
//								} else {
//									System.out.println("Insert the coordinates " + bot1.getName());
//								}
//							} else if (playerOption == 3) {
//								if (randomPlayer == 1) {
//									System.out.println("Insert the coordinates " + human1.getName());
//								} else {
//									System.out.println("Insert the coordinates " + human2.getName());
//								}
//							}
//						} else {
//							if (playerOption == 1) {
//								System.out.println("Insert the coordinates " + bot1.getName());
//							} else if (playerOption == 2 || playerOption == 3) {
//								System.out.println("Insert the coordinates " + human1.getName());
//							}
//						}
//						position = coordinates();
//						possibleMove = validatePosition(position, board);
//						if (random) {
//							if (playerOption == 1) {
//								if (randomPlayer == 1) {
//									board.insertPiece(position[0], position[1], bot1.symbolPiece);
//								} else {
//									board.insertPiece(position[0], position[1], bot2.symbolPiece);
//								}
//							} else if (playerOption == 2) {
//								if (randomPlayer == 1) {
//									board.insertPiece(position[0], position[1], human1.symbolPiece);
//								} else {
//									board.insertPiece(position[0], position[1], bot1.symbolPiece);
//								}
//							} else if (playerOption == 3) {
//								if (randomPlayer == 1) {
//									board.insertPiece(position[0], position[1], human1.symbolPiece);
//								} else {
//									board.insertPiece(position[0], position[1], human2.symbolPiece);
//								}
//							}
//						} else {
//							if (playerOption == 1) {
//								board.insertPiece(position[0], position[1], bot1.symbolPiece);
//							} else if (playerOption == 2 || playerOption == 3) {
//								board.insertPiece(position[0], position[1], human1.symbolPiece);
//							}
//						}
//						exit = true;
//					} catch (Exception e) {
//						keyboard.reset();
//						System.out.println(e.getMessage());
//						exit = false;
//					}
//				} while (!exit);
//				if(validator.validateWin(board)){
//					playerTurn = false;
//					game = false;
//				}
//				board.showBoard();
//			}
//			clearConsole();
//			if (playerTurn) {
//				do {
//					try {
//						if (random) {
//							if (playerOption == 1) {
//								if (randomPlayer != 1) {
//									System.out.println("Insert the coordinates " + bot1.getName());
//								} else {
//									System.out.println("Insert the coordinates " + bot2.getName());
//								}
//							} else if (playerOption == 2) {
//								if (randomPlayer != 1) {
//									System.out.println("Insert the coordinates " + human1.getName());
//								} else {
//									System.out.println("Insert the coordinates " + bot1.getName());
//								}
//							} else if (playerOption == 3) {
//								if (randomPlayer != 1) {
//									System.out.println("Insert the coordinates " + human1.getName());
//								} else {
//									System.out.println("Insert the coordinates " + human2.getName());
//								}
//							}
//						} else {
//							if (playerOption == 1) {
//								System.out.println("Insert the coordinates " + bot2.getName());
//							} else if (playerOption == 2) {
//								System.out.println("Insert the coordinates " + bot1.getName());
//							} else if (playerOption == 3) {
//								System.out.println("Insert the coordinates " + human2.getName());
//							}
//						}
//						position = coordinates();
//						possibleMove = validatePosition(position, board);
//						if (random) {
//							if (playerOption == 1) {
//								if (randomPlayer != 1) {
//									board.insertPiece(position[0], position[1], bot1.symbolPiece);
//								} else {
//									board.insertPiece(position[0], position[1], bot2.symbolPiece);
//								}
//							} else if (playerOption == 2) {
//								if (randomPlayer != 1) {
//									board.insertPiece(position[0], position[1], human1.symbolPiece);
//								} else {
//									board.insertPiece(position[0], position[1], bot1.symbolPiece);
//								}
//							} else if (playerOption == 3) {
//								if (randomPlayer != 1) {
//									board.insertPiece(position[0], position[1], human1.symbolPiece);
//								} else {
//									board.insertPiece(position[0], position[1], human2.symbolPiece);
//								}
//							}
//						} else {
//							if (playerOption == 1) {
//								board.insertPiece(position[0], position[1], bot2.symbolPiece);
//							} else if (playerOption == 2) {
//								board.insertPiece(position[0], position[1], bot1.symbolPiece);
//							} else if (playerOption == 3) {
//								board.insertPiece(position[0], position[1], human2.symbolPiece);
//							}
//						}
//						exit = true;
//					} catch (Exception e) {
//						keyboard.reset();
//						System.out.println(e.getMessage());
//						exit = false;
//					}
//				} while (!exit);
//				board.showBoard();
//			}
//		}
		asciiArt(2);
		showResult();
		reset();
		hallOfFame();
	}

	public void reset() {
		System.out.println("Would you like to play again?");
		boolean valid = keyboardGame.readChar('y');
		if (valid) {
			menu();
		}
	}

	public boolean validatePosition(int[] position, Board board) throws Exception {
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

	public void hallOfFame() {
//		File myObj = new File("HOF.txt");
//		try {
//			if (!myObj.exists()) {
//				System.out.println("File created: " + myObj.getName());
//				myObj.createNewFile();
//			}
//
//			/*
//			 * Let's read the file
//			 */
//			System.out.println("\nHOF formers:\n");
//			Scanner fReader = new Scanner(myObj);
//			while (fReader.hasNextLine()) {
//				String data = fReader.nextLine();
//				System.out.println(" - " + data);
//			}
//			fReader.close();
//			/*
//			 * Let's write the file
//			 * First value specify the file that is going to be written
//			 * Second value specify that I want to leave the info that already contains
//			 */
//			FileWriter fWritter = new FileWriter(myObj, true);
//			BufferedWriter myWriter = new BufferedWriter(fWritter);
//			myWriter.write(bot1.getName());
//			myWriter.newLine();
//			myWriter.write(bot2.getName());
//			myWriter.newLine();
//			myWriter.close();
//			System.out.println("\nInformation has been successfully written to the file.");
//		} catch (IOException e) {
//			System.out.println("\nFile couldn't be written!");
//			e.printStackTrace();
//		}
	}
}
