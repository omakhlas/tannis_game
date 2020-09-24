package com.coding.backend.teniskata;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertEquals;

public class StepDefinitions {

    GameScore game;
    SetScore set;
    @Before
    public void init() {
        game = new GameScore();
        set = new SetScore();
    }

    @When("^: Player(\\d+) scores a point$")
    public void player_scores_a_point(int arg1) throws Throwable {
        this.game.player1Score();
    }

    @Then("^: GameScore changes$")
    public void gamescore_changes() throws Throwable {
        assertEquals("15, Zero",this.game.getResult());
    }

    @When("^: Player(\\d+) scores a point after Deuce$")
    public void player_scores_a_point_after_Deuce(int arg1) throws Throwable {
        for(int i = 0; i <=3;i++){
            this.game.player1Score();
            this.game.player2Score();
        }
        this.game.player1Score();
    }

    @Then("^: Player (\\d+) takes ADV$")
    public void player_takes_ADV(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("ADV player1",this.game.getResult());
    }

    @When("^: player(\\d+) scores a point after Adv$")
    public void player_scores_a_point_after_Adv(int arg1) throws Throwable {
        for(int i = 0; i <=3;i++){
            this.game.player1Score();
            this.game.player2Score();
        }
        this.game.player1Score();
        this.game.player1Score();
    }

    @Then("^: player(\\d+) wins the game$")
    public void player_wins_the_game(int arg1) throws Throwable {
        assertEquals("Game win by player1",this.game.getResult());
    }

    @Given("^: player1 has (\\d+) games and player2 has (\\d+) games$")
    public void player_has_games_and_player_has_games(int numberOfGamesWonByPlayer1, int numberOfGamesWonByPlayer2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        for(int i = 0 ; i < numberOfGamesWonByPlayer1 ; i++){
            set.setGameToPlayer1();
        }

        for(int i = 0 ; i < numberOfGamesWonByPlayer2 ; i++){
            set.setGameToPlayer2();
        }

        assertEquals(numberOfGamesWonByPlayer1,this.set.numberOfGamesPlayer1());
    }

    @When("^: player(\\d+) wins another game$")
    public void player_wins_another_game(int arg1) throws Throwable {
        this.set.setGameToPlayer1();
    }

    @Then("^: player(\\d+) wins the set$")
    public void player_wins_the_set(int arg1) throws Throwable {
        assertEquals("Set won by player1", this.set.getResult());
    }

    @When("^: player2 win the sixth game$")
    public void player_win_the_sixth_game() throws Throwable {
        set.setGameToPlayer2();
        assertEquals(6,set.numberOfGamesPlayer2());
    }

    @Then("^: starting the tiebreak game$")
    public void starting_the_tiebreak_game() throws Throwable {
        assertEquals(true,set.isTieBreakGame());
    }

    @Given("^: player1 has (\\d+) points and player2 has (\\d+) points$")
    public void player_has_points_and_player_has_points(int pointsScoredByPlayer1, int pointsScoredByPlayer2) throws Throwable {
        for(int i = 0 ; i < 6 ; i++){
            set.setGameToPlayer1();
            set.setGameToPlayer2();
        }

        for(int i = 0 ; i<pointsScoredByPlayer1;i++) set.player1ScorePoint();
        for(int i = 0 ; i<pointsScoredByPlayer2;i++) set.player2ScorePoint();

    }

    @When("^: player2 scores (\\d+) point and player1 scores (\\d+) points$")
    public void player_scores_point_and_player_scores_points(int pointsScoredByPlayer2, int pointsScoredByPlayer1) throws Throwable {
        for(int i = 0 ; i<pointsScoredByPlayer2;i++) set.player2ScorePoint();
        for(int i = 0 ; i<pointsScoredByPlayer1;i++) set.player1ScorePoint();
    }

    @Then("^: player(\\d+) win the set$")
    public void player_win_the_set(int arg1) throws Throwable {
        assertEquals("Set won by player1", set.getResult());
    }
}