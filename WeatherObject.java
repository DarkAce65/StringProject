import org.json.*;
import java.net.*;
import java.io.*;

public class WeatherObject {
	private double latitude, longitude;
	private String weatherForecast;

	public WeatherObject() {
		city = "";
		state = "";
	}

	public JSONObject getDataFromURL(String queryURL) {
		String response = "";

		try {
			URL requestURL = new URL(queryURL);
			URLConnection connection = requestURL.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			while((inputLine = reader.readLine()) != null) {
				response += inputLine;
			}

			reader.close();
			return new JSONObject(response);
		}
		catch(Exception e) {
			System.out.println(e.toString());
			System.exit(0);
		}

		return new JSONObject();
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

	public String getWeatherForecast() {
		JSONObject response = getDataFromURL();
		return "";
	}
}