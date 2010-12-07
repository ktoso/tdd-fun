package pl.pragmatists.dicegame;

public class Game {

  public int countPoints(CountStrategy strategy, int... dices) {
    return strategy.countPoints(dices);
  }
}
