package game;

public abstract class Player {

	protected String name;
	protected int score;
	protected Pieces piece;
	protected boolean turn;
	public int symbolPiece;
	private static int n = 0;

	public Player(String name, boolean turn) {
		this.name = name;
		this.turn = turn;
		setPiece(++n);
	}

	private void setPiece(int symbolPiece) {
		switch (symbolPiece) {
		case 1:
			this.piece = Pieces.CROSS;
			break;
		case 2:
			this.piece = Pieces.CIRCLE;
			break;
		default:
			throw new IllegalArgumentException("Piece is invalid");
		}
		if (n == 2) {
			n = 0;
		}
	}

	public abstract int[] returnCoordinates(Board board);

	public int setN() {
		return n;
	}

	public Player() {
	}

	// GETTERS AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Pieces getPiece() {
		return piece;
	}

	public boolean getTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

}