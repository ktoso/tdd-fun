package pl.pragmatists.pair;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

  FizzBuzz fb = new FizzBuzz();

  @Test
  public void forOne() throws Exception {
    assertEquals("1", fb.get(1));
  }

  @Test
  public void shouldReturnFizzFor3s() throws Exception {
    List<Integer> integers = generateFizzNumbers(100);

    for (Integer integer : integers) {
      assertEquals("should fizz for " + integer, FizzBuzz.FIZZ, fb.get(integer));
    }
  }

  @Test
  public void shouldReturnFizzBuzzFor5s() throws Exception {
    List<Integer> integers = generateBuzzNumbers(100);

    for (Integer integer : integers) {
      assertEquals("should buzz for " + integer, FizzBuzz.BUZZ, fb.get(integer));
    }
  }

  @Test
  public void forFifteen() throws Exception {
    List<Integer> integers = generateFizzBuzzNumbers(100);

    for (Integer integer : integers) {
      assertEquals("should fizzbuzz for " + integer, FizzBuzz.FIZZBUZZ, fb.get(integer));
    }
  }

  @Test
  public void shouldReturnNumberForOthers() throws Exception {
    List<Integer> integers = generateOtherNumbers(100);

    for (Integer integer : integers) {
      assertEquals("should number for " + integer, String.valueOf(integer), fb.get(integer));
    }
  }


  private List<Integer> generateFizzNumbers(int max) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (int i = 1; i < max; i++) {
      if ((i % FizzBuzz.FIZZ_NUM == 0) && !(i % FizzBuzz.FIZZBUZZ_NUM == 0)) {
        numbers.add(i);
      }
    }
    return numbers;
  }

  private List<Integer> generateBuzzNumbers(int max) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (int i = 1; i < max; i++) {
      if ((i % FizzBuzz.BUZZ_NUM == 0) && !(i % FizzBuzz.FIZZBUZZ_NUM == 0)) {
        numbers.add(i);
      }
    }
    return numbers;
  }

  private List<Integer> generateFizzBuzzNumbers(int max) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (int i = 1; i < max; i++) {
      if (i % FizzBuzz.FIZZBUZZ_NUM == 0) {
        numbers.add(i);
      }
    }
    return numbers;
  }

  private List<Integer> generateOtherNumbers(int max) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (int i = 1; i < max; i++) {
      if (!(i % FizzBuzz.BUZZ_NUM == 0 || i % FizzBuzz.FIZZ_NUM == 0)) {
        numbers.add(i);
      }
    }
    return numbers;
  }
}
