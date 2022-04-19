package game;

import java.util.Random;

public enum Database {
	// Create the 100 name of supercomputers for the players
	NAME(new String[] { "MareNostrum", "AlphaGo", "DeepMind", "AlphaZero", "AlphaStar", "Watson", "DeepThought",
			"Fugaku", "Summit", "Sierra", "Sunway Taihu", "Perimutter", "Selene", "Voyager-EUS2", "HPC5", "Juwels",
			"CEA-HF", "Frontera", "Polaris", "ABCI2.0", "Chervonenkis", "Piz Daint", "Trinity", "ARCHER 2", "Hawk",
			"Lassen", "Guru", "Maru", "PANGEA III", "HiperGator AI", "Cactus" });

	private String[] name;

	private Database(String[] str) {
		this.name = str;
	}

	public static String nmb() {
		return NAME.name[new Random().nextInt(NAME.name.length)];
	}
}