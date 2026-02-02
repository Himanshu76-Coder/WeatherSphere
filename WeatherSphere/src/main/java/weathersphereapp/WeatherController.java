package weathersphereapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// This servlet class handles the Weather Application logic.
@WebServlet("/weather")
public class WeatherController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Default constructor
    public WeatherController() {
        super();
    }

    // Handles GET requests (Not used for weather fetching, only for testing)
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// Handles POST requests. This method is called when user submits the city name.
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// OpenWeather API key
		String apiKey = "6d1ace1d9fb0ff6bed68b2eb59fe1331";
		
		// Read city name entered by user from form
		String cityName = request.getParameter("city");
		
		// Build OpenWeather API URL
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey;
		
		// Create URL object
		URL url = new URL(apiUrl);
		
		// Open HTTP connection
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		// Specify request type (GET)
		connection.setRequestMethod("GET");
		
		// Read data coming from API
		InputStream inputStream = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(inputStream);
		Scanner sc = new Scanner(reader);
		
		// Store API response JSON
		StringBuilder jsonResponse  = new StringBuilder();

		// Loop through the entire API response	
		while (sc.hasNext()) {
			jsonResponse.append(sc.nextLine());
		}
		
		// Close the scanner
		sc.close();
				
		// Convert JSON string into JsonObject
        Gson gson = new Gson();
        JsonObject weatherJson = gson.fromJson(jsonResponse.toString(), JsonObject.class);
		
		// Date & Time (Unix timestamp converted to readable date)
        long timestamp = weatherJson.get("dt").getAsLong() * 1000;
        String date = new Date(timestamp).toString();
        
        // Temperature (Kelvin → Celsius)
        double tempKelvin = weatherJson.getAsJsonObject("main").get("temp").getAsDouble();
        int tempCelsius = (int) (tempKelvin - 273.15);
       
        // Humidity
        int humidity = weatherJson.getAsJsonObject("main").get("humidity").getAsInt();
        
        // Wind speed
        double windSpeed = weatherJson.getAsJsonObject("wind").get("speed").getAsDouble();
        
        // Weather condition (Clear, Clouds, Rain, etc.)
        String weatherCondition = weatherJson.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
        
        // SEND DATA TO JSP
        request.setAttribute("city", cityName);
        request.setAttribute("date", date);
        request.setAttribute("temperature", tempCelsius);
        request.setAttribute("humidity", humidity);
        request.setAttribute("windSpeed", windSpeed);
        request.setAttribute("weatherCondition", weatherCondition);
        
        // Close API connection
        connection.disconnect();
        
        // Forward request to index.jsp for display
        request.getRequestDispatcher("weather.jsp").forward(request, response);

	}
}




