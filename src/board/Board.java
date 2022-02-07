/*
 * Copyright (C) Jose Pérez - jmpfbmx (2021)
 */
package board;

import java.util.Scanner;

public class Board {
	/*
	 * Color Start
	 */
	public static final String RESET = "\u001B[0m";
	/*
	 * Print Players
	 * Player1 colour is black background
	 * Player2 colour is white background
	 */
	// public static final String PLAYER1 = "\u001B[30m";
	// public static final String PLAYER2 = "\u001B[37m";
	public static final String PLAYER1 = "\033[40m";
	public static final String PLAYER2 = "\033[47m";
	/*
	 * Print board
	 * 1st colour is green
	 * 2nd colour is green with transparency
	 */
	public static final String BOARD = "\u001B[42m";
	public static final String BOARD2 = "\033[0;102m";

	public static void main(String[] args) {
		goMokuBoard();
	}

	/*
	 * Print Header.
	 */
	public static void printHeader(int option) {
		printABC(option);
		System.out.println();
		System.out.printf("   ");
		for (int i = 0; i < option; i++) {
			System.out.printf("__");
		}
		System.out.println();
	}

	/*
	 * Print Footer.
	 */
	public static void printFooter(int option) {
		String[] abc = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z" };
		System.out.printf("   ");
		for (int i = 0; i < option; i++) {
			System.out.print("¯¯");
		}
		printABC(option);
	}

	/*
	 * Print alphabet in the top of the columns.
	 */
	public static void printABC(int option) {
		String[] abc = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z" };
		System.out.println();
		System.out.printf("   ");
		for (int j = 0; j < option; j++) {
			System.out.print(" " + abc[j]);
		}

	}

	/*
	 * Print the GoMoku Board:
	 * As we have two Board sizes we will need to tell which is the size we would
	 * like to use.
	 * In the past GoMoku was played using a 19x19 board, nowadays is being played
	 * with a 15x15 board.
	 */
	@SuppressWarnings("resource")
	public static void goMokuBoard() {
		String spacing = "  ";
		int option;
		String[] nmb = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19" };
		Scanner keyboard = new Scanner(System.in);
		option = keyboard.nextInt();

		printHeader(option);

		if (option == 19) {
			for (int i = 0; i < 19; i++) {
				System.out.printf(nmb[i] + "|");
				for (int j = 0; j < 19; j++) {
					if ((i + j) % 2 == 0) {
						System.out.printf(BOARD + spacing);
					} else {
						System.out.printf(BOARD2 + spacing);
					}
					if (j == 18) {
						System.out.printf(RESET + "|" + nmb[i]);
					}
				}
				System.out.printf(RESET + "\n");
			}
		} else if (option == 15) {
			for (int i = 0; i < 15; i++) {
				System.out.printf(nmb[i] + "|");
				for (int j = 0; j < 15; j++) {
					if ((i + j) % 2 == 0) {
						System.out.printf(BOARD + spacing);
					} else {
						System.out.printf(BOARD2 + spacing);
					}
					if (j == 14) {
						System.out.printf(RESET + "|" + nmb[i]);
					}
				}
				System.out.printf(RESET + "\n");
			}
		} else {
			System.out.println("Invalid board size");
			System.out.print("\033[H\033[2J");
			System.out.flush();
		}
		printFooter(option);
	}
}