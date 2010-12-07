package pl.pragmatists.dicegame.strategy;

import pl.pragmatists.dicegame.Roll;

import java.util.Arrays;

public class MultipleValueStrategy implements YahtzeeCountingStrategy {

  private int pairOrTripletEtc;

  public MultipleValueStrategy(int pairOrTripletEtc) {
    this.pairOrTripletEtc = pairOrTripletEtc;
  }

  @Override
  public int countPoints(Roll dice) {
    return findBiggestTupleValue(dice.getDice().toArray(new Integer[0]));
  }

  private int findBiggestTupleValue(Integer[] diceCount) {
    int[] diceCnt = countDices(diceCount);

    for (int i = diceCnt.length - 1; i >= 0; --i) {
      if (diceCnt[i] >= pairOrTripletEtc) {
        return i * pairOrTripletEtc;
      }
    }
    return 0;
  }

  private static int max(Integer[] arr) {
    int maxSoFar = arr[0];
    for (int num : arr) {
      if (num > maxSoFar) {
        maxSoFar = num;
      }
    }
    return maxSoFar;
  }

  private static int[] countDices(Integer[] dice) {
    int biggestDice = max(dice);

    int diceCnt[] = new int[biggestDice + 1];

    //count dice
    for (int die : dice) {
      ++diceCnt[die];
    }
    return diceCnt;
  }
}
