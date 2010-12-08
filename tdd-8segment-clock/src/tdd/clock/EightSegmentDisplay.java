package tdd.clock;


import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;

public class EightSegmentDisplay {

  private enum Conversion {
    ZERO(0, " - ",
        "| |",
        "   ",
        "| |",
        " - "),
    ONE(1, "   ",
        "  |",
        "   ",
        "  |",
        "   "),

    TWO(2, " - ",
        "  |",
        " - ",
        "|  ",
        " - "),
    THREE(3, " - ",
        "  |",
        " - ",
        "  |",
        " - "),

    FOUR(4, "   ",
        "| |",
        " - ",
        "  |",
        "   "),

    FIVE(5, " - ",
        "|  ",
        " - ",
        "  |",
        " - "),

    SIX(6, " - ",
        "|  ",
        " - ",
        "| |",
        " - "),
    SEVEN(7, " - ",
        "  |",
        "   ",
        "  |",
        "   "),
    EIGHT(8, " - ",
        "| |",
        " - ",
        "| |",
        " - "),
    NINE(9, " - ",
        "| |",
        " - ",
        "  |",
        " - ");

    private final Integer number;

    private final String[] conversion;

    Conversion(Integer number, String... conversion) {
      this.number = number;
      this.conversion = conversion;
    }

    public String printDigit() {
      return Joiner.on("\n").join(conversion) + "\n";
    }

    public static Conversion chooseEnum(int number) {
      return Conversion.values()[number];
    }

  }

  public String printOneDigit(int number) {
    Conversion conversion = Conversion.chooseEnum(number);
    return conversion.printDigit();
  }

  public String printNumber(int number) {
    if (number < 10) {
      return printOneDigit(number);
    }

    List<Integer> stack = new LinkedList<Integer>();
    while (number > 0) {
      stack.add(number % 10);
      number /= 10;
    }

    stack = Lists.reverse(stack);

    String[] almostResult;
    almostResult = Conversion.chooseEnum(stack.get(0)).conversion;

    for (int i = 1; i < stack.size(); i++) {
      Conversion conversion = Conversion.chooseEnum(stack.get(i));
      almostResult = cons(almostResult, conversion.conversion);
    }

    return Joiner.on("\n").join(almostResult) + "\n";
  }

  public String[] cons(String[] car, String[] cdr) {
    assert car.length == cdr.length : "Can't do that";

    String[] strings = new String[car.length];
    for (int i = 0; i < car.length; ++i) {
      strings[i] = String.format("%s %s", car[i], cdr[i]);
    }
    return strings;
  }

}
