package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import game.Board;
import game.Pieces;
import game.Validator;

class BoardTest {
	Validator validator = new Validator();
	Board board;

	@Test
	void OnePiece() {
		board = new Board(15);
		board.insertPiece(0, 0, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void TwoPiecesHorizontally() {
		board = new Board(15);
		board.insertPiece(0, 0, Pieces.CROSS, false);
		board.insertPiece(0, 1, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesHorizontally() {
		board = new Board(15);
		board.insertPiece(0, 0, Pieces.CROSS, false);
		board.insertPiece(0, 1, Pieces.CROSS, false);
		board.insertPiece(0, 2, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesHorizontally() {
		board = new Board(15);
		board.insertPiece(0, 0, Pieces.CROSS, false);
		board.insertPiece(0, 1, Pieces.CROSS, false);
		board.insertPiece(0, 2, Pieces.CROSS, false);
		board.insertPiece(0, 3, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesHorizontally() {
		board = new Board(15);
		board.insertPiece(0, 0, Pieces.CROSS, false);
		board.insertPiece(0, 1, Pieces.CROSS, false);
		board.insertPiece(0, 2, Pieces.CROSS, false);
		board.insertPiece(0, 3, Pieces.CROSS, false);
		board.insertPiece(0, 4, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesVertically() {
		board = new Board(15);
		board.insertPiece(0, 0, Pieces.CROSS, false);
		board.insertPiece(1, 0, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesVertically() {
		board = new Board(15);
		board.insertPiece(0, 0, Pieces.CROSS, false);
		board.insertPiece(1, 0, Pieces.CROSS, false);
		board.insertPiece(2, 0, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesVertically() {
		board = new Board(15);
		board.insertPiece(0, 0, Pieces.CROSS, false);
		board.insertPiece(1, 0, Pieces.CROSS, false);
		board.insertPiece(2, 0, Pieces.CROSS, false);
		board.insertPiece(3, 0, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesVertically() {
		board = new Board(15);
		board.insertPiece(0, 0, Pieces.CROSS, false);
		board.insertPiece(1, 0, Pieces.CROSS, false);
		board.insertPiece(2, 0, Pieces.CROSS, false);
		board.insertPiece(3, 0, Pieces.CROSS, false);
		board.insertPiece(4, 0, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesDiagonally() {
		board = new Board(15);
		board.insertPiece(0, 0, Pieces.CROSS, false);
		board.insertPiece(1, 1, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesDiagonally() {
		board = new Board(15);
		board.insertPiece(0, 0, Pieces.CROSS, false);
		board.insertPiece(1, 1, Pieces.CROSS, false);
		board.insertPiece(2, 2, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesDiagonally() {
		board = new Board(15);
		board.insertPiece(0, 0, Pieces.CROSS, false);
		board.insertPiece(1, 1, Pieces.CROSS, false);
		board.insertPiece(2, 2, Pieces.CROSS, false);
		board.insertPiece(3, 3, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesDiagonally() {
		board = new Board(15);
		board.insertPiece(0, 0, Pieces.CROSS, false);
		board.insertPiece(1, 1, Pieces.CROSS, false);
		board.insertPiece(2, 2, Pieces.CROSS, false);
		board.insertPiece(3, 3, Pieces.CROSS, false);
		board.insertPiece(4, 4, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void OnePieceV1() {
		board = new Board(15);
		board.insertPiece(0, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void TwoPiecesHorizontallyV1() {
		board = new Board(15);
		board.insertPiece(0, 14, Pieces.CROSS, false);
		board.insertPiece(0, 13, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesHorizontallyV1() {
		board = new Board(15);
		board.insertPiece(0, 14, Pieces.CROSS, false);
		board.insertPiece(0, 13, Pieces.CROSS, false);
		board.insertPiece(0, 12, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesHorizontallyV1() {
		board = new Board(15);
		board.insertPiece(0, 14, Pieces.CROSS, false);
		board.insertPiece(0, 13, Pieces.CROSS, false);
		board.insertPiece(0, 12, Pieces.CROSS, false);
		board.insertPiece(0, 11, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesHorizontallyV1() {
		board = new Board(15);
		board.insertPiece(0, 14, Pieces.CROSS, false);
		board.insertPiece(0, 13, Pieces.CROSS, false);
		board.insertPiece(0, 12, Pieces.CROSS, false);
		board.insertPiece(0, 11, Pieces.CROSS, false);
		board.insertPiece(0, 10, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesVerticallyV1() {
		board = new Board(15);
		board.insertPiece(0, 14, Pieces.CROSS, false);
		board.insertPiece(1, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesVerticallyV1() {
		board = new Board(15);
		board.insertPiece(0, 14, Pieces.CROSS, false);
		board.insertPiece(1, 14, Pieces.CROSS, false);
		board.insertPiece(2, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesVerticallyV1() {
		board = new Board(15);
		board.insertPiece(0, 14, Pieces.CROSS, false);
		board.insertPiece(1, 14, Pieces.CROSS, false);
		board.insertPiece(2, 14, Pieces.CROSS, false);
		board.insertPiece(3, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesVerticallyV1() {
		board = new Board(15);
		board.insertPiece(0, 14, Pieces.CROSS, false);
		board.insertPiece(1, 14, Pieces.CROSS, false);
		board.insertPiece(2, 14, Pieces.CROSS, false);
		board.insertPiece(3, 14, Pieces.CROSS, false);
		board.insertPiece(4, 14, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesDiagonallyV1() {
		board = new Board(15);
		board.insertPiece(0, 14, Pieces.CROSS, false);
		board.insertPiece(1, 13, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesDiagonallyV1() {
		board = new Board(15);
		board.insertPiece(0, 14, Pieces.CROSS, false);
		board.insertPiece(1, 13, Pieces.CROSS, false);
		board.insertPiece(2, 12, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesDiagonallyV1() {
		board = new Board(15);
		board.insertPiece(0, 14, Pieces.CROSS, false);
		board.insertPiece(1, 13, Pieces.CROSS, false);
		board.insertPiece(2, 12, Pieces.CROSS, false);
		board.insertPiece(3, 11, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesDiagonallyV1() {
		board = new Board(15);
		board.insertPiece(0, 14, Pieces.CROSS, false);
		board.insertPiece(1, 13, Pieces.CROSS, false);
		board.insertPiece(2, 12, Pieces.CROSS, false);
		board.insertPiece(3, 11, Pieces.CROSS, false);
		board.insertPiece(4, 10, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void OnePieceV2() {
		board = new Board(15);
		board.insertPiece(14, 0, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void TwoPiecesHorizontallyV2() {
		board = new Board(15);
		board.insertPiece(14, 0, Pieces.CROSS, false);
		board.insertPiece(13, 0, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesHorizontallyV2() {
		board = new Board(15);
		board.insertPiece(14, 0, Pieces.CROSS, false);
		board.insertPiece(13, 0, Pieces.CROSS, false);
		board.insertPiece(12, 0, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesHorizontallyV2() {
		board = new Board(15);
		board.insertPiece(14, 0, Pieces.CROSS, false);
		board.insertPiece(13, 0, Pieces.CROSS, false);
		board.insertPiece(12, 0, Pieces.CROSS, false);
		board.insertPiece(11, 0, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesHorizontallyV2() {
		board = new Board(15);
		board.insertPiece(14, 0, Pieces.CROSS, false);
		board.insertPiece(13, 0, Pieces.CROSS, false);
		board.insertPiece(12, 0, Pieces.CROSS, false);
		board.insertPiece(11, 0, Pieces.CROSS, false);
		board.insertPiece(10, 0, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesVerticallyV2() {
		board = new Board(15);
		board.insertPiece(14, 0, Pieces.CROSS, false);
		board.insertPiece(14, 1, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesVerticallyV2() {
		board = new Board(15);
		board.insertPiece(14, 0, Pieces.CROSS, false);
		board.insertPiece(14, 1, Pieces.CROSS, false);
		board.insertPiece(14, 2, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesVerticallyV2() {
		board = new Board(15);
		board.insertPiece(14, 0, Pieces.CROSS, false);
		board.insertPiece(14, 1, Pieces.CROSS, false);
		board.insertPiece(14, 2, Pieces.CROSS, false);
		board.insertPiece(14, 3, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesVerticallyV2() {
		board = new Board(15);
		board.insertPiece(14, 0, Pieces.CROSS, false);
		board.insertPiece(14, 1, Pieces.CROSS, false);
		board.insertPiece(14, 2, Pieces.CROSS, false);
		board.insertPiece(14, 3, Pieces.CROSS, false);
		board.insertPiece(14, 4, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesDiagonallyV2() {
		board = new Board(15);
		board.insertPiece(14, 0, Pieces.CROSS, false);
		board.insertPiece(13, 1, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesDiagonallyV2() {
		board = new Board(15);
		board.insertPiece(14, 0, Pieces.CROSS, false);
		board.insertPiece(13, 1, Pieces.CROSS, false);
		board.insertPiece(12, 2, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesDiagonallyV2() {
		board = new Board(15);
		board.insertPiece(14, 0, Pieces.CROSS, false);
		board.insertPiece(13, 1, Pieces.CROSS, false);
		board.insertPiece(12, 2, Pieces.CROSS, false);
		board.insertPiece(11, 3, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesDiagonallyV2() {
		board = new Board(15);
		board.insertPiece(14, 0, Pieces.CROSS, false);
		board.insertPiece(13, 1, Pieces.CROSS, false);
		board.insertPiece(12, 2, Pieces.CROSS, false);
		board.insertPiece(11, 3, Pieces.CROSS, false);
		board.insertPiece(10, 4, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void OnePieceV3() {
		board = new Board(15);
		board.insertPiece(14, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void TwoPiecesHorizontallyV3() {
		board = new Board(15);
		board.insertPiece(14, 14, Pieces.CROSS, false);
		board.insertPiece(14, 13, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesHorizontallyV3() {
		board = new Board(15);
		board.insertPiece(14, 14, Pieces.CROSS, false);
		board.insertPiece(14, 13, Pieces.CROSS, false);
		board.insertPiece(14, 12, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesHorizontallyV3() {
		board = new Board(15);
		board.insertPiece(14, 14, Pieces.CROSS, false);
		board.insertPiece(14, 13, Pieces.CROSS, false);
		board.insertPiece(14, 12, Pieces.CROSS, false);
		board.insertPiece(14, 11, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesHorizontallyV3() {
		board = new Board(15);
		board.insertPiece(14, 14, Pieces.CROSS, false);
		board.insertPiece(14, 13, Pieces.CROSS, false);
		board.insertPiece(14, 12, Pieces.CROSS, false);
		board.insertPiece(14, 11, Pieces.CROSS, false);
		board.insertPiece(14, 10, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesVerticallyV3() {
		board = new Board(15);
		board.insertPiece(14, 14, Pieces.CROSS, false);
		board.insertPiece(13, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesVerticallyV3() {
		board = new Board(15);
		board.insertPiece(14, 14, Pieces.CROSS, false);
		board.insertPiece(13, 14, Pieces.CROSS, false);
		board.insertPiece(12, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesVerticallyV3() {
		board = new Board(15);
		board.insertPiece(14, 14, Pieces.CROSS, false);
		board.insertPiece(13, 14, Pieces.CROSS, false);
		board.insertPiece(12, 14, Pieces.CROSS, false);
		board.insertPiece(11, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesVerticallyV3() {
		board = new Board(15);
		board.insertPiece(14, 14, Pieces.CROSS, false);
		board.insertPiece(13, 14, Pieces.CROSS, false);
		board.insertPiece(12, 14, Pieces.CROSS, false);
		board.insertPiece(11, 14, Pieces.CROSS, false);
		board.insertPiece(10, 14, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesDiagonallyeV3() {
		board = new Board(15);
		board.insertPiece(14, 14, Pieces.CROSS, false);
		board.insertPiece(13, 13, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesDiagonallyV3() {
		board = new Board(15);
		board.insertPiece(14, 14, Pieces.CROSS, false);
		board.insertPiece(13, 13, Pieces.CROSS, false);
		board.insertPiece(12, 12, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesDiagonallyV3() {
		board = new Board(15);
		board.insertPiece(14, 14, Pieces.CROSS, false);
		board.insertPiece(13, 13, Pieces.CROSS, false);
		board.insertPiece(12, 12, Pieces.CROSS, false);
		board.insertPiece(11, 11, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesDiagonallyV3() {
		board = new Board(15);
		board.insertPiece(14, 14, Pieces.CROSS, false);
		board.insertPiece(13, 13, Pieces.CROSS, false);
		board.insertPiece(12, 12, Pieces.CROSS, false);
		board.insertPiece(11, 11, Pieces.CROSS, false);
		board.insertPiece(10, 10, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void OnePieceV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void TwoPiecesHorizontallyV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(0, 8, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesHorizontallyV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(0, 8, Pieces.CROSS, false);
		board.insertPiece(0, 9, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesHorizontallyV4() {
		board = new Board(15);
		board.insertPiece(0, 5, Pieces.CROSS, false);
		board.insertPiece(0, 6, Pieces.CROSS, false);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(0, 8, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesHorizontallyV4() {
		board = new Board(15);
		board.insertPiece(0, 5, Pieces.CROSS, false);
		board.insertPiece(0, 6, Pieces.CROSS, false);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(0, 8, Pieces.CROSS, false);
		board.insertPiece(0, 9, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesVerticallyV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(1, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesVerticallyV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(1, 7, Pieces.CROSS, false);
		board.insertPiece(2, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesVerticallyV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(1, 7, Pieces.CROSS, false);
		board.insertPiece(2, 7, Pieces.CROSS, false);
		board.insertPiece(3, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesVerticallyV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(1, 7, Pieces.CROSS, false);
		board.insertPiece(2, 7, Pieces.CROSS, false);
		board.insertPiece(3, 7, Pieces.CROSS, false);
		board.insertPiece(4, 7, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesDiagonallyV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(1, 8, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesDiagonallyV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(1, 8, Pieces.CROSS, false);
		board.insertPiece(2, 9, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesDiagonallyV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(1, 8, Pieces.CROSS, false);
		board.insertPiece(2, 9, Pieces.CROSS, false);
		board.insertPiece(3, 10, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesDiagonallyV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(1, 8, Pieces.CROSS, false);
		board.insertPiece(2, 9, Pieces.CROSS, false);
		board.insertPiece(3, 10, Pieces.CROSS, false);
		board.insertPiece(4, 11, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesReversedDiagonallyV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(1, 6, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesReversedDiagonallyV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(1, 6, Pieces.CROSS, false);
		board.insertPiece(2, 5, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesReversedDiagonallyV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(1, 6, Pieces.CROSS, false);
		board.insertPiece(2, 5, Pieces.CROSS, false);
		board.insertPiece(3, 4, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesReversedDiagonallyV4() {
		board = new Board(15);
		board.insertPiece(0, 7, Pieces.CROSS, false);
		board.insertPiece(1, 6, Pieces.CROSS, false);
		board.insertPiece(2, 5, Pieces.CROSS, false);
		board.insertPiece(3, 4, Pieces.CROSS, false);
		board.insertPiece(4, 3, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void OnePieceV5() {
		board = new Board(15);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void TwoPiecesHorizontallyV5() {
		board = new Board(15);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(7, 1, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesHorizontallyV5() {
		board = new Board(15);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(7, 1, Pieces.CROSS, false);
		board.insertPiece(7, 2, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesHorizontallyV5() {
		board = new Board(15);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(7, 1, Pieces.CROSS, false);
		board.insertPiece(7, 2, Pieces.CROSS, false);
		board.insertPiece(7, 3, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesHorizontallyV5() {
		board = new Board(15);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(7, 1, Pieces.CROSS, false);
		board.insertPiece(7, 2, Pieces.CROSS, false);
		board.insertPiece(7, 3, Pieces.CROSS, false);
		board.insertPiece(7, 4, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesVerticallyV5() {
		board = new Board(15);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(8, 0, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesVerticallyV5() {
		board = new Board(15);
		board.insertPiece(6, 0, Pieces.CROSS, false);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(8, 0, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesVerticallyV5() {
		board = new Board(15);
		board.insertPiece(5, 0, Pieces.CROSS, false);
		board.insertPiece(6, 0, Pieces.CROSS, false);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(8, 0, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesVerticallyV5() {
		board = new Board(15);
		board.insertPiece(5, 0, Pieces.CROSS, false);
		board.insertPiece(6, 0, Pieces.CROSS, false);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(8, 0, Pieces.CROSS, false);
		board.insertPiece(9, 0, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesDiagonallyV5() {
		board = new Board(15);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(8, 1, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesDiagonallyV5() {
		board = new Board(15);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(8, 1, Pieces.CROSS, false);
		board.insertPiece(9, 2, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesDiagonallyV5() {
		board = new Board(15);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(8, 1, Pieces.CROSS, false);
		board.insertPiece(9, 2, Pieces.CROSS, false);
		board.insertPiece(10, 3, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesDiagonallyV5() {
		board = new Board(15);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(8, 1, Pieces.CROSS, false);
		board.insertPiece(9, 2, Pieces.CROSS, false);
		board.insertPiece(10, 3, Pieces.CROSS, false);
		board.insertPiece(11, 4, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesReversedDiagonallyV5() {
		board = new Board(15);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(6, 1, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesReversedDiagonallyV5() {
		board = new Board(15);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(6, 1, Pieces.CROSS, false);
		board.insertPiece(5, 2, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesReversedDiagonallyV5() {
		board = new Board(15);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(6, 1, Pieces.CROSS, false);
		board.insertPiece(5, 2, Pieces.CROSS, false);
		board.insertPiece(4, 3, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesReversedDiagonallyV5() {
		board = new Board(15);
		board.insertPiece(7, 0, Pieces.CROSS, false);
		board.insertPiece(6, 1, Pieces.CROSS, false);
		board.insertPiece(5, 2, Pieces.CROSS, false);
		board.insertPiece(4, 3, Pieces.CROSS, false);
		board.insertPiece(3, 4, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void OnePieceV6() {
		board = new Board(15);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void TwoPiecesHorizontallyV6() {
		board = new Board(15);
		board.insertPiece(14, 6, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesHorizontallyV6() {
		board = new Board(15);
		board.insertPiece(14, 6, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		board.insertPiece(14, 8, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesHorizontallyV6() {
		board = new Board(15);
		board.insertPiece(14, 5, Pieces.CROSS, false);
		board.insertPiece(14, 6, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		board.insertPiece(14, 8, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesHorizontallyV6() {
		board = new Board(15);
		board.insertPiece(14, 5, Pieces.CROSS, false);
		board.insertPiece(14, 6, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		board.insertPiece(14, 8, Pieces.CROSS, false);
		board.insertPiece(14, 9, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesVerticallyV6() {
		board = new Board(15);
		board.insertPiece(13, 7, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesVerticallyV6() {
		board = new Board(15);
		board.insertPiece(13, 7, Pieces.CROSS, false);
		board.insertPiece(12, 7, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesVerticallyV6() {
		board = new Board(15);
		board.insertPiece(11, 7, Pieces.CROSS, false);
		board.insertPiece(12, 7, Pieces.CROSS, false);
		board.insertPiece(13, 7, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesVerticallyV6() {
		board = new Board(15);
		board.insertPiece(10, 7, Pieces.CROSS, false);
		board.insertPiece(11, 7, Pieces.CROSS, false);
		board.insertPiece(12, 7, Pieces.CROSS, false);
		board.insertPiece(13, 7, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesDiagonallyV6() {
		board = new Board(15);
		board.insertPiece(13, 6, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesDiagonallyV6() {
		board = new Board(15);
		board.insertPiece(12, 5, Pieces.CROSS, false);
		board.insertPiece(13, 6, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesDiagonallyV6() {
		board = new Board(15);
		board.insertPiece(11, 4, Pieces.CROSS, false);
		board.insertPiece(12, 5, Pieces.CROSS, false);
		board.insertPiece(13, 6, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesDiagonallyV6() {
		board = new Board(15);
		board.insertPiece(10, 3, Pieces.CROSS, false);
		board.insertPiece(11, 4, Pieces.CROSS, false);
		board.insertPiece(12, 5, Pieces.CROSS, false);
		board.insertPiece(13, 6, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesReversedDiagonallyV6() {
		board = new Board(15);
		board.insertPiece(13, 8, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesReversedDiagonallyV6() {
		board = new Board(15);
		board.insertPiece(12, 9, Pieces.CROSS, false);
		board.insertPiece(13, 8, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesReversedDiagonallyV6() {
		board = new Board(15);
		board.insertPiece(11, 10, Pieces.CROSS, false);
		board.insertPiece(12, 9, Pieces.CROSS, false);
		board.insertPiece(13, 8, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesReversedDiagonallyV6() {
		board = new Board(15);
		board.insertPiece(10, 11, Pieces.CROSS, false);
		board.insertPiece(11, 10, Pieces.CROSS, false);
		board.insertPiece(12, 9, Pieces.CROSS, false);
		board.insertPiece(13, 8, Pieces.CROSS, false);
		board.insertPiece(14, 7, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void OnePieceV7() {
		board = new Board(15);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void TwoPiecesHorizontallyV7() {
		board = new Board(15);
		board.insertPiece(7, 13, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesHorizontallyV7() {
		board = new Board(15);
		board.insertPiece(7, 12, Pieces.CROSS, false);
		board.insertPiece(7, 13, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesHorizontallyV7() {
		board = new Board(15);
		board.insertPiece(7, 11, Pieces.CROSS, false);
		board.insertPiece(7, 12, Pieces.CROSS, false);
		board.insertPiece(7, 13, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesHorizontallyV7() {
		board = new Board(15);
		board.insertPiece(7, 10, Pieces.CROSS, false);
		board.insertPiece(7, 11, Pieces.CROSS, false);
		board.insertPiece(7, 12, Pieces.CROSS, false);
		board.insertPiece(7, 13, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesVerticallyV7() {
		board = new Board(15);
		board.insertPiece(6, 14, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesVerticallyV7() {
		board = new Board(15);
		board.insertPiece(6, 14, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		board.insertPiece(8, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesVerticallyV7() {
		board = new Board(15);
		board.insertPiece(5, 14, Pieces.CROSS, false);
		board.insertPiece(6, 14, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		board.insertPiece(8, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesVerticallyV7() {
		board = new Board(15);
		board.insertPiece(5, 14, Pieces.CROSS, false);
		board.insertPiece(6, 14, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		board.insertPiece(8, 14, Pieces.CROSS, false);
		board.insertPiece(9, 14, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesDiagonallyV7() {
		board = new Board(15);
		board.insertPiece(6, 13, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesDiagonallyV7() {
		board = new Board(15);
		board.insertPiece(5, 12, Pieces.CROSS, false);
		board.insertPiece(6, 13, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesDiagonallyV7() {
		board = new Board(15);
		board.insertPiece(4, 11, Pieces.CROSS, false);
		board.insertPiece(5, 12, Pieces.CROSS, false);
		board.insertPiece(6, 13, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesDiagonallyV7() {
		board = new Board(15);
		board.insertPiece(3, 10, Pieces.CROSS, false);
		board.insertPiece(4, 11, Pieces.CROSS, false);
		board.insertPiece(5, 12, Pieces.CROSS, false);
		board.insertPiece(6, 13, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesReversedDiagonallyV7() {
		board = new Board(15);
		board.insertPiece(8, 13, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesReversedDiagonallyV7() {
		board = new Board(15);
		board.insertPiece(9, 12, Pieces.CROSS, false);
		board.insertPiece(8, 13, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesReversedDiagonallyV7() {
		board = new Board(15);
		board.insertPiece(10, 11, Pieces.CROSS, false);
		board.insertPiece(9, 12, Pieces.CROSS, false);
		board.insertPiece(8, 13, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesReversedDiagonallyV7() {
		board = new Board(15);
		board.insertPiece(11, 10, Pieces.CROSS, false);
		board.insertPiece(10, 11, Pieces.CROSS, false);
		board.insertPiece(9, 12, Pieces.CROSS, false);
		board.insertPiece(8, 13, Pieces.CROSS, false);
		board.insertPiece(7, 14, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void OnePieceV8() {
		board = new Board(15);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void TwoPiecesHorizontallyV8() {
		board = new Board(15);
		board.insertPiece(7, 6, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesHorizontallyV8() {
		board = new Board(15);
		board.insertPiece(7, 6, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		board.insertPiece(7, 8, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesHorizontallyV8() {
		board = new Board(15);
		board.insertPiece(7, 5, Pieces.CROSS, false);
		board.insertPiece(7, 6, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		board.insertPiece(7, 8, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesHorizontallyV8() {
		board = new Board(15);
		board.insertPiece(7, 5, Pieces.CROSS, false);
		board.insertPiece(7, 6, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		board.insertPiece(7, 8, Pieces.CROSS, false);
		board.insertPiece(7, 9, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesVerticallyV8() {
		board = new Board(15);
		board.insertPiece(6, 7, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesVerticallyV8() {
		board = new Board(15);
		board.insertPiece(6, 7, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		board.insertPiece(8, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesVerticallyV8() {
		board = new Board(15);
		board.insertPiece(5, 7, Pieces.CROSS, false);
		board.insertPiece(6, 7, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		board.insertPiece(8, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesVerticallyV8() {
		board = new Board(15);
		board.insertPiece(5, 7, Pieces.CROSS, false);
		board.insertPiece(6, 7, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		board.insertPiece(8, 7, Pieces.CROSS, false);
		board.insertPiece(9, 7, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesDiagonallyV8() {
		board = new Board(15);
		board.insertPiece(6, 6, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesDiagonallyV8() {
		board = new Board(15);
		board.insertPiece(5, 5, Pieces.CROSS, false);
		board.insertPiece(6, 6, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesDiagonallyV8() {
		board = new Board(15);
		board.insertPiece(4, 4, Pieces.CROSS, false);
		board.insertPiece(5, 5, Pieces.CROSS, false);
		board.insertPiece(6, 6, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesDiagonallyV8() {
		board = new Board(15);
		board.insertPiece(3, 3, Pieces.CROSS, false);
		board.insertPiece(4, 4, Pieces.CROSS, false);
		board.insertPiece(5, 5, Pieces.CROSS, false);
		board.insertPiece(6, 6, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}

	@Test
	void TwoPiecesReversedDiagonallyV8() {
		board = new Board(15);
		board.insertPiece(8, 8, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void ThreePiecesReversedDiagonallyV8() {
		board = new Board(15);
		board.insertPiece(9, 9, Pieces.CROSS, false);
		board.insertPiece(8, 8, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FourPiecesReversedDiagonallyV8() {
		board = new Board(15);
		board.insertPiece(10, 10, Pieces.CROSS, false);
		board.insertPiece(9, 9, Pieces.CROSS, false);
		board.insertPiece(8, 8, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		assertFalse(validator.validateWin(board));
	}

	@Test
	void FivePiecesReversedDiagonallyV8() {
		board = new Board(15);
		board.insertPiece(11, 11, Pieces.CROSS, false);
		board.insertPiece(10, 10, Pieces.CROSS, false);
		board.insertPiece(9, 9, Pieces.CROSS, false);
		board.insertPiece(8, 8, Pieces.CROSS, false);
		board.insertPiece(7, 7, Pieces.CROSS, false);
		assertTrue(validator.validateWin(board));
	}
}
