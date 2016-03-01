package Model;

public class StoryModel {

    private String storyString;
    private int choiceLineNumber;
    private String choiceString;

    public StoryModel(String storyString, int choiceLineNumber, String choiceString){
        this.storyString = storyString;
        this.choiceLineNumber = choiceLineNumber;
        this.choiceString = choiceString;
    }

    public String getStoryString() {
        return storyString;
    }

    public void setStoryString(String storyString) {
        this.storyString = storyString;
    }

    public int getChoiceLineNumber() {
        return choiceLineNumber;
    }

    public void setChoiceLineNumber(int choiceLineNumber) {
        this.choiceLineNumber = choiceLineNumber;
    }

    public String getChoiceString() {
        return choiceString;
    }

    public void setChoiceString(String choiceString) {
        this.choiceString = choiceString;
    }

    @Override
    public String toString() {
        return "StoryModel{" +
                "storyString='" + storyString + '\'' +
                ", choiceLineNumber=" + choiceLineNumber +
                ", choiceString='" + choiceString + '\'' +
                '}';
    }
}
