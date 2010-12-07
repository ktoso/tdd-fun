package pl.pragmatists.dicegame;

import pl.pragmatists.dicegame.strategy.MultipleValueStrategy;
import pl.pragmatists.dicegame.strategy.SingleValueStrategy;
import pl.pragmatists.dicegame.strategy.YahtzeeCountingStrategy;

public enum CountStrategy {
  BY_ONES(new SingleValueStrategy(1)),
  BY_TWOS(new SingleValueStrategy(2)),
  PAIR(new MultipleValueStrategy(2)),
  TRIPLET(new MultipleValueStrategy(3));

  private YahtzeeCountingStrategy countPoints;

  CountStrategy(YahtzeeCountingStrategy singleValueStrategy) {
    this.countPoints = singleValueStrategy;
  }

  public int countPoints(int... dice) {
    return countPoints.countPoints(dice);
  }
}

