package pl.pragmatists.assertions;

import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class HamcrestRevertStringTest {

  public static String revert(String word) {
    return word;
  }

  public static boolean revertable(String word) {
    return false;
  }

  String word = "word";

  @Test
  @Ignore("there is no implementation for the tested method")
  public void notEmptyWordIsRevertable() throws Exception {
    assertThat(revertable(word), is(true));
  }

  @Test
  @Ignore("there is no implementation for the tested method")
  public void emptyWordIsNotRevertable() throws Exception {
    assertThat(revertable(""), is(false));
    assertThat(revertable(null), nullValue());

//    assertFalse(revertable(""));
//    assertFalse(revertable(null));
  }

  @Test
  @Ignore("there is no implementation for the tested method")
  public void revertedPalindromeIsEqualButNotSame() throws Exception {
    String ala = "ala";
    assertThat(ala, is(revert(ala)));

//    assertEquals(ala, revert(ala));
//    assertNotSame(ala, revert(ala));
  }

  @Test
  @Ignore("there is no implementation for the tested method")
  public void revertedNullIsNull() throws Exception {
    assertThat(revert(null), nullValue());

//    assertNull(revert(null));
  }
}

