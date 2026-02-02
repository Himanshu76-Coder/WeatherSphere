<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Weather Report</title>

    <!-- External CSS -->
    <link rel="stylesheet" href="style.css">

    <!-- Font Awesome icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>

<body>

    <!-- Main container for weather information -->
    <div class="mainContainer">

        <!-- Search form (POST request to servlet) -->
        <form action="weather" method="post" class="searchInput">

            <!-- City input field -->
            <input type="text"
                   name="city"
                   placeholder="Enter City Name"
                   value="${city != null ? city : 'New Delhi'}"
                   required>

            <!-- Search button -->
            <button type="submit">
                <i class="fa-solid fa-magnifying-glass"></i>
            </button>

        </form>

        <!-- Weather details section -->
        <div class="weatherDetails">

            <!-- Weather icon and temperature -->
            <div class="weatherIcon">

                <!-- Icon updated using JavaScript -->
                <img src="" alt="Weather Icon" id="weather-icon">

                <!-- Temperature value from servlet -->
                <h2>${temperature} °C</h2>

                <!-- Hidden field to pass weather condition to JavaScript -->
                <input type="hidden"
                       id="wc"
                       value="${weatherCondition}">
            </div>

            <!-- City name and date -->
            <div class="cityDetails">
                <div class="desc">
                    <strong>${city}</strong>
                </div>
                <div class="date">${date}</div>
            </div>

            <!-- Wind and humidity details -->
            <div class="windDetails">

                <!-- Humidity section -->
                <div class="humidityBox">
                    <img src="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhgr7XehXJkOPXbZr8xL42sZEFYlS-1fQcvUMsS2HrrV8pcj3GDFaYmYmeb3vXfMrjGXpViEDVfvLcqI7pJ03pKb_9ldQm-Cj9SlGW2Op8rxArgIhlD6oSLGQQKH9IqH1urPpQ4EAMCs3KOwbzLu57FDKv01PioBJBdR6pqlaxZTJr3HwxOUlFhC9EFyw/s320/thermometer.png"
                         alt="Humidity Icon">

                    <div class="humidity">
                        <span>Humidity</span>
                        <h2>${humidity}%</h2>
                    </div>
                </div>

                <!-- Wind speed section -->
                <div class="windSpeed">
                    <img src="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiyaIguDPkbBMnUDQkGp3wLRj_kvd_GIQ4RHQar7a32mUGtwg3wHLIe0ejKqryX8dnJu-gqU6CBnDo47O7BlzCMCwRbB7u0Pj0CbtGwtyhd8Y8cgEMaSuZKrw5-62etXwo7UoY509umLmndsRmEqqO0FKocqTqjzHvJFC2AEEYjUax9tc1JMWxIWAQR4g/s320/wind.png"
                         alt="Wind Icon">

                    <div class="wind">
                        <span>Wind Speed</span>
                        <h2>${windSpeed} km/h</h2>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <!-- JavaScript for changing weather icons -->
    <script src="weather-icons.js"></script>

</body>
</html>
