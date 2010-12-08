package tdd.clock;


import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;

public class EightSegmentDisplay {

  private enum Digit {
    ZERO(0,
        " - ",
        "| |",
        "   ",
        "| |",
        " - "),
    ONE(1,
        "   ",
        "  |",
        "   ",
        "  |",
        "   "),

    TWO(2,
        " - ",
        "  |",
        " - ",
        "|  ",
        " - "),
    THREE(3,
        " - ",
        "  |",
        " - ",
        "  |",
        " - "),

    FOUR(4,
        "   ",
        "| |",
        " - ",
        "  |",
        "   "),

    FIVE(5,
        " - ",
        "|  ",
        " - ",
        "  |",
        " - "),

    SIX(6,
        " - ",
        "|  ",
        " - ",
        "| |",
        " - "),
    SEVEN(7,
        " - ",
        "  |",
        "   ",
        "  |",
        "   "),
    EIGHT(8,
        " - ",
        "| |",
        " - ",
        "| |",
        " - "),
    NINE(9,
        " - ",
        "| |",
        " - ",
        "  |",
        " - ");

    private final Integer number;

    private final String[] conversion;
    private final EightSegmentDigit segmentNumber;

    Digit(Integer number, String... conversion) {
      this.number = number;
      this.conversion = conversion;
      segmentNumber = new EightSegmentDigit(conversion);
    }

    public String printDigit() {
      return Joiner.on("\n").join(conversion) + "\n";
    }

    public static Digit chooseEnum(int number) {
      return Digit.values()[number];
    }

  }

  public String printOneDigit(int number) {
    Digit digit = Digit.chooseEnum(number);
    return digit.printDigit();
  }

  public String printNumber(int number) {
    if (number < 10) {
      return printOneDigit(number);
    }

    List<Integer> stack = disassembleNumber(number);

    return convertAndConcat(stack);
  }

  private String convertAndConcat(List<Integer> list) {
    String[] almostResult = Digit.chooseEnum(list.get(0)).conversion;

    for (int i = 1; i < list.size(); i++) {
      Digit digit = Digit.chooseEnum(list.get(i));
      almostResult = append(almostResult, digit.conversion);
    }
    return Joiner.on("\n").join(almostResult) + "\n";
  }

  private List<Integer> disassembleNumber(int number) {
    List<Integer> list = new LinkedList<Integer>();
    while (number > 0) {
      list.add(number % 10);
      number /= 10;
    }

    list = Lists.reverse(list);
    return list;
  }

  public String[] append(String[] appendTo, String[] appendThis) {
    assert appendTo.length == appendThis.length : "Can't do that";

    String[] strings = new String[appendTo.length];
    for (int i = 0; i < appendTo.length; ++i) {
      strings[i] = String.format("%s %s", appendTo[i], appendThis[i]);
    }
    return strings;
  }

}
