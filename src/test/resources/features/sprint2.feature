Feature: manage a Tennis SET within a tennis match
  Scenario: winning a Set
    Given : player1 has 5 games and player2 has 2 games
    When : player1 wins another game
    Then : player1 wins the set
  Scenario: Starting a TieBreak game
    Given : player1 has 6 games and player2 has 5 games
    When : player2 win the sixth game
    Then : starting the tiebreak game
  Scenario: Winning Tie Break game
    Given : player1 has 5 points and player2 has 3 points
    When : player2 scores 1 point and player1 scores 2 points
    Then : player1 win the set


