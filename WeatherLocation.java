public class WeatherLocation {
	private double latitude, longitude;

	public WeatherLocation() {
		latitude = 0.0;
		longitude = 0.0;
	}

	public WeatherLocation(double lat, double lon) {
		latitude = lat;
		longitude = lon;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double lat) {
		latitude = lat;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLongitude(double lon) {
		longitude = lon;
	}

	public void setLatitudeLongitude(double lat, double lon) {
		latitude = lat;
		longitude = lon;
	}
}