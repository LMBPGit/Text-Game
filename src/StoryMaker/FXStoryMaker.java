package StoryMaker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXStoryMaker extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        TextArea storyStringField = new TextArea();
        Button storybtn = new Button("save Story");
        TextField storyNumber = new TextField();
        Button storyNumberbtn = new Button("save StoryNumber");
        TextField choice1 = new TextField();
        Button choice1btn = new Button("save choice 1");
        TextField choice2 = new TextField();
        Button choice2btn = new Button("save choice 2");
        TextField choice3 = new TextField();
        Button choice3btn = new Button("save choice 3");

        storyStringField.setPromptText("Set StoryString");
        storyNumber.setPromptText("Set StoryNumber");
        choice1.setPromptText("set Choice 1");
        choice2.setPromptText("set Choice 2");
        choice3.setPromptText("set Choice 3");

        HBox storyHBox = new HBox(storyStringField, storybtn);
        HBox storyNumberHBox = new HBox(storyNumber, storyNumberbtn);
        HBox choice1HBox = new HBox(choice1, choice1btn);
        HBox choice2HBox = new HBox(choice2, choice2btn);
        HBox choice3HBox = new HBox(choice3, choice3btn);

        VBox vBox = new VBox(storyHBox, storyNumberHBox, choice1HBox, choice2HBox, choice3HBox);

        Scene mainScene = new Scene(vBox);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
