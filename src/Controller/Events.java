package Controller;

import Model.Player;
import View.Game;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Razer on 23-12-2015.
 */
public class Events {

    private static boolean eventCleared, playerClear;
    private static Player player;
    private static int diceRollClear, diceResult, beginDiceRead, endDiceRead;
    private static String diceRollClearString;

    public static boolean selectEvent(String nextStory){

        if(nextStory.contains("JobEvent")){

            eventCleared = isJobTrue(nextStory);
            if(!eventCleared){ //!eventCleared is the same as eventCleared == false (obs. REMEMBER TO USE DOUBLE EQUAL IN CHECKS)
                System.out.println("You're not the appropriate class to do this\n");
            }
        }

        if(nextStory.contains("DiceEvent")){
            eventCleared = diceThrowClear(nextStory);
        }
        return eventCleared;
    }

    public static boolean isJobTrue(String nextStory){
        player = Util.loadPlayer();
        playerClear = false;

        if(nextStory.contains("RangerJob")) {

            if (player.getPlayerJob().equals("Ranger")) {
                playerClear = true;
            }

        } else if(nextStory.contains("WarriorJob")) {

            if (player.getPlayerJob().equals("Warrior")) {
                playerClear = true;
            }

        } else if(nextStory.contains("MageJob")) {

            if (player.getPlayerJob().equals("Mage")) {
                playerClear = true;
            }
        }
        return playerClear;
    }

    public static boolean diceThrowClear(String nextStory){

        try{
            beginDiceRead = nextStory.indexOf("DiceEvent") + 9;
            endDiceRead = beginDiceRead + 1;

            diceRollClearString = nextStory.substring(beginDiceRead, endDiceRead);

            diceRollClear = Integer.parseInt(diceRollClearString);


        }catch(NullPointerException e){
            e.printStackTrace();
        }

        Random diceRoll = new Random();

        diceResult = diceRoll.nextInt(11);

        System.out.println("You rolled: " + diceResult);

        if (diceResult >= diceRollClear){

            eventCleared = true;
        }else{
            deathEvent();
        }

    return eventCleared;
    }

    public static void deathEvent(){

        System.out.println("\nYou Died\n");
        Game.runningGame = false;

    }

}
