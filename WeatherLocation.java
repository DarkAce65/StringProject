public class WeatherLocation {
	private double latitude, longitude;

	/**
	* Class constructor.
	*/
	public WeatherLocation() {
		latitude = 0.0;
		longitude = 0.0;
	}

	/**
	* Class constructor with latitude and longitude.
	*/
	public WeatherLocation(double lat, double lon) {
		latitude = lat;
		longitude = lon;
	}

	/**
	* Get latitude.
	* @return Latitude as a double
	*/
	public double getLatitude() {
		return latitude;
	}

	/**
	* Set latitude.
	* @param lat Latitude to set
	*/
	public void setLatitude(double lat) {
		latitude = lat;
	}

	/**
	* Get longitude.
	* @return Longitude as a double
	*/
	public double getLongitude() {
		return longitude;
	}

	/**
	* Set longitude.
	* @param lon Longitude to set
	*/
	public void setLongitude(double lon) {
		longitude = lon;
	}

	/**
	* Set latitude and longitude.
	* @param lat Latitude to set
	* @param lon Longitude to set
	*/
	public void setLatitudeLongitude(double lat, double lon) {
		latitude = lat;
		longitude = lon;
	}
}