import org.json.*;
import java.net.*;
import java.io.*;

public class WeatherObject {
	private WeatherLocation location;
	private String weatherForecast;

	public WeatherObject() {
		location = new WeatherLocation();
		weatherForecast = "";
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

	public String getWeatherForecast() {
		JSONObject response = getDataFromURL();
		return "";
	}
}