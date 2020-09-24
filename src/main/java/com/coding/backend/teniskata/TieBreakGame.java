package com.coding.backend.teniskata;

public class TieBreakGame extends GameScore{

    public TieBreakGame() {
        super();
    }

    public String getResult(){

        int player1Score = this.player1.getScore();
        int player2Score = this.player2.getScore();


        if((player1Score >=7 || player2Score >=7 )&& Math.abs(player1Score - player1Score) >= 2){
            return "Tie Break Winner + " + getLeadPlayer();
        }
        else {
            return "Tie Break game : Player1 " + player1Score + " - " + player2Score + " Player2";
        }
    }

    public String getResultOfActualGame(){
        return player1.getScore() + " - " + player2.getScore();
    }

    public short getWinner(){
        int player1Score = this.player1.getScore();
        int player2Score = this.player2.getScore();

        if((player1Score >=7 || player2Score >= 7) && Math.abs(player1Score - player2Score) > 1){
            if (player1Score>player2Score) return 1;
            else return 2;
        }
        return 0;
    }
}
