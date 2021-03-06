package pl.pragmatists.assertions;

import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.*;

public class RevertStringTest {

  public static String revert(String word){
    return word;
  }

  public static boolean revertable(String word){
    return false;
  }


  String word = "word";

  @Test
  @Ignore("there is no implementation for the tested method")
  public void notEmptyWordIsRevertable() throws Exception {
    assertTrue(revertable(word));
  }

  @Test
  @Ignore("there is no implementation for the tested method")
  public void emptyWordIsNotRevertable() throws Exception {
    assertFalse(revertable(""));
    assertFalse(revertable(null));
  }

  @Test
  @Ignore("there is no implementation for the tested method")
  public void revertedPalindromeIsEqualButNotSame() throws Exception {
    String ala = "ala";
    assertEquals(ala, revert(ala));
    assertNotSame(ala, revert(ala));
  }

  @Test
  @Ignore("there is no implementation for the tested method")
  public void revertedNullIsNull() throws Exception {
    assertNull(revert(null));
  }
}

