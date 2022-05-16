package game;

public class Human extends Player {
	KeyboardGame keyboardGame = new KeyboardGame();

	public Human(String name, boolean turn) {
		super(name, turn);
	}

	@Override
	public int[] returnCoordinates(Board board) {
		keyboardGame.keyboard.reset();
		String coordinates = keyboardGame.keyboard.nextLine();
		String[] coordinates_split = coordinates.split(",");
		int[] positions = new int[2];
		positions[0] = Integer.parseInt(coordinates_split[0]) - 1;
		positions[1] = Integer.parseInt(coordinates_split[1]) - 1;
		keyboardGame.keyboard.reset();
		return positions;
	}

}
