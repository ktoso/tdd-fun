package pl.pragmatists.dicegame;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static pl.pragmatists.dicegame.CountStrategy.*;

public class DiceThrowTests {

  Game game = new Game();

  @Test
  public void testOnesThrows() {
    assertEquals(2, game.countPoints(BY_ONES, new Roll(1, 1, 2, 5, 3, 4)));
    assertEquals(1, game.countPoints(BY_ONES, new Roll(1, 3, 4, 2, 5, 4)));
    assertEquals(6, game.countPoints(BY_ONES, new Roll(1, 1, 1, 1, 1, 1)));
  }

  @Test
  public void testTwoThrows() {
    assertEquals(2, game.countPoints(BY_TWOS, new Roll(1, 1, 2, 5, 3, 4)));
    assertEquals(4, game.countPoints(BY_TWOS, new Roll(1, 3, 2, 2, 3, 4)));
    assertEquals(12, game.countPoints(BY_TWOS, new Roll(2, 2, 2, 2, 2, 2)));
  }

  @Test
  public void testPairThrows() throws Exception {
    assertEquals(8, game.countPoints(PAIR, new Roll(1, 5, 1, 4, 4)));
    assertEquals(6, game.countPoints(PAIR, new Roll(1, 5, 1, 3, 3)));
  }

  @Test
  public void testTriplet() throws Exception {
    assertEquals(3, game.countPoints(TRIPLET, new Roll(1, 1, 1, 1, 1)));
    assertEquals(9, game.countPoints(TRIPLET, new Roll(1, 5, 3, 3, 3)));
  }

  @Test
  public void testZeroCases() throws Exception {
    assertZero(game.countPoints(BY_ONES, new Roll(5, 2, 2, 5, 3, 4)));
    assertZero(game.countPoints(BY_TWOS, new Roll(5, 4, 5, 5, 3, 4)));
    assertZero(game.countPoints(PAIR, new Roll(3, 5, 4, 6, 1)));
    assertZero(game.countPoints(TRIPLET, new Roll(3, 1, 4, 2, 1)));
  }

  // asserts

  private void assertZero(int number) {
    assertEquals(0, number);
  }
}
