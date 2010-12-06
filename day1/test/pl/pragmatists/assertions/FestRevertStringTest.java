package pl.pragmatists.assertions;

import org.junit.Test;

import java.util.Arrays;

import static org.fest.assertions.Assertions.assertThat;

public class FestRevertStringTest {

  public static String revert(String word) {
    return word;
  }

  public static boolean revertable(String word) {
    return false;
  }


  String word = "word";

  @Test
  public void testFunWithFestAssert() throws Exception {
    assertThat(Arrays.asList("a", "b"))
        .startsWith("a")
        .endsWith("b")
        .containsSequence("a", "b")
        .isNotNull()
        .doesNotHaveDuplicates();

    assertThat(Arrays.asList(hasName("jacek"), hasName("klemens"), hasName("wacek")))
        .onProperty("name")
        .contains("jacek", "wacek");
  }

  @Test
  public void notEmptyWordIsNOTRevertable() throws Exception {
    assertThat(revertable(word)).isFalse();
  }

  @Test
  public void emptyWordIsNotRevertable() throws Exception {
    assertThat(revertable("")).isFalse();
    assertThat(revertable(null)).isFalse();
//    assertFalse(revertable(""));
//    assertFalse(revertable(null));
  }

  @Test
  public void revertedPalindromeIsEqualButNotSame() throws Exception {
    String ala = "ala";
    assertThat(ala).isEqualToIgnoringCase(revert(ala));
    assertThat(ala).isSameAs(revert(ala));
  }

  @Test
  public void revertedNullIsNull() throws Exception {
    assertThat(revert(null)).isNull();
    assertThat(revert(null)).isNullOrEmpty(); //cool
  }

  private HasName hasName(String name) {
    return new HasName(name);
  }

  public class HasName {
    private String name;

    public HasName(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}

