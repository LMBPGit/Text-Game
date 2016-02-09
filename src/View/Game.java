package View;

import Controller.Events;
import Controller.Util;
import java.util.Scanner;

/**
 * Created by Razer on 20-12-2015.
 */
public class Game {

    private static Scanner scan;
    //private static int AAAA, AAAB, AAAC, AAAD, AAAE, AAAF, AAAG; also not used yet
    private static boolean eventCleared;
    public static boolean runningGame;
    private static String nextStory, userInput;
    public static String currentStoryName;


    public static void Adventure() {

        runningGame = true;

        while (runningGame) {

            Util.storyString(currentStoryName);

            scan = new Scanner(System.in);
            userInput = scan.nextLine();

            nextStory = Util.newStoryString(userInput, currentStoryName);

            if(nextStory.contains("Event")) {
                if (Events.selectEvent(nextStory)){
                    currentStoryName = nextStory;
                }
            }else{
                currentStoryName = nextStory;
                System.out.println(nextStory);
            }
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
