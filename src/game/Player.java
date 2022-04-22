package game;

import java.util.ArrayList;

public abstract class Player {

	protected String name;
	protected int score;
	protected ArrayList<String> piece;
	public int symbolPiece;
	public boolean turn;

	public int getSymbolPiece() {
		return symbolPiece;
	}

	public void setSymbolPiece(int symbolPiece) {
		this.symbolPiece = symbolPiece;
	}

	public Player(String name, int symbolPiece) {
		this.name = name;
		this.symbolPiece = symbolPiece;
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

	public ArrayList<String> getPiece() {
		return piece;
	}

	public void setPiece(ArrayList<String> piece) {
		this.piece = piece;
	}

	public boolean getTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

}