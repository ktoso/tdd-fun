package snow;

public interface MunicipalServices {

	void sendSnowplow() throws SnowplowMalfunctioningException, NoSnowplowsException;

	void sendSander();

}
