/*
 * Copyright (C) Jose Pérez - jmpfbmx (2021)
 */
package game;

/**
 * Class used for making the board, setting/inserting/printing pieces.
 * 
 * @author jmpfbmx
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public class Board {
	/**
	 * Is used for setting the color of the piece.
	 */
	public static final String BLUE = "\u001B[34m";
	/**
	 * Is used for setting the color of the piece.
	 */
	public static final String GREEN = "\033[0;32m";
	/**
	 * Is used for resetting the color of the piece.
	 */
	public static final String RESET = "\u001B[0m";
	/**
	 * Is used for setting the color of the piece.
	 */
	public static final String YELLOW = "\u001B[33m";

	/**
	 * Is used for setting the position where pieces are going to be set.
	 */
	private int[][] boardPiecePosition = { {} };

	/**
	 * It saves the last piece position.
	 */
	private int[] boardLastPiecePosition = new int[2];

	/**
	 * Is used for setting the tableSize.
	 */
	private int tableSize;

	/**
	 * Is used for printing the numbers.
	 */
	private String[] nmb = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
			"16", "17", "18", "19" };

	/**
	 * Get the table size
	 * 
	 * @return an int saying which is the size of the table
	 */
	public int getTableSize() {
		return tableSize;
	}

	/**
	 * Set the table size
	 * 
	 * @param tableSize (It receives the tableSize that will be set)
	 */
	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}

	/**
	 * Constructor used for creating the board.
	 * 
	 * @param tableSize (It receives the tableSize that will be set)
	 */
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

	/**
	 * Empty constructor
	 */
	public Board() {
		super();
	}

	/**
	 * In this function the pieces are being inserted and also the colour is being
	 * set.
	 * 
	 * @param x      (vertically)
	 * @param y      (horizontally)
	 * @param pieces (Assign the piece to the player)
	 */
	public void insertPiece(int x, int y, Pieces pieces) {
		int n = 0;
		if (pieces == Pieces.CROSS) {
			n = 1;
		} else {
			n = 2;
		}
		this.boardLastPiecePosition[0] = x;
		this.boardLastPiecePosition[1] = y;
		this.boardLastPiecePosition[2] = n;
		this.boardPiecePosition[x][y] = n;
	}

	/**
	 * Get the piece position
	 * 
	 * @param x (vertically)
	 * @param y (horizontally)
	 * @return the piece position
	 */
	public int getPiece(int x, int y) {
		return this.boardPiecePosition[y][x];
	}

	/**
	 * This function has the letters that will be printed in the board
	 * 
	 * @param size (Depending on the size 15 or 19 letters will be printed)
	 */
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

	/**
	 * Print the header of the board
	 * 
	 * @param size (Depending on the size 15 or 19 letters will be printed)
	 */
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

	/**
	 * Print the footer of the board
	 * 
	 * @param size (Depending on the size 15 or 19 letters will be printed)
	 */
	public void printFooter(int size) {
		System.out.printf("   ");
		for (int i = 0; i < size; i++) {
			System.out.print("  ");
		}
		System.out.printf("    ");
		printABC(size);
		System.out.println();
	}

	/**
	 * Print the board
	 */
	public void showBoard() {
		printHeader(this.tableSize);

		for (int i = 0; i < boardPiecePosition.length; i++) {
			System.out.printf(" " + nmb[i]);
			for (int j = 0; j < boardPiecePosition.length; j++) {
				if (boardPiecePosition[i][j] == 0) {
					System.out.print(" " + Pieces.BLANK.getPieces());
				} else if (boardPiecePosition[i][j] == 1) {
					if (boardLastPiecePosition[0] == i && boardLastPiecePosition[1] == j) {
						System.out.print(GREEN + " " + Pieces.CROSS.getPieces() + RESET);
					} else {
						System.out.print(YELLOW + " " + Pieces.CROSS.getPieces() + RESET);
					}
				} else if (boardPiecePosition[i][j] == 2) {
					if (boardLastPiecePosition[0] == i && boardLastPiecePosition[1] == j) {
						System.out.print(GREEN + " " + Pieces.CIRCLE.getPieces() + RESET);
					} else {
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

	/**
	 * This method just returns a boolean for saying if was a dead heat.
	 * 
	 * @return true if the user has done a dead heat.
	 */
	public boolean deadHeat() {
		for (int i = 0; i < getTableSize(); i++) {
			for (int j = 0; j < getTableSize(); j++) {
				if (getPiece(i, j) == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
