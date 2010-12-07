package snow;

public class SnowRescueService {

  private WeatherForecastService weatherForecastService;
  private MunicipalServices municipalServices;
  private PressService pressService;

  private static final int SEND_SANDER_LEVEL = 0;


  public SnowRescueService(WeatherForecastService weatherForecastService,
                           MunicipalServices municipalServices,
                           PressService pressService) {
    this.weatherForecastService = weatherForecastService;
    this.municipalServices = municipalServices;
    this.pressService = pressService;
  }

  public void checkForecastAndRescue() {
    sendSander();

    int tempC = weatherForecastService.getAverageTemperatureInCelsius();
    int snowMM = weatherForecastService.getSnowFallHeightInMM();
    HowMuchSnowplowsNeeded strategy = HowMuchSnowplowsNeeded.decideStrategy(tempC, snowMM);
    sendSnowplows(strategy);
  }

  private void sendSander() {
    if (temperatureIsBellow(SEND_SANDER_LEVEL)) {
      municipalServices.sendSander();
    }
  }

  private void sendSnowplows(HowMuchSnowplowsNeeded strategy) {
    int howMuch = strategy.getSnowplowsNeeded();
    for(int i = 0; i < howMuch; i++){
      sendSnowplowWithResendOnFail();
    }

    if(strategy.needToInformPress()){
      pressService.sendWeatherAlert();
    }
  }

  private void sendSnowplowWithResendOnFail() {
    try {
      municipalServices.sendSnowplow();
    } catch (SnowplowMalfunctioningException ex) {
      sendSnowplowWithResendOnFail();
    }
  }

  private boolean temperatureIsBellow(int temp) {
    return weatherForecastService.getAverageTemperatureInCelsius() < temp;
  }

}
