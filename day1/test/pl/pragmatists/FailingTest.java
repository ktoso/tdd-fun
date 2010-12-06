package pl.pragmatists;

import org.junit.Test;

import static junit.framework.Assert.fail;

public class FailingTest {

  @Test //as in JUnit 3
  public void dieByNull() throws Exception {
    try {
      doStuff(null);
      fail(); //this is important
    } catch (NullPointerException ex) {

    }
  }

  private void doStuff(Object o) throws NullPointerException {
    o.equals(2);
  }
}

