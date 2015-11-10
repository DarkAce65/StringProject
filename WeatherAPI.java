import java.net.*;
import java.io.*;

public class WeatherAPI {
	private String city;
	private String state;
	private String weatherForecast;

	public WeatherAPI() {
		city = "";
		state = "";
	}

	public String getDataFromURL(String queryURL) throws Exception {
		URL requestURL = new URL(queryURL);
		URLConnection connection = requestURL.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String response = "";
		String inputLine;
		while((inputLine = reader.readLine()) != null) {
			response += inputLine;
		}

		reader.close();
		System.out.println(response);
	}

	public String getLatitudeLongitude(String query) {
		return "";
	}
}