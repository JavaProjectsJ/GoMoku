package game;

public enum Pieces {
	CIRCLE("O"), CROSS("X"), BLANK("·"), OUT("");

	private final String description;

	private Pieces(String str) {
		description = str;
	}

	public String getPieces() {
		return description;
	}
}