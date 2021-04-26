package com.kodilla.papkamnoz.Game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PapKamNoz extends Application {

    private Button rock, paper, scissors, mychoice, compchoice, restart, stopGame;
    private Text scoreText, resultText, movesText, endGameText;
    private int myCount = 0;
    private int comCount = 0;
    private int movesCount= 0;
    private int userNumSelection;
    private int comNumSelection;
    private String result;


    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane pane = new BorderPane();
        HBox mainPane = new HBox();
        HBox choicePane = new HBox();
        VBox scorePane = new VBox();
        HBox textPane = new HBox();
        VBox centerPane = new VBox();
        HBox buttonPane = new HBox();
        VBox bottomPane = new VBox();
        VBox topPane = new VBox();


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

        //Licznik wyniku
        scoreText = new Text();
        scoreText.setText("0 : 0");
        scoreText.setStyle("-fx-font-size: 50");

        movesText = new Text();
        movesText.setFont(Font.font("Verdena",15));

        scorePane.getChildren().addAll(scoreText, movesText);
        scorePane.setAlignment(Pos.CENTER);
        scorePane.setPadding(new Insets(12,12,12,12));



        //Top Pane
        endGameText = new Text();
        endGameText.setFont(Font.font("Verdena",30));
        endGameText.setFill(Color.DEEPPINK);

        topPane.getChildren().addAll(endGameText,scorePane);
        topPane.setAlignment(Pos.CENTER);
        topPane.setPadding(new Insets(20,30,8,30));



        //Wynik tekst
        resultText = new Text();
        resultText.setStyle("-fx-font-style: italic");
        resultText.setFont(Font.font("Verdana",25));
        textPane.getChildren().add(resultText);
        textPane.setAlignment(Pos.CENTER);
        textPane.setPadding(new Insets(10,10,10,10));
        centerPane.getChildren().addAll(mainPane,textPane);

        //BottomPane
        restart = new Button("Restart");
        restart.setMinSize(20,20);
        restart.setStyle("-fx-border-color: deeppink");
        restart.setFont(Font.font("Verdena", 15));

        stopGame = new Button("Stop Game");
        stopGame.setMinSize(20,20);
        stopGame.setStyle("-fx-border-color: deeppink");
        stopGame.setFont(Font.font("Verdena", 15));

        buttonPane.getChildren().addAll(restart, stopGame);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setSpacing(25);
        buttonPane.setPadding(new Insets(10,10,10,10));

        bottomPane.getChildren().addAll(choicePane,buttonPane);


        pane.setTop(topPane);
        pane.setCenter(centerPane);
        pane.setBottom(bottomPane);





        rock.setOnAction(event ->
        {
            userNumSelection = 1;
            mychoice.setStyle("-fx-background-image: url('https://www.mcgill.ca/oss/files/oss/styles/hd/public/pebble-3215317_1920_1.jpeg?itok=dJy0SPKE&timestamp=1601650822')");
            movesCount += 1;
            game();
            userNumSelection = 0;
        });
        paper.setOnAction(event -> {
            userNumSelection = 2;
            movesCount += 1;
            mychoice.setStyle("-fx-background-image: url('https://thumbs.dreamstime.com/b/crushed-white-paper-texture-as-background-36495349.jpg')");
            game();
            userNumSelection = 0;

        });
        scissors.setOnAction(event -> {
            userNumSelection = 3;
            movesCount += 1;
            mychoice.setStyle("-fx-background-image: url('https://www.thoughtco.com/thmb/8_uEQD_VvWpAHUfN2QY2SCEeC9M=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/TasselScissorCharm1-57bb74b63df78c87631fc3a5.jpg')");
            game();
            userNumSelection = 0;

        });

        restart.setOnAction(event ->{
            scoreText.setText("0 : 0");
            resultText.setText("");
            movesText.setText("");
            endGameText.setText("");
            movesCount = 0;
            myCount = 0;
            comCount = 0;
            mychoice.setStyle("-fx-background-color: black");
            compchoice.setStyle("-fx-background-color: black");
            rock.setDisable(false);
            scissors.setDisable(false);
            paper.setDisable(false);
        });
        stopGame.setOnAction(event -> {
            displayGameEndResult();
            rock.setDisable(true);
            scissors.setDisable(true);
            paper.setDisable(true);

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
            displayMovesCount();
            result = "You win!";
            displayResult();
        }else if((userNumSelection == 1 && comNumSelection == 2 ) || (userNumSelection == 2 && comNumSelection == 3) || (userNumSelection == 3 && comNumSelection == 1)){
            comCount += 1;
            displayScore();
            displayMovesCount();
            result = "Computer wins!";
            displayResult();
        }else{
            displayScore();
            displayMovesCount();
            result = "A tie!";
            displayResult();

        }
    }

    public void displayScore() {
        scoreText.setText(myCount + " : " + comCount);
    }
    public void displayResult(){
        resultText.setText(result);
    }
    public void displayMovesCount(){
        movesText.setText("Moves Count: "+ movesCount);
    }
    public void displayGameEndResult(){
        if(myCount > comCount){
            endGameText.setText("Congratulations! You win whole game!");
        }
        else if(comCount > myCount){
            endGameText.setText("Sadly, Computer wins. Good luck next time!");
        } else{
            endGameText.setText("Nobody wins!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
