package com.example.snakeladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {
    public static final int tileSize=40, width=10,height=10;
    public static final int buttonLine = height*tileSize+50,infoLine=buttonLine-30;
    private static Dice dice =new Dice();
        private Player playerOne, playerTwo;
        private boolean gameStarted=false,playerOneTurn=false,playerTwoTurn=false;
       private Pane createContent(){
        Pane root=new Pane();
       root.setPrefSize( width*tileSize,height*tileSize + 100);
       for (int i=0; i<height;i++){
           for(int j=0; j<width;j++){
               Tile tile = new Tile(tileSize);
               tile.setTranslateX(j*tileSize);
               tile.setTranslateY(i*tileSize);
               root.getChildren().add(tile);
           }
       }
           Image img = new Image("C:\\Users\\dell\\IdeaProjects\\SnakeLadder\\src\\main\\img.png");
           ImageView board=new ImageView();
           board.setImage(img);
           board.setFitHeight(height*tileSize);

           board.setFitWidth(width*tileSize);

           //Button
           Button playerOneButton = new Button("Player one");
           Button playerTwoButton = new Button("Player Two");
           Button StartButton=new Button("Start");
           playerOneButton.setTranslateY(buttonLine);
           playerOneButton.setTranslateX(20);
           playerOneButton.setDisable(true);
           playerTwoButton.setTranslateY(buttonLine);
           playerTwoButton.setTranslateX(300);
           playerTwoButton.setDisable(true);
           StartButton.setTranslateY(buttonLine);
           StartButton.setTranslateX(160);
           // info display
           Label playeroneLable = new Label("");
           Label playerTwoLable = new Label("");
           Label DiceLable = new Label("Start the Game");

           playeroneLable.setTranslateY(infoLine);
           playeroneLable.setTranslateX(20);

           playerTwoLable.setTranslateY(infoLine);
           playerTwoLable.setTranslateX(300);

           DiceLable.setTranslateY(infoLine);
           DiceLable.setTranslateX(160);

           playerOne=new Player(tileSize, Color.BLACK,"Amit");
           playerTwo=new Player(tileSize-5,Color.WHITE,"Sumit");
           //Player action
           playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent actionEvent) {
                   if(gameStarted){
                       if(playerOneTurn){
                           int diceValue =dice.getRolledDiceValu();
                           DiceLable.setText("Dice Value: " + diceValue);
                           playerOne.movePlayer(diceValue);
                           // WINNING CODNT.
                           if(playerOne.isWinner()){
                               DiceLable.setText("Winner is"+ playerOne.getName());
                               playerOneTurn=false;
                               playerOneButton.setDisable(true);
                               playeroneLable.setText("");
                               playerTwoTurn=true;
                               playerTwoButton.setDisable(true);
                               playerTwoLable.setText("");

                               StartButton.setDisable(false);
                               StartButton.setText("Restart");
                               gameStarted=false;

                           }
                           else{
                               playerOneTurn=false;
                               playerOneButton.setDisable(true);
                               playeroneLable.setText("");

                               playerTwoTurn=true;
                               playerTwoButton.setDisable(false);
                               playerTwoLable.setText("Your Turn "+ playerTwo.getName());

                           }

                       }
                   }

               }
           });
           playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent actionEvent) {
                   if(gameStarted){
                       if(playerTwoTurn){
                           int diceValue =dice.getRolledDiceValu();
                           DiceLable.setText("Dice Value: " + diceValue);
                           playerTwo.movePlayer(diceValue);
                           // WINNING CODNT.
                           if(playerTwo.isWinner()){
                               DiceLable.setText("Winner is"+ playerTwo.getName());
                               playerOneTurn=false;
                               playerOneButton.setDisable(true);
                               playeroneLable.setText("");
                               playerTwoTurn=true;
                               playerTwoButton.setDisable(true);
                               playerTwoLable.setText("");

                               StartButton.setDisable(false);
                               StartButton.setText("Restart");

                           }
                           else{
                               playerOneTurn=true;
                               playerOneButton.setDisable(false);
                               playeroneLable.setText("Your Turn "+ playerOne.getName());
                               playerTwoTurn=false;
                               playerTwoButton.setDisable(true);
                               playerTwoLable.setText("");
                           }
                       }
                   }

               }
           });

           StartButton.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent actionEvent) {
                   gameStarted = true;
                   DiceLable.setText("Game Started");
                   StartButton.setDisable(true);
                   playerOneTurn=true;
                   playeroneLable.setText("Your Turn " + playerOne.getName());
                   playerOneButton.setDisable(false);
                   playerOne.startingPosition();

                   playerTwoTurn=false;
                   playerTwoLable.setText("");
                   playerTwoButton.setDisable(true);
                   playerTwo.startingPosition();
               }
           });

           root.getChildren().addAll(board, playerOneButton, playerTwoButton, StartButton,
                   playeroneLable,playerTwoLable,DiceLable,playerOne.getCoin(),playerTwo.getCoin()
           );



        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createContent());
        stage.setTitle("SnakeLadder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}