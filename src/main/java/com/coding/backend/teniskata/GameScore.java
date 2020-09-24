package com.coding.backend.teniskata;

public class GameScore {

    protected Player player1;
    protected Player player2;


    public GameScore(){
        this.player1 = new Player();
        this.player2 = new Player();
    }

    public void player1Score(){
        this.player1.scorePoint();
    }
    public void player2Score(){
        this.player2.scorePoint();
    }

    public String getResult(){

        int player1Score = this.player1.getScore();
        int player2Score = this.player2.getScore();


        if(player1Score >=3 || player2Score >= 3){
            if(player1Score - player2Score == 0) {
                return "DEUCE";
            }
            else if(Math.abs(player1Score - player2Score) > 1){
                return "Game win by " + getLeadPlayer();
            }
            else {
                return "ADV " + getLeadPlayer();
            }
        }
        if(player1Score <=2 && player2Score <=2)    {
            return this.player1.returnScore() + ", " + this.player2.returnScore();
        }

        else if(player1Score - player2Score == 0)   {
            return "DEUCE";
        }
        return null;
    }

    public String getLeadPlayer(){
        if(player1.getScore() > player2.getScore()) {
            return "player1";
        }
        return "player2";
    }

    public int getPlayer1Score() {
        return player1.getScore();
    }
    public int getPlayer2Score() {
        return player2.getScore();
    }

    public String getResultOfActualGame(){
        return player1.returnScore() + " - " + player2.returnScore();
    }

    public short getWinner(){
        int player1Score = this.player1.getScore();
        int player2Score = this.player2.getScore();

        if((player1Score >=3 || player2Score >= 3) && Math.abs(player1Score - player2Score) > 1){
            if (player1Score>player2Score) return 1;
            else return 2;
        }
        return 0;
    }
}
