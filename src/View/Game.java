package View;

import Controller.Util;
import java.util.Scanner;

/**
 * Created by Razer on 20-12-2015.
 */
public class Game {

    private static Scanner scan;
    //private static int AAAA, AAAB, AAAC, AAAD, AAAE, AAAF, AAAG; also not used yet
    private static boolean running, firstRun;
    private static String currentStory, nextStory, userInput;


    public static void Adventure() {

        running = true;
        firstRun = true;
        currentStory = "1";

        while (running) {

            if(Util.storyString(currentStory).equals("DEATH")){
                running = false;
                System.out.println("press any key to continue");
            }
            scan = new Scanner(System.in);
            userInput = scan.nextLine();

            nextStory = Util.newStoryString(userInput, currentStory);
            currentStory = nextStory;
        }
    }
}
// Not used yet
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
