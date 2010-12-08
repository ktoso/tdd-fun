package tdd.clock;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DigitsTest {
  
  public static final String ONE = "   \n" +
      "  |\n" +
      "   \n" +
      "  |\n" +
      "   \n";

  public static final String TWO = " - \n" +
      "  |\n" +
      " - \n" +
      "|  \n" +
      " - \n";
  public static final String THREE = " - \n" +
      "  |\n" +
      " - \n" +
      "  |\n" +
      " - \n";

  public static final String FOUR = "   \n" +
      "| |\n" +
      " - \n" +
      "  |\n" +
      "   \n";

  public static final String FIVE = " - \n" +
      "|  \n" +
      " - \n" +
      "  |\n" +
      " - \n";

  public static final String SIX = " - \n" +
      "|  \n" +
      " - \n" +
      "| |\n" +
      " - \n";
  public static final String SEVEN = " - \n" +
      "  |\n" +
      "   \n" +
      "  |\n" +
      "   \n";
  public static final String EIGHT = " - \n" +
      "| |\n" +
      " - \n" +
      "| |\n" +
      " - \n";
  public static final String NINE = " - \n" +
      "| |\n" +
      " - \n" +
      "  |\n" +
      " - \n";
  public static final String ZERO = " - \n" +
      "| |\n" +
      "   \n" +
      "| |\n" +
      " - \n";

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {0, ZERO},
        {1, ONE},
        {2, TWO},
        {3, THREE},
        {4, FOUR},
        {5, FIVE},
        {6, SIX},
        {7, SEVEN},
        {8, EIGHT},
        {9, NINE},
    });
  }

  int number;
  String conversion;

  EightSegmentDisplay clock = new EightSegmentDisplay();

  public DigitsTest(int number, String conversion) {
    this.number = number;
    this.conversion = conversion;
  }

  @Test
  public void testPrintOneDigit() throws Exception {
    assertEquals(conversion, clock.printOneDigit(number));
  }

}
