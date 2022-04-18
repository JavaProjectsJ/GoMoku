package game;

import java.util.Random;

public enum Database {
	NAME(new String[] { "Kasparov", "S1mple", "TeNSe198_v2" });

	private String[] name;

	private Database(String[] str) {
		this.name = str;
	}

	public String nmb() {
		return NAME.name[new Random().nextInt(NAME.name.length)];
	}
}