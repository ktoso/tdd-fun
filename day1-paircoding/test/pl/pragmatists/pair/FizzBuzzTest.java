package pl.pragmatists.pair;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

  private FizzBuzz fb = new FizzBuzz();

  @Test
  public void shouldReturnNumberForOne() {
    assertEquals("1", fb.get(1));
  }

  @Test
  public void shouldReturnFizzForThrees() {
    List<Integer> integers = generateFizzNumbers(100);

    for (Integer integer : integers) {
      assertEquals("should fizz for " + integer, FizzBuzz.FIZZ, fb.get(integer));
    }
  }

  @Test
  public void shouldReturnFizzBuzzForFives() {
    List<Integer> integers = generateBuzzNumbers(100);

    for (Integer integer : integers) {
      assertEquals("should buzz for " + integer, FizzBuzz.BUZZ, fb.get(integer));
    }
  }

  @Test
  public void forFifteen() {
    List<Integer> integers = generateFizzBuzzNumbers(100);

    for (Integer integer : integers) {
      assertEquals("should fizzbuzz for " + integer, FizzBuzz.FIZZBUZZ, fb.get(integer));
    }
  }

  @Test
  public void shouldReturnNumberForOthers() {
    List<Integer> integers = generateOtherNumbers(100);

    for (Integer integer : integers) {
      assertEquals("should number for " + integer, String.valueOf(integer), fb.get(integer));
    }
  }

  // my idea, covering some cases
  @Test
  public void testDoesNotContain15etc() throws Exception {
    String myGame = fb.play(100);

    assertThat(myGame).doesNotContain("15");
  }

  // another idea, covering the game, but not in full, but good enough
  @Test
  public void shouldPlayUpToNumber() throws Exception {
    String myGame = fb.play(5); //wow, try this for 10!

    assertThat(myGame).isEqualTo("1\n2\nFizz\n4\nBuzz\n");
  }

  private List<Integer> generateFizzNumbers(int max) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (int i = 1; i <= max; i++) {
      if ((i % FizzBuzz.FIZZ_NUM == 0) && !(i % FizzBuzz.FIZZBUZZ_NUM == 0)) {
        numbers.add(i);
      }
    }
    return numbers;
  }

  private List<Integer> generateBuzzNumbers(int max) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (int i = 1; i <= max; i++) {
      if ((i % FizzBuzz.BUZZ_NUM == 0) && !(i % FizzBuzz.FIZZBUZZ_NUM == 0)) {
        numbers.add(i);
      }
    }
    return numbers;
  }

  private List<Integer> generateFizzBuzzNumbers(int max) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (int i = 1; i <= max; i++) {
      if (i % FizzBuzz.FIZZBUZZ_NUM == 0) {
        numbers.add(i);
      }
    }
    return numbers;
  }

  private List<Integer> generateOtherNumbers(int max) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (int i = 1; i <= max; i++) {
      if (!(i % FizzBuzz.BUZZ_NUM == 0 || i % FizzBuzz.FIZZ_NUM == 0)) {
        numbers.add(i);
      }
    }
    return numbers;
  }
}
