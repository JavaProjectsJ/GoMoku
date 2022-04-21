package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    //TODO: Variables de la clase Game
    // Un marcador
    // Un tablero
    // Lista de jugadores
    // Estado del juego

    List<Player> playerList = new ArrayList<>();
    Player bot1;
	Player bot2;
	Player human1;
	Player human2;
    KeyboardGame keyboardGame = new KeyboardGame();
    boolean status = true;

    public Game(int option) {
        players(option);
    }

    //GETTERS AND SETTERS
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @SuppressWarnings({ "unused", "resource" })
    public List<Player> players(int option) {
        boolean exit = false;
        boolean random = false;
        Scanner keyboard = new Scanner(System.in);
        String name = "";
        String player1_name = "";
        String player2_name = "";
        int randomPiece = (int) (Math.random() * (2 - 1 + 1) + 1);
        System.out.println("\nWould you like to randomize who will start?");
        if (keyboardGame.readChar('y')) {
            random = true;
        } else {
            random = false;
        }
        do {
            System.out.println();
            switch (option) {
                case 1:
                    if (random) {
                        if(randomPiece==1){
                            bot1 = new Bot(name, 1, true);
                            bot2 = new Bot(name, 2, false);
                            playerList = Arrays.asList(bot1, bot2);
                        } else {
                            bot2 = new Bot(name, 1, true);
                            bot1 = new Bot(name, 2, false);
                            playerList = Arrays.asList(bot2, bot1);
                        }
                    } else {
                        bot1 = new Bot(name, 1, true);
                        bot2 = new Bot(name, 2, false);
                        playerList = Arrays.asList(bot1, bot2);
                    }
                    exit = true;
                    break;
                case 2:
                    System.out.println("Which is your name player 1?");
                    player1_name = keyboard.nextLine();
                    if (random) {
                        if(randomPiece==1){
                            human1 = new Human(player1_name, 1, true);
                            bot1 = new Bot(name, 2, false);
                            playerList = Arrays.asList(human1, bot1);
                        } else {
                            bot1 = new Bot(name, 1, true);
                            human1 = new Human(player1_name, 2, false);
                            playerList = Arrays.asList(bot1, human1);
                        }
                    } else {
                        human1 = new Human(player1_name, 1, true);
                        bot1 = new Bot(name, 2, false);
                        playerList = Arrays.asList(human1, bot1);
                    }

                    exit = true;
                    break;
                case 3:
                    System.out.println("Which is your name player 1?");
                    player1_name = keyboard.nextLine();
                    System.out.println("\nWhich is your name player 2?");
                    player2_name = keyboard.nextLine();
                    if (random) {
                        if(randomPiece==1){
                            human1 = new Human(player1_name, 1, true);
                            human2 = new Human(player2_name, 2, false);
                            playerList = Arrays.asList(human1, human2);
                        } else {
                            human2 = new Human(player2_name, 1, true);
                            human1 = new Human(player1_name, 2, false);
                            playerList = Arrays.asList(human2, human1);
                        }
                    } else {
                        human1 = new Human(player1_name, 1, true);
                        human2 = new Human(player2_name, 2, false);
                        playerList = Arrays.asList(human1, human2);
                    }
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option\nTry it again!\n");
                    exit = false;
                    break;
            }
        } while (!exit);
        return playerList;
    }
}
