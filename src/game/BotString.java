package game;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BotString extends Player {

	public BotString(String name, boolean turn) {
		super(Database.nmb(), turn);
		// this.turn = turn;
	}

	public BotString() {
		super();
	}

	private String peece() {
		String peece = "X";
		if (piece.equals(Pieces.CROSS)) {
			peece = "O";
		}
		return peece;
	}

	private boolean firstPiece(Board board) {
		for (int i = 0; i < board.getTableSize(); i++) {
			for (int j = 0; j < board.getTableSize(); j++) {
				if (board.getPiece(i, j) != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public int[] returnCoordinates(Board board) {
		int[] result = new int[2];

		if (firstPiece(board)) {
			result[0] = 7;
			result[1] = 7;
			return result;
		}

		String[] moves = new String[15];
		String[] movesV1 = new String[15];
		String[] movesV2 = new String[29];
		String[] movesV3 = new String[29];
		/* Fill the arrays */
		Arrays.fill(moves, "");
		Arrays.fill(movesV1, "");
		Arrays.fill(movesV2, "");
		Arrays.fill(movesV3, "");

		for (int i = 0; i < board.getTableSize(); i++) {
			for (int j = 0; j < board.getTableSize(); j++) {
				if (board.getPiece(i, j) == 0) {
					moves[i] += "·";
					movesV1[j] += "·";
				}
				if (board.getPiece(i, j) == 1) {
					moves[i] += "X";
					movesV1[j] += "X";
				}
				if (board.getPiece(i, j) == 2) {
					moves[i] += "O";
					movesV1[j] += "O";
				}
			}
		}

		for (int i = 0, j = 28; i < 15; i++, j--) {
			for (int k = 14 - i, l = 0; k < 15; k++, l++) {
				if (board.getPiece(l, k) == 0) {
					movesV2[i] += "·";
				}
				if (board.getPiece(l, k) == 1) {
					movesV2[i] += "X";
				}
				if (board.getPiece(l, k) == 2) {
					movesV2[i] += "O";
				}
				if (j != 14) {
					if (board.getPiece(k, l) == 0) {
						movesV2[j] += "·";
					}
					if (board.getPiece(k, l) == 1) {
						movesV2[j] += "X";
					}
					if (board.getPiece(k, l) == 2) {
						movesV2[j] += "O";
					}
				}
			}
		}

		for (int i = 0, j = 28, a = 14; i < 15; i++, j--, a--) {
			for (int k = 14 - i, l = 14; k < 15; k++, l--) {
				if (board.getPiece(l, k) == 0) {
					movesV3[i] += "·";
				}
				if (board.getPiece(l, k) == 1) {
					movesV3[i] += "X";
				}
				if (board.getPiece(l, k) == 2) {
					movesV3[i] += "O";
				}
				if (a != 0) {
					if (board.getPiece(k - a, l - a) == 0) {
						movesV3[j] += "·";
					}
					if (board.getPiece(k - a, l - a) == 1) {
						movesV3[j] += "X";
					}
					if (board.getPiece(k - a, l - a) == 2) {
						movesV3[j] += "O";
					}
				}
			}
		}

		System.out.println("Horizontal\n" + Arrays.toString(moves) + "\n");
		System.out.println("Vertical\n" + Arrays.toString(movesV1) + "\n");
		System.out.println("Diagonal\n" + Arrays.toString(movesV2) + "\n");
		System.out.println("Diagonal invertida\n" + Arrays.toString(movesV3) + "\n");

		boolean mv1 = false, mv2 = false;

		int attack = 13, defend = 13;

		int[] attackPosition = new int[3], defendPosition = new int[3];
		System.out.println(String.valueOf(piece.getPieces()));

		System.out.println(getPattern(peece()));

		Pattern movesP[] = getPattern(String.valueOf(piece.getPieces()));
		Pattern movesC[] = getPattern(peece());

		Matcher movesM, movesMV1, movesMV2, movesMV3, movesMV4, movesMV5, movesMV6, movesMV7;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				movesM = movesP[i].matcher(moves[j]);
				movesMV1 = movesP[i].matcher(movesV1[j]);
				movesMV2 = movesP[i].matcher(movesV2[j]);
				movesMV3 = movesP[i].matcher(movesV3[j]);

				movesMV4 = movesC[i].matcher(moves[j]);
				movesMV5 = movesC[i].matcher(movesV1[j]);
				movesMV6 = movesC[i].matcher(movesV2[j]);
				movesMV7 = movesC[i].matcher(movesV3[j]);

				if (!mv1) {
					while (movesM.find()) {
						System.out.printf("atq h %s %s %d\n", i, movesM.start(), j);
						mv1 = true;
						if (i < attack) {
							attack = i;
							attackPosition[0] = 0;
							attackPosition[1] = movesM.start();
							attackPosition[2] = j;
						}
					}
				}
				if (!mv1) {
					while (movesMV1.find()) {
						System.out.printf("atq v %s %s %d\n", i, movesMV1.start(), j);
						mv1 = true;
						if (i < attack) {
							attack = i;
							attackPosition[0] = 0;
							attackPosition[2] = movesMV1.start();
							attackPosition[1] = j;
						}
					}
				}
				if (!mv1) {
					while (movesMV2.find()) {
						System.out.printf("atq h %s %s %d\n", i, movesMV2.start(), j);
						mv1 = true;
						if (i < attack) {
							attack = i;
							attackPosition[0] = 0;
							attackPosition[1] = movesMV2.start();
							attackPosition[2] = j;
						}
					}
				}
				if (!mv1) {
					while (movesMV3.find()) {
						System.out.printf("atq h %s %s %d\n", i, movesMV3.start(), j);
						mv1 = true;
						if (i < attack) {
							attack = i;
							attackPosition[0] = 0;
							attackPosition[1] = movesMV3.start();
							attackPosition[2] = j;
						}
					}
				}
				if (!mv2) {
					while (movesMV4.find()) {
						System.out.printf("dfs h %s %s %d\n", i, j, movesMV4.start());
						mv2 = true;
						if (i < defend) {
							defend = i;
							defendPosition[0] = 0;
							defendPosition[1] = movesMV4.start();
							defendPosition[2] = j;
						}
					}
				}
				if (!mv2) {
					while (movesMV5.find()) {
						System.out.printf("dfs v %s %s %d\n", i, j, movesMV5.start());
						mv2 = true;
						if (i < defend) {
							defend = i;
							defendPosition[0] = 0;
							defendPosition[2] = movesMV5.start();
							defendPosition[1] = j;
						}
					}
				}
				if (!mv2) {
					while (movesMV6.find()) {
						System.out.printf("dfs h %s %s %d\n", i, j, movesMV6.start());
						mv2 = true;
						if (i < defend) {
							defend = i;
							defendPosition[0] = 0;
							defendPosition[1] = movesMV6.start();
							defendPosition[2] = j;
						}
					}
				}
				if (!mv2) {
					while (movesMV7.find()) {
						System.out.printf("dfs h %s %s %d\n", i, j, movesMV7.start());
						mv2 = true;
						if (i < defend) {
							defend = i;
							defendPosition[0] = 0;
							defendPosition[1] = movesMV7.start();
							defendPosition[2] = j;
						}
					}
				}
			}
		}
		if (attack <= defend) {
			result = translatePosition(attackPosition, attack);
		} else {
			result = translatePosition(defendPosition, defend);
		}
		System.out.println(attack);
		System.out.println(defend);
		return result;
	}

	private int[] translatePosition(int[] position, int patternN) {
		int[] result = new int[2];
		int increase = increase(patternN);

		switch (position[0]) {
		case 0: // horizontales
			result[0] = position[1] + increase;
			result[1] = position[2];
			break;
		case 1: // veticales
			result[0] = position[1];
			result[1] = position[2] - increase;
			break;
		case 2:

			break;
		case 3:

			break;
		}

		return result;
	}

	private int increase(int patternN) {
		int increase = 0;
		switch (patternN) {
		case 0, 5, 9, 12:
			increase = 0;
			break;
		case 2, 7, 11, 13:
			increase = 1;
			break;
		case 4, 8, 10:
			increase = 2;
			break;
		case 3, 6:
			increase = 3;
			break;
		case 1:
			increase = 4;
			break;
		}
		return increase;
	}

	private Pattern[] getPattern(String s) {
		return new Pattern[] { Pattern.compile("·" + s + "{4}"), Pattern.compile(s + "{4}·"),
				Pattern.compile(s + "·" + s + "{3}"), Pattern.compile(s + "{3}·" + s),
				Pattern.compile(s + "{2}·" + s + "{2}"), Pattern.compile("·" + s + "{3}"), Pattern.compile(s + "{3}·"),
				Pattern.compile(s + "·" + s + "{2}"), Pattern.compile(s + "{2}·" + s), Pattern.compile("·" + s + "{2}"),
				Pattern.compile(s + "{2}·"), Pattern.compile(s + "·" + s), Pattern.compile("·" + s),
				Pattern.compile(s + "·") };
	}

}