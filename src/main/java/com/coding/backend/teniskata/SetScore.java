package com.coding.backend.teniskata;

import java.util.ArrayList;
import java.util.List;

public class SetScore {

    private int player1GamesWon;
    private int player2GamesWon;

    private List<GameScore> games;
    private GameScore actualGame;

    public SetScore(){
        actualGame = new GameScore();
        games = new ArrayList<>();
    }

    public void startNewGame(){
        if(this.player2GamesWon >= 6 && this.player1GamesWon >= 6)
            actualGame = new TieBreakGame();
        else actualGame = new GameScore();
    }

    public void player1ScorePoint(){
        this.actualGame.player1Score();
        calculateGame();
    }
    public void player2ScorePoint(){
        this.actualGame.player2Score();
        calculateGame();
    }
    public void setGameToPlayer1(){
        games.add(actualGame);
        this.player1GamesWon++;
        startNewGame();
    }

    public void setGameToPlayer2(){
        games.add(actualGame);
        this.player2GamesWon++;
        startNewGame();
    }

    public int numberOfGamesPlayer1(){
        return player1GamesWon;
    }

    public int numberOfGamesPlayer2(){
        return player2GamesWon;
    }

    public String getResult(){

        if(this.player2GamesWon >= 6 || this.player1GamesWon >= 6){
            if(Math.abs(player1GamesWon - player2GamesWon) >=1)
                return "Set won by " + getLeaderSet();
            else
                return actualGame.getResult();
        }

        else {
            return "Player1 : " + this.player1GamesWon + " - " + this.player2GamesWon + " : Player2 / Actual game : "+ actualGame.getResult();
        }
    }

    public String getLeaderSet(){
        if(this.player1GamesWon > this.player2GamesWon) {
            return "player1";
        }
        return "player2";
    }

    public boolean isTieBreakGame(){
        if(actualGame instanceof TieBreakGame) {
            return true;
        }
        return false;
    }
    public String getResultOfActualGame(){
        return actualGame.getResultOfActualGame();
    }

    public void calculateGame(){
        switch (actualGame.getWinner()){
            case 1 : setGameToPlayer1(); break;
            case 2 : setGameToPlayer2(); break;
        }
    }

    public void displayGames(){
        for (GameScore game : games){
            System.out.println(game.getResult());
        }
    }
}
