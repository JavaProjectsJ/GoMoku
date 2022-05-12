package game;

import java.util.HashMap;
import java.util.Map;

/**
 * Class used for creating the humans
 * 
 * @author jmpfbmx
 * @version 1.0
 * @since 1.0
 * @see Player
 */
public class Human extends Player {
	/**
	 * Create they keyboard
	 */
	KeyboardGame keyboard = new KeyboardGame();

	/**
	 * Constructor of the Human
	 * 
	 * @param name of the player
	 * @param turn of the player
	 */
	public Human(String name, boolean turn) {
		super(name, turn);
	}

	/**
	 * Method that return the coordinates of the piece that will be inserted
	 * 
	 * @param board
	 * @see Board
	 */
	@Override
	public int[] returnCoordinates(Board board) {
		String coordinates = keyboard.readString();
		String[] coordinates_split = coordinates.split(",");
		Map<String, Integer> alphabet = new HashMap<>();
		int[] positions = new int[2];
		for (int i = 0; i < 26; i++) {
			alphabet.put(String.valueOf((char) (i + 65)), i);
		}
		positions[0] = alphabet.get(coordinates_split[0]);
		positions[1] = Integer.parseInt(coordinates_split[1]) - 1;
		return positions;
	}

}
