package Controller;

import Model.Player;

/**
 * Created by Razer on 23-12-2015.
 */
public class Events {

    private static boolean eventCleared, playerClear;
    private static Player player;

    public static boolean selectEvent(String nextStory){
        if(nextStory.contains("JobEvent")){
            eventCleared = isJobTrue(nextStory);
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
        }
        if(nextStory.contains("WarriorJob")) {

            if (player.getPlayerJob().equals("Warrior")) {
                playerClear = true;
            }
        }
        if(nextStory.contains("MageJob")) {

            if (player.getPlayerJob().equals("Mage")) {
                playerClear = true;
            }
        }
        return playerClear;
    }

}
