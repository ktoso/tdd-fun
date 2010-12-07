package pl.pragmatists.dicegame;

public class Game {

  public int countOnes(int... dices) {
    return countPoints(CountStrategy.BY_ONES, dices);
  }

  public int countTwos(int... dices) {
    return countPoints(CountStrategy.BY_TWOS, dices);
  }

  public int countPoints(CountStrategy strategy, int... dices) {
    return strategy.countPoints(dices);
  }
}
