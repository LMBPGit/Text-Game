package Model;

import Controller.Util;

import java.io.Serializable;

/**
 * Created by Razer on 18-12-2015.
 */
public class Player implements Serializable{

    private String playerName;
    private String playerRace; //Calls an enum
    private String playerJob;  //Calls an enum

    public Player(String playerName, int playerRace, int playerJob){
        this.playerName = playerName;
        setPlayerRace(playerRace);
        setPlayerJob(playerJob);
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void setPlayerRace(int race){
        playerRace = Util.playerRaces.values()[race].getPlayerRaceFromEnum();
    }

    public String getPlayerRace(){
        return playerRace;
    }

    public void setPlayerJob(int job){
        playerJob = Util.playerJobs.values()[job].getPlayerJobFromEnum();
    }

    public String getPlayerJob(){
        return playerJob;
    }

}
