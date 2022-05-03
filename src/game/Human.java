package game;

public class Human extends Player {
	KeyboardGame keyboard = new KeyboardGame();

	public Human(String name, boolean turn) {
		super(name, turn);
	}

	@Override
	public int[] returnCoordinates(Board board) {
		String coordinates = keyboard.readString();
		String[] coordinates_split = coordinates.split(",");
		int[] positions = new int[2];
		positions[0] = Integer.parseInt(coordinates_split[0]) - 1;
		positions[1] = Integer.parseInt(coordinates_split[1]) - 1;
		return positions;
	}

}
