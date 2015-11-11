import org.json.*;
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

	public static JSONObject getDataFromURL(String queryURL) {
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

	public String getLatitudeLongitude(String query) {
		return "";
	}

	public static void main(String[] args) {
		System.out.println(getDataFromURL("http://taha.vasowalla.com/PeriodicTable.json").toString());
	}
}