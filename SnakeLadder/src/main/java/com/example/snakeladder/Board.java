package com.example.snakeladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer,Integer>> positionCordinates;
    ArrayList<Integer>snakeLadderPosition;

    public Board(){
        positionCordinates=new ArrayList<>();
        populatePositionCoordintes();
        populateSnakeLadder();
    }
    private void populatePositionCoordintes(){
        positionCordinates.add(new Pair<>(0,0)); //make dummy value
        for (int i = 0; i < SnakeLadder.height; i++) {
            for (int j = 0; j <SnakeLadder.width ; j++) {
                // X-coordinate
                int xCord=0;
                if(i%2==0){
                    xCord=j*SnakeLadder.tileSize+SnakeLadder.tileSize/2;
                }
                else{
                    xCord=SnakeLadder.tileSize*SnakeLadder.height- (j*SnakeLadder.tileSize)-SnakeLadder.tileSize/2;
                }
                //Y-coordinate
                int yCord=SnakeLadder.tileSize*SnakeLadder.height- (i*SnakeLadder.tileSize)-SnakeLadder.tileSize/2;
                positionCordinates.add(new Pair<>(xCord,yCord));

            }

        }
    }
    private void populateSnakeLadder(){
        snakeLadderPosition=new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeLadderPosition.add(i);

        }
        snakeLadderPosition.set(4,14);
        snakeLadderPosition.set(17,7);
        snakeLadderPosition.set(9,31);
        snakeLadderPosition.set(21,42);
        snakeLadderPosition.set(28,84);
        snakeLadderPosition.set(51,67);
        snakeLadderPosition.set(54,34);
        snakeLadderPosition.set(62,19);
        snakeLadderPosition.set(64,60);
        snakeLadderPosition.set(72,91);
        snakeLadderPosition.set(80,99);
        snakeLadderPosition.set(87,36);
        snakeLadderPosition.set(93,73);
        snakeLadderPosition.set(95,75);
        snakeLadderPosition.set(98,79);
    }
    public  int getNewPosition(int currentPosition){
        if(currentPosition>0 && currentPosition<=100){
            return snakeLadderPosition.get(currentPosition);
        }
        return -1;
    }
    int getXCoordinate(int position){
        if(position>=1 && position<=100)
            return positionCordinates.get(position).getKey();
        return -1;
    }
    int getYCoordinate(int position) {
        if (position >= 1 && position <= 100)
            return positionCordinates.get(position).getValue();
        return -1;
    }


//    public static void main(String[] args) {
//        Board board= new Board();
//        for (int i = 0; i < board.positionCordinates.size(); i++) {
//            System.out.println(i+" $ x :" +board.positionCordinates.get(i).getKey() +
//                    " y : "+board.positionCordinates.get(i).getValue()
//            );
//
//        }
//    }
}
