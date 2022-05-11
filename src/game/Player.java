package game;

public abstract class Player {

	protected String name;
	protected Pieces piece;
	protected boolean turn;
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

	public Player() {
	}

	// GETTERS AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pieces getPiece() {
		return piece;
	}
}