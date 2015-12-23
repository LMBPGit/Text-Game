package Controller;

import Model.Player;

/**
 * Created by Razer on 23-12-2015.
 */
public class Events {

    private static boolean playerClear;
    private static Player player;

    public static boolean isClassRanger(){
        player = Util.loadPlayer();
        playerClear = false;

        if(player.getPlayerJob().equals("Ranger")){
            playerClear = true;
        }

        return playerClear;
    }

}
