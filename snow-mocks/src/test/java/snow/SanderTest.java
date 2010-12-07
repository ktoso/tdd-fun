package snow;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SanderTest {

  @Mock
  MunicipalServices municipalServices;
  @Mock
  WeatherForecastService weatherForecastService;
  @Mock
  PressService pressService;

  SnowRescueService rescueService;

  @Before
  public void setUp() throws Exception {
    rescueService = spy(new SnowRescueService(weatherForecastService, municipalServices, pressService));
  }

  @Test
  public void dontSendSanderWhenGoodWeather() throws Exception {
    when(weatherForecastService.getAverageTemperatureInCelsius()).thenReturn(15);

    rescueService.checkForecastAndRescue();

    verify(municipalServices, never()).sendSander();
  }

  @Test
  public void sendSanderWhenBadWeather() throws Exception {
    when(weatherForecastService.getAverageTemperatureInCelsius()).thenReturn(-1);

    rescueService.checkForecastAndRescue();

    //in order just for fun
    verify(municipalServices).sendSander();
  }

  @Test
  public void sendSnowplowWhenSnowOver3mm() throws Exception {
    when(weatherForecastService.getSnowFallHeightInMM()).thenReturn(0);

    rescueService.checkForecastAndRescue();

    verify(municipalServices, never()).sendSnowplow();
  }

  @Test
  public void sendSnowplowWhenSnowOver3mmAndHandleItsFail() throws Exception {
    when(weatherForecastService.getSnowFallHeightInMM()).thenReturn(4);

    doThrow(new SnowplowMalfunctioningException())
        .doNothing()
        .when(municipalServices).sendSnowplow();

    // send one, it will fail
    rescueService.checkForecastAndRescue();
    verify(municipalServices, times(2)).sendSnowplow();
  }

  @Test
  public void testEmergencySnowServiceReaction() throws Exception {
    when(weatherForecastService.getSnowFallHeightInMM()).thenReturn(11);
    when(weatherForecastService.getAverageTemperatureInCelsius()).thenReturn(-20);

    rescueService.checkForecastAndRescue();

    verify(municipalServices, times(3)).sendSnowplow();

    InOrder inOrder = inOrder(municipalServices, weatherForecastService, pressService);
    inOrder.verify(municipalServices, times(3)).sendSnowplow();
    inOrder.verify(pressService).sendWeatherAlert();
  }
}
