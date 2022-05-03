package game;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BotString extends Player {

	public BotString(String name, boolean turn) {
		super(Database.nmb(), turn);
	}

	public BotString() {
		super();
	}

	private String piezes() {
		String piezes = Pieces.CROSS.getPieces();
		if (piece.equals(Pieces.CROSS)) {
			piezes = Pieces.CIRCLE.getPieces();
		}
		return piezes;
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

	@Override
	public int[] returnCoordinates(Board board) {
		int[] result = new int[2];
		String[] moves = new String[board.getTableSize()];
		String[] movesV1 = new String[board.getTableSize()];
		String[] movesV2 = new String[(board.getTableSize() * 2) - 1];
		String[] movesV3 = new String[(board.getTableSize() * 2) - 1];
		/* Fill the arrays */
		Arrays.fill(moves, "");
		Arrays.fill(movesV1, "");
		Arrays.fill(movesV2, "");
		Arrays.fill(movesV3, "");
		int[] attackPosition = new int[3], defendPosition = new int[3];
		Pattern movesP[] = getPattern(piece.getPieces());
		Pattern movesC[] = getPattern(piezes());
		Matcher movesM, movesMV1, movesMV2, movesMV3, movesMV4, movesMV5, movesMV6, movesMV7;
		int attack = movesP.length, defend = movesP.length;

		if (firstPiece(board)) {
			result[0] = (board.getTableSize() / 2);
			result[1] = (board.getTableSize() / 2);
			return result;
		}

		for (int i = 0; i < board.getTableSize(); i++) {
			for (int j = 0; j < board.getTableSize(); j++) {
				if (board.getPiece(i, j) == 0) {
					moves[j] += Pieces.BLANK.getPieces();
					movesV1[i] += Pieces.BLANK.getPieces();
				}
				if (board.getPiece(i, j) == 1) {
					moves[j] += Pieces.CROSS.getPieces();
					movesV1[i] += Pieces.CROSS.getPieces();
				}
				if (board.getPiece(i, j) == 2) {
					moves[j] += Pieces.CIRCLE.getPieces();
					movesV1[i] += Pieces.CIRCLE.getPieces();
				}
			}
		}

		for (int i = 0, j = ((board.getTableSize() * 2) - 2); i < board.getTableSize(); i++, j--) {
			for (int k = (board.getTableSize() - 1) - i, l = 0; k < board.getTableSize(); k++, l++) {
				if (board.getPiece(l, k) == 0) {
					movesV2[i] += Pieces.BLANK.getPieces();
				}
				if (board.getPiece(l, k) == 1) {
					movesV2[i] += Pieces.CROSS.getPieces();
				}
				if (board.getPiece(l, k) == 2) {
					movesV2[i] += Pieces.CIRCLE.getPieces();
				}
				if (j != 14) {
					if (board.getPiece(k, l) == 0) {
						movesV2[j] += Pieces.BLANK.getPieces();
					}
					if (board.getPiece(k, l) == 1) {
						movesV2[j] += Pieces.CROSS.getPieces();
					}
					if (board.getPiece(k, l) == 2) {
						movesV2[j] += Pieces.CIRCLE.getPieces();
					}
				}
			}
		}

		for (int i = 0, j = ((board.getTableSize() * 2) - 2),
				a = (board.getTableSize() - 1); i < board.getTableSize(); i++, j--, a--) {
			for (int k = (board.getTableSize() - 1) - i,
					l = (board.getTableSize() - 1); k < board.getTableSize(); k++, l--) {
				if (board.getPiece(l, k) == 0) {
					movesV3[i] += Pieces.BLANK.getPieces();
				}
				if (board.getPiece(l, k) == 1) {
					movesV3[i] += Pieces.CROSS.getPieces();
				}
				if (board.getPiece(l, k) == 2) {
					movesV3[i] += Pieces.CIRCLE.getPieces();
				}
				if (a != 0) {
					if (board.getPiece(l - a, k - a) == 0) {
						movesV3[j] += Pieces.BLANK.getPieces();
					}
					if (board.getPiece(l - a, k - a) == 1) {
						movesV3[j] += Pieces.CROSS.getPieces();
					}
					if (board.getPiece(l - a, k - a) == 2) {
						movesV3[j] += Pieces.CIRCLE.getPieces();
					}
				}
			}
		}

		for (int i = 0; i < movesP.length; i++) {
			for (int j = 0; j < board.getTableSize(); j++) {
				movesM = movesP[i].matcher(moves[j]);
				movesMV1 = movesP[i].matcher(movesV1[j]);
				movesMV4 = movesC[i].matcher(moves[j]);
				movesMV5 = movesC[i].matcher(movesV1[j]);

				while (movesM.find()) {
					if (i < attack) {
						attack = i;
						attackPosition[0] = 0;
						attackPosition[1] = movesM.start();
						attackPosition[2] = j;
					}
				}
				while (movesMV1.find()) {
					if (i < attack) {
						attack = i;
						attackPosition[0] = 1;
						attackPosition[2] = movesMV1.start();
						attackPosition[1] = j;
					}
				}
				while (movesMV4.find()) {
					if (i < defend) {
						defend = i;
						defendPosition[0] = 0;
						defendPosition[1] = movesMV4.start();
						defendPosition[2] = j;
					}
				}
				while (movesMV5.find()) {
					if (i < defend) {
						defend = i;
						defendPosition[0] = 1;
						defendPosition[2] = movesMV5.start();
						defendPosition[1] = j;
					}
				}
			}
			for (int j = 0; j < ((board.getTableSize() * 2) - 1); j++) {
				movesMV2 = movesP[i].matcher(movesV2[j]);
				movesMV3 = movesP[i].matcher(movesV3[j]);
				movesMV6 = movesC[i].matcher(movesV2[j]);
				movesMV7 = movesC[i].matcher(movesV3[j]);

				while (movesMV2.find()) {
					if (i < attack) {
						attack = i;
						attackPosition[0] = 2;
						attackPosition[2] = movesMV2.start();
						attackPosition[1] = j;
					}
				}
				while (movesMV3.find()) {
					if (i < attack) {
						attack = i;
						attackPosition[0] = 3;
						attackPosition[2] = movesMV3.start();
						attackPosition[1] = j;
					}
				}
				while (movesMV6.find()) {
					if (i < defend) {
						defend = i;
						defendPosition[0] = 2;
						defendPosition[2] = movesMV6.start();
						defendPosition[1] = j;
					}
				}
				while (movesMV7.find()) {
					if (i < defend) {
						defend = i;
						defendPosition[0] = 3;
						defendPosition[2] = movesMV7.start();
						defendPosition[1] = j;
					}
				}
			}
		}

		if (attack <= 5) {
			result = translatePosition(attackPosition, attack);
		} else if (defend <= 20) {
			result = translatePosition(defendPosition, defend);
		} else if (attack > defend) {
			result = translatePosition(defendPosition, defend);
		} else if (attack == defend) {
			result = translatePosition(attackPosition, attack);
		} else {
			result = translatePosition(attackPosition, attack);
		}

		return result;
	}

	private Pattern[] getPattern(String s) {
		return new Pattern[] { Pattern.compile("·" + s + "{4}"), Pattern.compile(s + "{4}·"),
				Pattern.compile(s + "·" + s + "{3}"), Pattern.compile(s + "{3}·" + s),
				Pattern.compile(s + "{2}·" + s + "{2}"), Pattern.compile("·" + s + "{3}·"),
				Pattern.compile("··" + s + "{3}"), Pattern.compile(s + "{3}··"),
				Pattern.compile("·" + s + "·" + s + "{2}"), Pattern.compile(s + "·" + s + "{2}·"),
				Pattern.compile("·" + s + "{2}·" + s), Pattern.compile(s + "{2}·" + s + "·"),
				Pattern.compile("···" + s + "{2}"), Pattern.compile("··" + s + "{2}·"),
				Pattern.compile("·" + s + "{2}··"), Pattern.compile(s + "{2}···"), Pattern.compile(s + "·" + s + "··"),
				Pattern.compile("·" + s + "·" + s + "·"), Pattern.compile("··" + s + "·" + s),
				Pattern.compile(s + "··" + s + "·"), Pattern.compile("·" + s + "··" + s), Pattern.compile("····" + s),
				Pattern.compile("···" + s + "·"), Pattern.compile("··" + s + "··"), Pattern.compile("·" + s + "···"),
				Pattern.compile(s + "····"), Pattern.compile("·" + s), Pattern.compile(s + "·") };
	}

	private int increase(int patternN) {
		int increase = 0;
		switch (patternN) {
		case 0, 5, 8, 10, 14, 17, 20, 24, 26:
			increase = 0;
			break;
		case 2, 6, 9, 13, 16, 18, 19, 23, 25, 27:
			increase = 1;
			break;
		case 4, 11, 12, 15, 22:
			increase = 2;
			break;
		case 3, 7, 21:
			increase = 3;
			break;
		case 1:
			increase = 4;
			break;
		}
		return increase;
	}

	private int[] translatePosition(int[] position, int patternN) {
		int[] result = new int[2];
		int[] crosswise = new int[2];
		int increase = increase(patternN);

		switch (position[0]) {
		case 0:
			result[0] = position[1] + increase;
			result[1] = position[2];
			break;
		case 1:
			result[0] = position[1];
			result[1] = position[2] + increase;
			break;
		case 2:
			crosswise = crossWise1(position[1]);
			result[0] = crosswise[0] + position[2] + increase;
			result[1] = crosswise[1] + position[2] + increase;
			break;
		case 3:
			crosswise = crossWise2(position[1]);
			result[0] = crosswise[0] - position[2] - increase;
			result[1] = crosswise[1] + position[2] + increase;
			break;
		}

		return result;
	}

	private int[] crossWise1(int nRow) {
		int[] position = new int[2];
		switch (nRow) {
		case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14:
			position[0] = 0;
			position[1] = 14 - nRow;
			break;
		case 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28:
			position[0] = nRow - 14;
			position[1] = 0;
			break;
		}
		return position;
	}

	private int[] crossWise2(int nRow) {
		int[] position = new int[2];
		switch (nRow) {
		case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14:
			position[0] = 14;
			position[1] = 14 - nRow;
			break;
		case 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28:
			position[0] = ((2 * 15) - 2) - nRow;
			position[1] = 0;
			break;
		}
		return position;
	}

}