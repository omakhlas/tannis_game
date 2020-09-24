package com.coding.backend.teniskata;

public class Player {

    private int score;


    public Player(){
        this.score = 0;
    }

    public void scorePoint(){
        this.score++;
    }

    public int getScore(){
        return this.score;
    }
    public String returnScore(){
        return PointScore.values()[this.score].getScore();
    }
}
