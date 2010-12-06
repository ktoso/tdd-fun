package pl.pragmatists;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"ALL"})
public class PrimeFactors {

  public static List<Integer> generate(int number) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    int candidate = 2;

    while (number > 1) {
      while (isDivisable(number, candidate)) {
        result.add(candidate);
        number /= candidate;
      }
      candidate++;
    }

    return result;
  }

  private static boolean isDivisable(int number, int candidate) {
    return number % candidate == 0;
  }
}
