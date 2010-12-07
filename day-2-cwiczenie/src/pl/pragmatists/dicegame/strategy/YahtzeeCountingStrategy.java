package pl.pragmatists.dicegame.strategy;

import pl.pragmatists.dicegame.Roll;

public interface YahtzeeCountingStrategy {
  int countPoints(Roll dice);
}
