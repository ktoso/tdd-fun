package pl.pragmatists.dicegame;

import pl.pragmatists.dicegame.strategy.MultipleValueStrategy;
import pl.pragmatists.dicegame.strategy.SingleValueStrategy;
import pl.pragmatists.dicegame.strategy.YahtzeeCountingStrategy;

public enum CountStrategy {
  BY_ONES(new SingleValueStrategy(1)),
  BY_TWOS(new SingleValueStrategy(2)),
  PAIR(new MultipleValueStrategy(2)),
  TRIPLET(new MultipleValueStrategy(3));

  private YahtzeeCountingStrategy countingStrategy;

  CountStrategy(YahtzeeCountingStrategy countingStrategy) {
    this.countingStrategy = countingStrategy;
  }

  public int countPoints(Roll roll) {
    return countingStrategy.countPoints(roll);
  }
}

