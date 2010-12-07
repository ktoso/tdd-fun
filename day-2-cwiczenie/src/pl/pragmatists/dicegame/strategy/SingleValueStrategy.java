package pl.pragmatists.dicegame.strategy;

import pl.pragmatists.dicegame.Roll;

public class SingleValueStrategy implements YahtzeeCountingStrategy {
  private int lookForWhat;

  public SingleValueStrategy(int lookForWhat) {
    this.lookForWhat = lookForWhat;
  }

  public int countPoints(Roll roll) {
    int points = 0;
    for (int die : roll.getDice()) {
      if (die == lookForWhat) {
        points += lookForWhat;
      }
    }
    return points;
  }
}
