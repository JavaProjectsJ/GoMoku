/*
 * Copyright (C) Jose Pérez - jmpfbmx (2021)
 */
package game;

public class Board {
	public static final String BLUE = "\u001B[34m";
	public static final String GREEN = "\033[0;32m";
	public static final String RESET = "\u001B[0m";
	public static final String YELLOW = "\u001B[33m";

	private int[][] boardPiecePosition = { {} };
	private int[] boardLastPiecePosition = {};

	private int tableSize;

	public int getTableSize() {
		return tableSize;
	}

	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}

	private String[] nmb = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
			"16", "17", "18", "19" };

	public Board(int tableSize) {
		this.tableSize = tableSize;
		this.boardPiecePosition = new int[tableSize][tableSize];
		this.boardLastPiecePosition = new int[] { -1, -1, -1 };
		for (int i = 0; i < boardPiecePosition.length; i++) {
			for (int j = 0; j < boardPiecePosition.length; j++) {
				this.boardPiecePosition[i][j] = 0;
			}
		}
	}

	public Board() {
		super();
	}

	public void insertPiece(int x, int y, Pieces pieces, boolean lastPosition) {
		int n = 0;
		if (pieces == Pieces.CROSS) {
			n = 1;
		} else {
			n = 2;
		}
		if (lastPosition) {
			this.boardLastPiecePosition[0] = x;
			this.boardLastPiecePosition[1] = y;
			this.boardLastPiecePosition[2] = n;
		} else {
			this.boardPiecePosition[x][y] = n;
		}
	}

	public int getPiece(int x, int y) {
		return this.boardPiecePosition[y][x];
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
		boolean printFinal = false;
		printHeader(this.tableSize);

		for (int i = 0; i < boardPiecePosition.length; i++) {
			System.out.printf(" " + nmb[i]);
			for (int j = 0; j < boardPiecePosition.length; j++) {
				if (boardLastPiecePosition[1] == j && boardLastPiecePosition[0] == i) {
					if (boardLastPiecePosition[2] == 1) {
						System.out.print(GREEN + " " + Pieces.CROSS.getPieces() + RESET);
					} else {
						System.out.print(GREEN + " " + Pieces.CIRCLE.getPieces() + RESET);
					}
				} else {
					if (boardPiecePosition[i][j] == 0) {
						System.out.print(" " + Pieces.BLANK.getPieces());
					} else if (boardPiecePosition[i][j] == 1) {
						System.out.print(YELLOW + " " + Pieces.CROSS.getPieces() + RESET);
					} else if (boardPiecePosition[i][j] == 2) {
						System.out.print(BLUE + " " + Pieces.CIRCLE.getPieces() + RESET);
					}
				}

				if (j == tableSize - 1) {
					System.out.printf(" " + nmb[i] + " ");
				}
			}
			System.out.printf("\n");
		}
		printFooter(this.tableSize);
	}

	public boolean deadHeat() {
		for (int i = 0; i < getTableSize(); i++) {
			for (int j = 0; j < getTableSize(); j++) {
				if (getPiece(i, j) == 0) {
					return false;
				}
			}
		}
		System.out.println("\nNobody won, you have done a dead heat.");
		return true;
	}
}
