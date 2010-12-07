package pl.pragmatists.dicegame.strategy;

public class SingleValueStrategy implements YahtzeeCountingStrategy {
  private int lookForWhat;

  public SingleValueStrategy(int lookForWhat) {
    this.lookForWhat = lookForWhat;
  }

  public int countPoints(int... dice) {
    int points = 0;
    for (int die : dice) {
      if (die == lookForWhat) {
        points += lookForWhat;
      }
    }
    return points;
  }
}
