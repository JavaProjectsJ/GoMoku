package game;

/**
 * Abstract class used for creating the players.
 * 
 * @author jmpfbmx
 * @version 1.0
 * @since 1.0
 */
public abstract class Player {
	/**
	 * Attribute for storing the name
	 */
	protected String name;
	/**
	 * Attribute of type piece
	 * 
	 * @see Pieces
	 */
	protected Pieces piece;
	/**
	 * Attribute for setting who will start
	 */
	protected boolean turn;
	/**
	 * Attribute for setting the piece number if 1 is CROSS if 2 is CIRCLE
	 */
	private static int n = 0;

	/**
	 * Player constructor for creating the objects
	 * 
	 * @param name
	 * @param turn
	 */
	public Player(String name, boolean turn) {
		this.name = name;
		this.turn = turn;
		setPiece(++n);
	}

	/**
	 * Empty player constructor
	 */
	public Player() {
	}

	/**
	 * Set piece for the player
	 * 
	 * @param symbolPiece
	 */
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

	/**
	 * Abstract method that return the coordinates
	 * 
	 * @param board
	 * @return the coordinates
	 * @see Board
	 */
	public abstract int[] returnCoordinates(Board board);

	/**
	 * Get the name of the player
	 * 
	 * @return player name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the player
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the piece of the player
	 * 
	 * @return the piece of the player.
	 */
	public Pieces getPiece() {
		return piece;
	}
}