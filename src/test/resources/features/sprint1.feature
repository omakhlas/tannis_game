Feature: manage a tennis game within a set of a tennis match
  Scenario: scoring a point
    When : Player1 scores a point
    Then : GameScore changes

  Scenario: scoring a point : Deuce Rule
    When : Player1 scores a point after Deuce
    Then : Player 1 takes ADV

  Scenario: scoring a winner point : Adv Rule
    When : player1 scores a point after Adv
    Then : player1 wins the game