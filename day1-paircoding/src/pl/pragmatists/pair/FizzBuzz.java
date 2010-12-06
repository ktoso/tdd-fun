package pl.pragmatists.pair;

public class FizzBuzz {

  public static String FIZZ = "Fizz";
  public static String BUZZ = "Buzz";
  public static String FIZZBUZZ = FIZZ + BUZZ;

  public static final int FIZZ_NUM = 3;
  public static final int BUZZ_NUM = 5;
  public static final int FIZZBUZZ_NUM = FIZZ_NUM * BUZZ_NUM;

  public String get(int i) {
    if (i % FIZZBUZZ_NUM == 0) {
      return FIZZBUZZ;
    }
    if (i % BUZZ_NUM == 0) {
      return BUZZ;
    }
    if (i % FIZZ_NUM == 0) {
      return FIZZ;
    }

    // new rules
    String it = String.valueOf(i);
    if(it.contains(String.valueOf(FIZZ_NUM))){
      return FIZZ;
    }
    if(it.contains(String.valueOf(BUZZ_NUM))){
      return BUZZ;
    }
    if(it.contains(String.valueOf(FIZZ_NUM)) && it.contains(String.valueOf(BUZZ_NUM))){
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

  public static void main(String... args){
    System.out.println(new FizzBuzz().play(100));
  }
}
