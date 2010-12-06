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
  public void shouldReturnFizz() {
    List<Integer> integers = generateFizzNumbers(100);

    for (Integer integer : integers) {
      assertIsFizz(fb.get(integer));
    }
  }

  @Test
  public void shouldReturnBuzz() {
    List<Integer> integers = generateBuzzNumbers(100);

    for (Integer integer : integers) {
      assertIsBuzz(fb.get(integer));
    }
  }

  @Test
  public void shouldReturnFizzBuzz() {
    List<Integer> integers = generateFizzBuzzNumbers(100);

    for (Integer integer : integers) {
      assertIsFizzBuzz(fb.get(integer));
    }
  }

  @Test
  public void shouldReturnNumberForOthers() {
    List<Integer> integers = generateOtherNumbers(100);

    for (Integer integer : integers) {
      assertIsNumber(fb.get(integer));
    }
  }

  /**
   * my idea, covering some cases
   */
  @Test
  public void testDoesNotContain15etc() {
    String myGame = fb.play(100);

    assertThat(myGame)
        .doesNotMatch("^5&")
        .doesNotMatch("^10&")
        .doesNotMatch("^15&")

        .doesNotMatch("^3&")
        .doesNotMatch("^9&")
        .doesNotMatch("^30&");
  }

  /**
   * another idea, covering the game, but not in full, but good enough
   */
  @Test
  public void shouldPlayUpToNumber() {
    String myGame = fb.play(5); //wow, try this for 10!

    assertThat(myGame).isEqualTo("1\n2\nFizz\n4\nBuzz\n");
  }

  @Test
  public void forNumberContainingThree() {
    assertEquals(FizzBuzz.FIZZ, fb.get(32));
  }

  @Test
  public void playWithOtherFizzBuzzNumbers() {
    fb = new FizzBuzz(2, 5);

    String myGame = fb.play(5); //wow, try this for 10!

    assertThat(myGame).isEqualTo("1\nFizz\n3\nFizz\nBuzz\n");
  }

  // asserts

  private void assertIsBuzz(String response) {
    assertEquals("should buzz for " + response, FizzBuzz.BUZZ, response);
  }

  private void assertIsFizz(String response) {
    assertEquals("should fizz for " + response, FizzBuzz.FIZZ, response);
  }

  private void assertIsFizzBuzz(String response) {
    assertEquals("should fizzbuzz for " + response, FizzBuzz.FIZZBUZZ, response);
  }

  private void assertIsNumber(String response) {
    assertEquals("should number for " + response, String.valueOf(response), response);
  }

  // tools

  private List<Integer> generateFizzNumbers(int upTo) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (int i = 1; i <= upTo; i++) {
      if ((i % fb.getFizzNum() == 0) && !(i % fb.getFizzBuzzNum() == 0)) {
        numbers.add(i);
      }
    }
    return numbers;
  }

  private List<Integer> generateBuzzNumbers(int upTo) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (int i = 1; i <= upTo; i++) {
      if ((i % fb.getBuzzNum() == 0) && !(i % fb.getFizzBuzzNum() == 0)) {
        numbers.add(i);
      }
    }
    return numbers;
  }

  private List<Integer> generateFizzBuzzNumbers(int upTo) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (int i = 1; i <= upTo; i++) {
      if (i % fb.getFizzBuzzNum() == 0) {
        numbers.add(i);
      }
    }
    return numbers;
  }

  private List<Integer> generateOtherNumbers(int upTo) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for (int i = 1; i <= upTo; i++) {
      if (!(i % fb.getBuzzNum() == 0 || i % fb.getFizzNum() == 0
          || String.valueOf(i).contains(String.valueOf(fb.getFizzNum()))
          || String.valueOf(i).contains(String.valueOf(fb.getBuzzNum())))) {
        numbers.add(i);
      }
    }
    return numbers;
  }
}
