/*
 * Copyright (C) Jose Pérez - jmpfbmx (2021)
 */
package game;

public class Board {
	private int[][] size = { {} };

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
		this.size = new int[tableSize][tableSize];
		for (int i = 0; i < size.length; i++) {
			for (int j = 0; j < size.length; j++) {
				this.size[i][j] = 0;
			}
		}
	}

	public void insertPiece(int x, int y, int playerPieze) {
		this.size[x][y] = playerPieze;
	}

	public void showBoardInformation() {
		for (int i = 0; i < size.length; i++) {
			for (int j = 0; j < size.length; j++) {
				System.out.print(size[i][j]);
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
		System.out.printf("     ");
		System.out.println();
	}

	public void printFooter(int size) {
		System.out.printf("   ");
		for (int i = 0; i < size; i++) {
			System.out.print("  ");
		}
		System.out.printf("     ");
		printABC(size);
		System.out.println();
	}

	public void showBoard() {
		printHeader(this.tableSize);

		for (int i = 0; i < size.length; i++) {
			System.out.printf(" " + nmb[i]);
			for (int j = 0; j < size.length; j++) {
				if (size[i][j] == 0) {
					System.out.printf(dot);
				} else if (size[i][j] == 1) {
					System.out.print(" X");
				} else {
					System.out.print(" O");
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