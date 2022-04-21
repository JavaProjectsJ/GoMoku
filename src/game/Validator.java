package game;

public class Validator {

    public boolean validateWin(Board board) {
        if(validateHorizontalToWin(board)) {
            return true;
        };
        if(validateVerticalToWin(board)) {
            return true;
        };
        if(validateDiagonalToWin(board)) {
            return true;
        };
        if(validateReversedDiagonalToWin(board)) {
            return true;
        };
        return false;
    }

    public boolean validateHorizontalToWin(Board board) {
        /* Validate if in the horizontal line are 5 pieces */
        for (int i = 0; i < board.getTableSize(); i++) {
            for (int j = 0; j < board.getTableSize() - 4; j++) {
                if (board.getPiece(i, j) != 0) {
                    if (board.getPiece(i, j) == board.getPiece(i, j + 1)
                            && board.getPiece(i, j) == board.getPiece(i, j + 2)
                            && board.getPiece(i, j) == board.getPiece(i, j + 3)
                            && board.getPiece(i, j) == board.getPiece(i, j + 4)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean validateVerticalToWin(Board board) {
        /* Validate if in the vertical line are 5 pieces */
        for (int i = 0; i < board.getTableSize(); i++) {
            for (int j = 0; j < board.getTableSize() - 4; j++) {
                if (board.getPiece(j, i) != 0) {
                    if (board.getPiece(j, i) == board.getPiece(j + 1, i)
                            && board.getPiece(j, i) == board.getPiece(j + 2, i)
                            && board.getPiece(j, i) == board.getPiece(j + 3, i)
                            && board.getPiece(j, i) == board.getPiece(j + 4, i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean validateDiagonalToWin(Board board) {
        /* Validate if in the diagonal line are 5 pieces */
        for (int i = 0; i < board.getTableSize() - 4; i++) {
            for (int j = 0; j < board.getTableSize() - 4; j++) {
                if (board.getPiece(i, j) != 0) {
                    if (board.getPiece(i, j) == board.getPiece(i + 1, j + 1)
                            && board.getPiece(i, j) == board.getPiece(i + 2, j + 2)
                            && board.getPiece(i, j) == board.getPiece(i + 3, j + 3)
                            && board.getPiece(i, j) == board.getPiece(i + 4, j + 4)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean validateReversedDiagonalToWin(Board board) {
        /* Validate if in the reversed diagonal line are 5 pieces */
        for (int i = 0; i < board.getTableSize() - 4; i++) {
            for (int j = 4; j < board.getTableSize(); j++) {
                if (board.getPiece(i, j) != 0) {
                    if (board.getPiece(i, j) == board.getPiece(i + 1, j - 1)
                            && board.getPiece(i, j) == board.getPiece(i + 2, j - 2)
                            && board.getPiece(i, j) == board.getPiece(i + 3, j - 3)
                            && board.getPiece(i, j) == board.getPiece(i + 4, j - 4)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
