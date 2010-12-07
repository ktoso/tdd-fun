package pl.pragmatists.dicegame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Roll {
  private List<Integer> diceRolls = new ArrayList<Integer>();

  public Roll(Integer... diceRolls) {
    this.diceRolls = Arrays.asList(diceRolls);
  }

  public List<Integer> getDice() {
    return diceRolls;
  }
}
