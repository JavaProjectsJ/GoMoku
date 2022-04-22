/*
 * Copyright (C) Jose Pérez - jmpfbmx (2021)
 */
package game;

public class Board {
	public static final String BLUE = "\u001B[34m";
	public static final String GREEN = "\u001B[32m";
	public static final String RESET = "\u001B[0m";
	public static final String YELLOW = "\u001B[33m";

	private int[][] boardPiecePosition = { {} };

	private int tableSize;

	public int getTableSize() {
		return tableSize;
	}

	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}

	private String[] nmb = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
			"16", "17", "18", "19" };

	private String dot = " ·";

	public Board(int tableSize) {
		this.tableSize = tableSize;
		this.boardPiecePosition = new int[tableSize][tableSize];
		for (int i = 0; i < boardPiecePosition.length; i++) {
			for (int j = 0; j < boardPiecePosition.length; j++) {
				this.boardPiecePosition[i][j] = 0;
			}
		}
	}

	public void insertPiece(int x, int y, int playerPiece) {
		this.boardPiecePosition[x][y] = playerPiece;
	}

	public int getPiece(int x, int y) {
		return this.boardPiecePosition[x][y];
	}

	public void showBoardInformation() {
		for (int i = 0; i < boardPiecePosition.length; i++) {
			for (int j = 0; j < boardPiecePosition.length; j++) {
				System.out.print(boardPiecePosition[i][j]);
			}
			System.out.println();
		}
	}

	public void printABC(int size) {
		String[] abc = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z" };
		System.out.println();
		System.out.printf("   ");
		for (int j = 0; j < size; j++) {
			System.out.print(" " + abc[j]);
		}
		System.out.printf("    ");
	}

	private void printHeader(int size) {
		printABC(size);
		System.out.println();
		System.out.printf("   ");
		for (int i = 0; i < size; i++) {
			System.out.printf("  ");
		}
		System.out.printf("    ");
		System.out.println();
	}

	public void printFooter(int size) {
		System.out.printf("   ");
		for (int i = 0; i < size; i++) {
			System.out.print("  ");
		}
		System.out.printf("    ");
		printABC(size);
		System.out.println();
	}

	public void showBoard() {
		printHeader(this.tableSize);

		for (int i = 0; i < boardPiecePosition.length; i++) {
			System.out.printf(" " + nmb[i]);
			for (int j = 0; j < boardPiecePosition.length; j++) {
				if (boardPiecePosition[i][j] == 0) {
					System.out.printf(dot);
				} else if (boardPiecePosition[i][j] == 1) {
					System.out.print(YELLOW + " X" + RESET);
				} else {
					System.out.print(BLUE + " O" + RESET);
				}

				if (j == tableSize - 1) {
					System.out.printf(" " + nmb[i] + " ");
				}
			}
			System.out.printf("\n");
		}
		printFooter(this.tableSize);
	}
}