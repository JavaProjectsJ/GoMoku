package game;

import java.util.HashMap;
import java.util.Map;

public class Human extends Player {
	KeyboardGame keyboard = new KeyboardGame();

	public Human(String name, boolean turn) {
		super(name, turn);
	}

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
