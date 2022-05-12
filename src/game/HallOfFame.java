package game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Class for reading and writting to files.
 * 
 * @author jmpfbmx
 *
 * @version 1.0
 * 
 * @since 1.0
 */
public class HallOfFame {

	/**
	 * Method for reading and writting to a file whose where the guys that win.
	 * 
	 * @param playerList (ArrayList of the players)
	 * @param playerTurn (Needed for writting to the file who won if was player 1/2)
	 */
	public void hallOfFame(List<Player> playerList, int playerTurn, boolean deadHeat) {
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
			if (!deadHeat) {
				myWriter.write(Play.showResult(playerTurn, deadHeat));
				myWriter.newLine();
				myWriter.close();
				System.out.println("\nInformation has been successfully written to the file.\n");
			}
		} catch (IOException e) {
			System.out.println("\nFile couldn't be written!\n");
			e.printStackTrace();
		}
	}
}
