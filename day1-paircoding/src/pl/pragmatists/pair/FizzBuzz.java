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
    if (i % fizzBuzzNum == 0) {
      return FIZZBUZZ;
    }
    if (i % buzzNum == 0) {
      return BUZZ;
    }
    if (i % fizzNum == 0) {
      return FIZZ;
    }

    // new rules
    String it = String.valueOf(i);
    if(it.contains(String.valueOf(fizzNum))){
      return FIZZ;
    }
    if(it.contains(String.valueOf(buzzNum))){
      return BUZZ;
    }
    if(it.contains(String.valueOf(fizzNum)) && it.contains(String.valueOf(buzzNum))){
      return FIZZBUZZ;
    }

    return String.valueOf(i);
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

  public static void main(String... args){
    System.out.println(new FizzBuzz().play(100));
  }
}
