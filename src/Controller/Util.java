package Controller;

import Model.Player;
import java.io.*;

/**
 * Created by Razer on 18-12-2015.
 */
public class Util {

    private static File playerFile, file;
    private static File playerDir = new File("PlayerFiles");
    private static ObjectInputStream objin = null;
    private static Player returnPlayer;
    private static String nextStory;
    private static String currentStory = "1";

    public static void savePlayer(Player player){
        ObjectOutputStream objout = null;
        try{
            objout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(playerFile)));
            objout.writeObject(player);

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(objout != null){
                    objout.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    public static File createPlayerFile(){
        try {
            playerFile = new File(System.getProperty("user.dir") + "/PlayerFiles/" + ".txt"); //creates player file, can it run on android?
            playerFile.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            return playerFile;
        }
    }

    public static Player loadPlayer(){
        Player returnPlayer = null;
        try{
            if(playerFile.length() !=0) {
                objin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(playerFile)));
                returnPlayer = (Player) objin.readObject();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();

        }catch(IOException e){
            e.printStackTrace();

        }catch(ClassNotFoundException e) {
            e.printStackTrace();

        }finally {
            try{
                if (objin != null){
                    objin.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return returnPlayer;
    }

    public static Boolean viewPlayer(){
        Boolean playerExist = false;
        try{
            Player tempPlayer = loadPlayer();
            System.out.println("Name: " + tempPlayer.getPlayerName());
            System.out.println("Race: " + tempPlayer.getPlayerRace());
            System.out.println("Class: " + tempPlayer.getPlayerJob());
        }catch (NullPointerException e){
            System.out.println("no player");
        }
        return playerExist;
    }

    public static String storyString(String currentStory){

        try {

                File file = new File("Stories/" + currentStory + ".txt");
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                StringBuffer stringBuffer = new StringBuffer();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    if(line.contains("stop")){
                        break;
                    }else {
                        stringBuffer.append(line);
                        stringBuffer.append("\n");
                    }
                }
                System.out.println(stringBuffer.toString());
                fileReader.close();

        } catch (IOException e){
            e.printStackTrace();
        }
        return currentStory;
    }

    public static String newStoryString(String userInput){

        try {

            File file = new File("Stories/" + currentStory + ".txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(userInput.equalsIgnoreCase("1")) {
                    if (line.contains("valgA")) {
                        stringBuffer.append(line);
                    }
                }
                if (userInput.equalsIgnoreCase("2")){
                    if (line.contains("valgB")) {
                        stringBuffer.append(line);
                    }
                }
            }

            fileReader.close();
            nextStory = stringBuffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return nextStory;
    }


    public enum playerRaces {
        HUMAN("Human race"),
        Elf("Elvish race"),
        Undead("Undead race");

        public String chosenPlayerRace;

        public String getPlayerRaceFromEnum(){
            return chosenPlayerRace;
        }
        playerRaces(String chosenPlayerRace){
            this.chosenPlayerRace = chosenPlayerRace;
        }
    }

    public enum playerJobs {
        WARRIOR("Warrior"),
        RANGER("Ranger"),
        WIZARD("Wizard");

        public String chosenPlayerJob;

        public String getPlayerJobFromEnum(){
            return chosenPlayerJob;
        }
        playerJobs(String chosenPlayerJob){
            this.chosenPlayerJob = chosenPlayerJob;
        }
    }

}
