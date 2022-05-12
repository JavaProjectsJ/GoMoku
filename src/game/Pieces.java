package game;

/**
 * Enum that contains the pieces that will be set to the players
 * 
 * @author jmpfbmx
 * @version 1.0
 * @since 1.0
 */
public enum Pieces {
	/**
	 * Circle piece
	 */
	CIRCLE("O"),
	/**
	 * Cross piece
	 */
	CROSS("X"),
	/**
	 * Blank
	 */
	BLANK("·");

	/**
	 * Description for saving the piece
	 */
	private final String description;

	private Pieces(String str) {
		description = str;
	}

	/**
	 * Method for getting the piece
	 * 
	 * @return the description
	 */
	public String getPieces() {
		return description;
	}
}