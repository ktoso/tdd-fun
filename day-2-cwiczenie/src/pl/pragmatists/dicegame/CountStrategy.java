package pl.pragmatists.dicegame;

public enum CountStrategy {
  BY_ONES(1),
  BY_TWOS(2),
  PAIR() {
    @Override
    public int countPoints(int... dices) {
      return findBiggestTupleValueByN(dices, 2);
    }
  };

  private int lookForWhat;

  CountStrategy() {
  }

  CountStrategy(int i) {

    lookForWhat = i;
  }

  public int countPoints(int... dices) {
    int points = 0;
    for (int dice : dices) {
      if (dice == lookForWhat) {
        points += lookForWhat;
      }
    }
    return points;
  }

  private static int findBiggestTupleValueByN(int[] dices, int n) {
    int[] diceCnt = countDices(dices);

    return findBiggestTupleValue(diceCnt, n);
  }

  private static int findBiggestTupleValue(int[] diceCnt, int howBigTuple) {
    //find biggest pair
    for (int i = diceCnt.length - 1; i >= 0; --i) {
      if (diceCnt[i] >= howBigTuple) {
        return i * howBigTuple;
      }
    }
    return 0;
  }

  private static int max(int[] arr) {
    int maxSoFar = arr[0];
    for (int num : arr) {
      if (num > maxSoFar) {
        maxSoFar = num;
      }
    }
    return maxSoFar;
  }

  private static int[] countDices(int[] dices) {
    int biggestDice = max(dices);

    int diceCnt[] = new int[biggestDice + 1];

    //count dices
    for (int dice : dices) {
      ++diceCnt[dice];
    }
    return diceCnt;
  }
}

