package snow;

public enum HowMuchSnowplowsNeeded {
  SEND_NO_SNOWPLOW_LEVEL(0) {
    @Override
    boolean matches(int temp, int snowLevel) {
      return true;
    }
  },
  SEND_SNOWPLOW_LEVEL(1) {
    @Override
    boolean matches(int temp, int snowLevel) {
      return snowAbove(snowLevel, 3);
    }
  },
  SEND_ANOTHER_SNOWPLOW_LEVEL(2) {
    @Override
    boolean matches(int temp, int snowLevel) {
      return snowAbove(snowLevel, 5);
    }
  },
  SEND_THREE_SNOWPLOW_LEVEL(3, true) {
    @Override
    boolean matches(int temp, int snowLevel) {
      return tempBellow(temp, -10) && snowAbove(snowLevel, 10);
    }
  };

  private int snowPlowsNeeded;
  private boolean needToInformPress;

  HowMuchSnowplowsNeeded(int snowPlowsNeeded) {
    this.snowPlowsNeeded = snowPlowsNeeded;
  }

  HowMuchSnowplowsNeeded(int snowPlowsNeeded, int snowLevel) {
    this.snowPlowsNeeded = snowPlowsNeeded;
  }

  HowMuchSnowplowsNeeded(int snowPlowsNeeded, boolean needToInformPress) {
    this.snowPlowsNeeded = snowPlowsNeeded;
    this.needToInformPress = needToInformPress;
  }

  public static HowMuchSnowplowsNeeded decideStrategy(int temp, int snowLevel) {
    if (SEND_THREE_SNOWPLOW_LEVEL.matches(temp, snowLevel)) {
      return SEND_THREE_SNOWPLOW_LEVEL;
    }

    if (SEND_ANOTHER_SNOWPLOW_LEVEL.matches(temp, snowLevel)) {
      return SEND_ANOTHER_SNOWPLOW_LEVEL;
    }

    if (SEND_SNOWPLOW_LEVEL.matches(temp, snowLevel)) {
      return SEND_SNOWPLOW_LEVEL;
    }

    return SEND_NO_SNOWPLOW_LEVEL;
  }

  abstract boolean matches(int temp, int snowLevel);

  private static boolean snowAbove(int snowLevel, int actualSnow) {
    return snowLevel > actualSnow;
  }

  private static boolean tempBellow(int temp, int actualTemp) {
    return temp < actualTemp;
  }

  public boolean needToInformPress() {
    return needToInformPress;
  }

  public int getSnowplowsNeeded() {
    return snowPlowsNeeded;
  }
}
