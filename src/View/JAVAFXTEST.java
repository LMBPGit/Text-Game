package View;

import Model.StoryModel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Controller.Util;

import java.util.Scanner;


/**
 * Created by Razer on 14-01-2016.
 */
public class JAVAFXTEST extends Application {

    private static Scanner scan;
    private static String userInput, nextStory;
    private static String currentStoryName = "1";
    private static boolean running = true;

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("JavaFX Welcome");
            GridPane grid = new GridPane();

            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));

            BorderPane borderPane = new BorderPane();

            Text text = new Text(Util.storyString(currentStoryName));
            text.setFont(Font.font("times new roman", FontWeight.NORMAL, 14));
            grid.add(text, 0, 0, 4, 4);
            borderPane.setTop(text);

            Button btn1 = new Button("1");
            Button btn2 = new Button("2");
            Button btnQuit = new Button("quit");

            HBox hbBtn = new HBox(10);
            hbBtn.getChildren().addAll(btn1, btn2, btnQuit);
            borderPane.setCenter(hbBtn);
            //grid.add(hbBtn, 2, 4);

            btn1.setOnAction(event -> {
                currentStoryName = Util.newStoryString("1", currentStoryName);
                text.setText(Util.storyString(currentStoryName));
                //StoryModel storyModel = new StoryModel("", 1, "");
                //text.setText(storyModel.toString());
            });

            btn2.setOnAction(event -> {
                currentStoryName = Util.newStoryString("2", currentStoryName);
                text.setText(Util.storyString(currentStoryName));
            });

            btnQuit.setOnAction(event -> {
                //Util.saveGame(currentStoryName);
                primaryStage.close();
            });

            Scene scene = new Scene(borderPane, 600, 600);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

    public static void main(String[] args) {
        launch(args);
    }
}
