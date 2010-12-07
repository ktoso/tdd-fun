package pl.pragmatists.dicegame;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DiceThrowTests {

  Game game = new Game();

  @Test
  public void testOnesThrows() {
    assertEquals(game.countOnes(1,1,2,5,3,4), 2);
    assertEquals(game.countOnes(1,3,4,2,5,4), 1);
    assertEquals(game.countOnes(1,1,1,1,1,1), 6);
  }

  @Test
  public void testTwoThrows() {
    assertEquals(game.countTwos(1, 1, 2, 5, 3, 4), 2);
    assertEquals(game.countTwos(1, 3, 2, 2, 3, 4), 4);
    assertEquals(game.countTwos(2, 2, 2, 2, 2, 2), 12);
  }

  @Test
  public void testPairThrows() throws Exception {
    assertEquals(8, game.countPoints(CountStrategy.PAIR, 1,5,1,4,4));
    assertEquals(6, game.countPoints(CountStrategy.PAIR, 1,5,1,3,3));
  }
}
