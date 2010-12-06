package pl.pragmatists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class PrimeFactorsTest {

  @Test
  public void shouldBeEmptyForOne() {
    assertEquals(listOf(), PrimeFactors.generate(1));
  }

  @Test
  public void shouldReturnTwoForTwo() throws Exception {
    assertEquals(listOf(2), PrimeFactors.generate(2));
  }

  @Test
  public void shouldReturnThreeForThree() throws Exception {
    assertEquals(listOf(3), PrimeFactors.generate(3));
  }

  @Test
  public void shouldReturnFactorsOfFour() throws Exception {
    assertEquals(listOf(2, 2), PrimeFactors.generate(4));
  }

  @Test
  public void shouldReturnFactorsOfSix() throws Exception {
    assertEquals(listOf(2, 3), PrimeFactors.generate(6));
  }

  @Test
  public void shouldReturnFactorsOfEight() throws Exception {
    assertEquals(listOf(2, 2, 2), PrimeFactors.generate(8));
  }

  @Test
  public void shouldReturnFactorsOfNice() throws Exception {
    assertEquals(listOf(3, 3), PrimeFactors.generate(9));
  }

  @Test
  public void shouldReturnFactorsOfFourtyTwo() throws Exception {
    assertEquals(listOf(2, 3, 7), PrimeFactors.generate(42));
  }

  private ArrayList<Integer> listOf(Integer... numbers) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    result.addAll(Arrays.asList(numbers));
    return result;
  }
}
