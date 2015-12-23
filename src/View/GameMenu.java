package View;

/**
 * Created by Razer on 18-12-2015.
 */
import Controller.Util;
import Model.Player;

import java.util.Scanner;

public class GameMenu  {

        private static Scanner scan;
        private static int mainMenu, newPlayerRace, newPlayerJob;
        private static String newPlayerName;
        private static boolean running;

        public static void menu(){

                running = true;
                Util.createPlayerFile();
                while(running){

                        System.out.println("Welcome to the world of JAVA");
                        System.out.println(" 1: Create new Player \n 2: View Player \n 3: Play the Game \n 4: Quit");
                        scan = new Scanner(System.in);
                        mainMenu = scan.nextInt();
                        switch(mainMenu) {
                                case 1:
                                        Player player = new Player("", 0, 0);
                                        scan = new Scanner(System.in);

                                        System.out.println("\nWhat is your name?");
                                        newPlayerName = scan.nextLine();
                                        player.setPlayerName(newPlayerName);

                                        System.out.println("\nWhat is your race?");
                                        System.out.println(" 1: Human race \n 2: Elvish race \n 3: Undead race");
                                        newPlayerRace = scan.nextInt()-1;
                                        player.setPlayerRace(newPlayerRace);

                                        System.out.println("\nWhat is your class?");
                                        System.out.println(" 1: Warrior \n 2: Ranger \n 3: Wizard");
                                        newPlayerJob = scan.nextInt()-1;
                                        player.setPlayerJob(newPlayerJob);

                                        Util.savePlayer(player);
                                        break;
                                case 2:
                                        Util.loadPlayer();
                                        Util.viewPlayer();
                                        System.out.println();
                                        break;
                                case 3:
                                        player = Util.loadPlayer();
                                        System.out.println(player.getPlayerJob());
                                        Game.Adventure();
                                        break;
                                case 4:
                                        running = false;
                                        break;
                        }
                }

        }
}
