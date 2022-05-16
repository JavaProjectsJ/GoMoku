package game;

import java.util.Random;

/**
 * Enum used for store and set the names to the Bot.
 * 
 * @author jmpfbmx
 * 
 * @version 1.0
 * 
 * @since 1.0
 */
public enum Database {
	/**
	 * Enum that stores the random names that can be set to the BOT.
	 */
	NAME(new String[] { "MareNostrum", "AlphaGo", "DeepMind", "AlphaZero", "AlphaStar", "Watson", "DeepThought",
			"Fugaku", "Summit", "Sierra", "Sunway Taihu", "Perimutter", "Selene", "Voyager-EUS2", "HPC5", "Juwels",
			"CEA-HF", "Frontera", "Polaris", "ABCI2.0", "Chervonenkis", "Piz Daint", "Trinity", "ARCHER 2", "Hawk",
			"Lassen", "Guru", "Maru", "PANGEA III", "HiperGator AI", "Cactus" });

	/**
	 * Here we will save the name of the bot
	 */
	private String[] name;

	private Database(String[] str) {
		this.name = str;
	}

	/**
	 * Method for getting a random name
	 * 
	 * @return a name
	 */
	public static String nmb() {
		return NAME.name[new Random().nextInt(NAME.name.length)];
	}
}