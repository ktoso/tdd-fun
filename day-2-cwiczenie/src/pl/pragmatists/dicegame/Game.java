package pl.pragmatists.dicegame;

public class Game {

  public int countPoints(CountStrategy strategy, Roll roll) {
    return strategy.countPoints(roll);
  }
}
