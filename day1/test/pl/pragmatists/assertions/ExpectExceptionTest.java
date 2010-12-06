package pl.pragmatists.assertions;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.*;

public class ExpectExceptionTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void dieByNull() throws Exception {
    expectedException.expect(NullPointerException.class);
    expectedException.expectMessage("Pojawil sie null pointer");

    doStuff(null);
  }

  private void doStuff(Object o) {
    o.equals(2);
  }
}

