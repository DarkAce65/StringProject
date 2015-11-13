import org.json.*;
import java.net.*;
import java.io.*;

public class WeatherObject {
	private WeatherLocation location;
	private String apiKey;
	private JSONObject weatherForecast;

	public WeatherObject() {
		setAPIKey();
		location = new WeatherLocation();
		weatherForecast = getDataFromURL("http://api.openweathermap.org/data/2.5/weather?lat=" + location.getLatitude() + "&lon=" + location.getLongitude() + "&appid=" + apiKey);
	}

	public WeatherObject(double lat, double lon) {
		setAPIKey();
		location = new WeatherLocation(lat, lon);
		weatherForecast = getDataFromURL("http://api.openweathermap.org/data/2.5/weather?lat=" + location.getLatitude() + "&lon=" + location.getLongitude() + "&appid=" + apiKey);
	}

	public void setAPIKey() {
		try {
			FileReader fileReader = new FileReader("APIKEY");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			apiKey = bufferedReader.readLine();
			bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open API key");
		}
		catch(IOException ex) {
			System.out.println("Error reading API key");
		}
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

	public WeatherLocation getLocation() {
		return location;
	}

	public JSONObject getWeatherForecast() {
		return weatherForecast;
	}

	public void updateWeatherForecast() {
		weatherForecast = getDataFromURL("http://api.openweathermap.org/data/2.5/weather?lat=" + location.getLatitude() + "&lon=" + location.getLongitude() + "&units=imperial&appid=" + apiKey);
	}

	public String toString() {
		System.out.println(weatherForecast.getJSONArray("weather"));
		return "It is " + weatherForecast.getJSONObject("main").getDouble("temp") + "°F in " + weatherForecast.getString("name") + ". There is currently ";
	}
}