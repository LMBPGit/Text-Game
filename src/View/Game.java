package View;

import Controller.Util;
import java.util.Scanner;

/**
 * Created by Razer on 20-12-2015.
 */
public class Game {

    private static Scanner scan;
    private static int AAAA, AAAB, AAAC, AAAD, AAAE, AAAF, AAAG;
    private static boolean running;
    private static String userInput, chosenStory;

    public static void Adventure() {
        Util.storyString("1");

        running = true;
        while (running) {
            scan = new Scanner(System.in);
            userInput = scan.nextLine();
            Util.newStoryString(userInput);

            chosenStory = Util.newStoryString(userInput);
            Util.storyString(chosenStory);
        }
    }
}
        /*AAAA = scan.nextInt();
        switch (AAAA) {
            case 1:
                Util.storyString("2");
                AAAB = scan.nextInt();

            switch (AAAB) {
                case 1:
                    Util.storyString("3");
                    break;
                case 2:
                    Util.storyString("5");
                    break;
            }
                break;
            case 2:

        }
    }*/
