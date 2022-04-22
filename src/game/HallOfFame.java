package game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HallOfFame {
	List<Player> playerList = new ArrayList<>();

	public void hallOfFame(Game game) {
		File myObj = new File("HOF.txt");
		try {
			if (!myObj.exists()) {
				System.out.println("File created: " + myObj.getName());
				myObj.createNewFile();
			}

			/*
			 * Let's read the file
			 */
			System.out.println("\nHOF formers:\n");
			Scanner fReader = new Scanner(myObj);
			while (fReader.hasNextLine()) {
				String data = fReader.nextLine();
				System.out.println(" - " + data);
			}
			fReader.close();
			/*
			 * Let's write the file
			 * First value specify the file that is going to be written
			 * Second value specify that I want to leave the info that already contains
			 */
			FileWriter fWritter = new FileWriter(myObj, true);
			BufferedWriter myWriter = new BufferedWriter(fWritter);
			myWriter.write(game.playerList.get(0).getName());
			myWriter.newLine();
			myWriter.write(game.playerList.get(1).getName());
			myWriter.newLine();
			myWriter.close();
			System.out.println("\nInformation has been successfully written to the file.");
		} catch (IOException e) {
			System.out.println("\nFile couldn't be written!");
			e.printStackTrace();
		}
	}
}
