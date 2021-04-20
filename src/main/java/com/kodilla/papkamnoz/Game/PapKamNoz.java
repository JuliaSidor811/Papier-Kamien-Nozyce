package com.kodilla.papkamnoz.Game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.ietf.jgss.GSSContext;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PapKamNoz extends Application {

    private Button rock, paper, scissors, mychoice, compchoice, restart;
    private Text scoreText;
    private int myCount = 0;
    private int comCount = 0;
    private int userNumSelection;
    private int comNumSelection;


    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane pane = new BorderPane();
        HBox mainPane = new HBox();
        HBox choicePane = new HBox();
        VBox scorePane = new VBox();

        // mainPane
        mychoice = new Button();
        compchoice = new Button();
        List<Button> mainPaneButtons = new ArrayList<>();
        mainPaneButtons.add(mychoice);
        mainPaneButtons.add(compchoice);

        for (Button button : mainPaneButtons) {
            button.setMinSize(250, 250);
            button.setStyle("-fx-background-color: black");
        }
        mainPane.getChildren().addAll(mainPaneButtons);
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setSpacing(40);
        mainPane.setPadding(new Insets(20, 20, 20, 20));


        // przyciski wyboru ruchu

        rock = new Button();
        rock.setStyle("-fx-background-image: url('https://www.mcgill.ca/oss/files/oss/styles/hd/public/pebble-3215317_1920_1.jpeg?itok=dJy0SPKE&timestamp=1601650822')");
        paper = new Button();
        paper.setStyle("-fx-background-image: url('https://thumbs.dreamstime.com/b/crushed-white-paper-texture-as-background-36495349.jpg')");
        scissors = new Button();
        scissors.setStyle("-fx-background-image: url('https://www.thoughtco.com/thmb/8_uEQD_VvWpAHUfN2QY2SCEeC9M=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/TasselScissorCharm1-57bb74b63df78c87631fc3a5.jpg')");

        List<Button> choiceList = new ArrayList<>();
        choiceList.add(rock);
        choiceList.add(paper);
        choiceList.add(scissors);

        for (Button button : choiceList) {
            button.setMinSize(180, 180);
        }
        choicePane.getChildren().addAll(choiceList);
        choicePane.setAlignment(Pos.CENTER);
        choicePane.setSpacing(50);
        choicePane.setPadding(new Insets(15, 15, 15, 15));

        //Wyniki
        scoreText = new Text();
        scoreText.setText("0 : 0");
        scoreText.setStyle("-fx-font-size: 50");
        restart = new Button("Restart");
        restart.setMinSize(20,20);
        restart.setStyle("-fx-border-color: deeppink");
        scorePane.getChildren().addAll(restart,scoreText);
        scorePane.setAlignment(Pos.CENTER);
        scorePane.setPadding(new Insets(20,20,20,20));


        pane.setTop(scorePane);
        pane.setCenter(mainPane);
        pane.setBottom(choicePane);

        rock.setOnAction(event ->
        {
            userNumSelection = 1;
            mychoice.setStyle("-fx-background-image: url('https://www.mcgill.ca/oss/files/oss/styles/hd/public/pebble-3215317_1920_1.jpeg?itok=dJy0SPKE&timestamp=1601650822')");
            game();
            userNumSelection = 0;
        });
        paper.setOnAction(event -> {
            userNumSelection = 2;
            mychoice.setStyle("-fx-background-image: url('https://thumbs.dreamstime.com/b/crushed-white-paper-texture-as-background-36495349.jpg')");
            game();
            userNumSelection = 0;

        });
        scissors.setOnAction(event -> {
            userNumSelection = 3;
            mychoice.setStyle("-fx-background-image: url('https://www.thoughtco.com/thmb/8_uEQD_VvWpAHUfN2QY2SCEeC9M=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/TasselScissorCharm1-57bb74b63df78c87631fc3a5.jpg')");
            game();
            userNumSelection = 0;

        });

        restart.setOnAction(event ->{
            scoreText.setText("0 : 0");
            myCount = 0;
            comCount = 0;
        });


        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Rock Paper Scissors");
        primaryStage.show();


    }


    public void displayComChoice() {

        Random random = new Random();
        comNumSelection = random.nextInt(3) + 1;

        int choice = comNumSelection;
        if (choice == 1) {
            compchoice.setStyle("-fx-background-image: url('https://www.mcgill.ca/oss/files/oss/styles/hd/public/pebble-3215317_1920_1.jpeg?itok=dJy0SPKE&timestamp=1601650822')");
        } else if (choice == 2) {
            compchoice.setStyle("-fx-background-image: url('https://thumbs.dreamstime.com/b/crushed-white-paper-texture-as-background-36495349.jpg')");
        } else {
            compchoice.setStyle("-fx-background-image: url('https://www.thoughtco.com/thmb/8_uEQD_VvWpAHUfN2QY2SCEeC9M=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/TasselScissorCharm1-57bb74b63df78c87631fc3a5.jpg')");

        }
    }
    public void game(){
        displayComChoice();
        if((userNumSelection == 1 && comNumSelection == 3) || (userNumSelection == 2 && comNumSelection == 1) || (userNumSelection == 3 && comNumSelection == 2)){
            myCount +=1;
            displayScore();
        }else if((userNumSelection == 1 && comNumSelection == 2 ) || (userNumSelection == 2 && comNumSelection == 3) || (userNumSelection == 3 && comNumSelection == 1)){
            comCount += 1;
            displayScore();
        }else{
            displayScore();
        }
    }

    public void displayScore() {
        scoreText.setText(myCount + " : " + comCount);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
