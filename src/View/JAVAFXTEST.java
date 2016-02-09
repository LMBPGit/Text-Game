package View;

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
    private static String userInput, currentStoryName, nextStory;
    private static boolean running;

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("JavaFX Welcome");
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));

            currentStoryName = "1";
            running = true;
                Text scenetitle = new Text(Util.storyString(currentStoryName));
                scenetitle.setFont(Font.font("times new roman", FontWeight.NORMAL, 14));
                grid.add(scenetitle, 0, 0, 2, 1);

                Circle circle = new Circle();
                circle.setRadius(40);
                circle.setFill(Color.DEEPPINK);
                grid.add(circle, 0,0);


                Button btn1 = new Button("Sign in");
                HBox hbBtn1 = new HBox(10);
                hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
                hbBtn1.getChildren().add(btn1);
                grid.add(hbBtn1, 1, 4);


                Text actiontarget = new Text();
                grid.add(actiontarget, 1, 6);

                btn1.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        userInput = "1";
                        actiontarget.setFont(Font.font("times new roman"));
                        actiontarget.setFill(Color.DARKBLUE);
                        actiontarget.setText("HEYOOOO YO");
                        if (userInput.equals("1")) {
                            System.out.println("hi");

                        }
                        currentStoryName = Util.newStoryString(userInput, currentStoryName);

                    }
                });




                Scene scene = new Scene(grid, 600, 600);
                primaryStage.setScene(scene);
                primaryStage.show();
            }

    public static void main(String[] args) {
        launch(args);
    }
}
