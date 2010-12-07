package pl.pragmatists.dicegame.strategy;

public class MultipleValueStrategy implements YahtzeeCountingStrategy {

  private int pairOrTripletEtc;

  public MultipleValueStrategy(int pairOrTripletEtc) {
    this.pairOrTripletEtc = pairOrTripletEtc;
  }

  @Override
  public int countPoints(int... dice) {
    return findBiggestTupleValue(dice);
  }

  private int findBiggestTupleValue(int[] diceCount) {
    int[] diceCnt = countDices(diceCount);

    for (int i = diceCnt.length - 1; i >= 0; --i) {
      if (diceCnt[i] >= pairOrTripletEtc) {
        return i * pairOrTripletEtc;
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

  private static int[] countDices(int[] dice) {
    int biggestDice = max(dice);

    int diceCnt[] = new int[biggestDice + 1];

    //count dice
    for (int die : dice) {
      ++diceCnt[die];
    }
    return diceCnt;
  }
}
