package pl.pragmatists.pair;

public class FizzBuzz {

  public static String FIZZ = "Fizz";
  public static String BUZZ = "Buzz";
  public static String FIZZBUZZ = FIZZ + BUZZ;

  private int fizzNum = 3;
  private int buzzNum = 5;
  private int fizzBuzzNum = fizzNum * buzzNum;

  public FizzBuzz() {
  }

  public FizzBuzz(int fizzNum, int buzzNum) {
    this.fizzNum = fizzNum;
    this.buzzNum = buzzNum;
    fizzBuzzNum = fizzNum * buzzNum;
  }

  public String get(int i) {
    if (isDivisableByFizzBuzzNum(i)) {
      return FIZZBUZZ;
    }
    if (isDivisableByBuzzNum(i)) {
      return BUZZ;
    }
    if (isDivisableByFizzNum(i)) {
      return FIZZ;
    }

    // new rules
    String it = String.valueOf(i);
    if (containsFizzNum(it)) {
      return FIZZ;
    }
    if (containsBuzzNum(it)) {
      return BUZZ;
    }
    if (containsFizzNum(it) && containsBuzzNum(it)) {
      return FIZZBUZZ;
    }

    return String.valueOf(i);
  }

  private boolean containsBuzzNum(String it) {
    return it.contains(String.valueOf(buzzNum));
  }

  private boolean containsFizzNum(String it) {
    return it.contains(String.valueOf(fizzNum));
  }

  private boolean isDivisableByFizzNum(int i) {
    return i % fizzNum == 0;
  }

  private boolean isDivisableByBuzzNum(int i) {
    return i % buzzNum == 0;
  }

  private boolean isDivisableByFizzBuzzNum(int i) {
    return i % fizzBuzzNum == 0;
  }

  public String play(int max) {
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= max; i++) {
      sb.append(get(i)).append('\n');
    }

    return sb.toString();
  }

  public int getFizzNum() {
    return fizzNum;
  }

  public int getBuzzNum() {
    return buzzNum;
  }

  public int getFizzBuzzNum() {
    return fizzBuzzNum;
  }

  public static void main(String... args) {
    System.out.println(new FizzBuzz().play(100));
  }
}
