package tdd.clock;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NumbersTest {

  public static final String ZERO = " - \n" +
      "| |\n" +
      "   \n" +
      "| |\n" +
      " - \n";

  static final String FORTY_TWO =
      "     - \n" +
          "| |   |\n" +
          " -   - \n" +
          "  | |  \n" +
          "     - \n";
  static final String ELEVEN =
      "       \n" +
          "  |   |\n" +
          "       \n" +
          "  |   |\n" +
          "       \n";

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {0, ZERO},
        {42, FORTY_TWO},
        {11, ELEVEN},
    });
  }
  int number;

  String conversion;

  EightSegmentDisplay clock = new EightSegmentDisplay();

  public NumbersTest(int number, String conversion) {
    this.number = number;
    this.conversion = conversion;
  }

  @Test
  public void testPrintNumber() throws Exception {
    assertEquals(conversion, clock.printNumber(number));
  }

  @Test
  public void testCons() throws Exception {
    String[] first = {"1", "2"};
    String[] second = {"3", "4"};

    String[] strings = clock.cons(first, second);
    assertEquals(strings[0], "1 3");
    assertEquals(strings[1], "2 4");
  }


}
