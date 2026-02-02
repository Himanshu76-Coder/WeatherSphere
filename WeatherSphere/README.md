# WeatherSphere 🌤️

A **Dynamic Web Project** - A modern, responsive web application that provides real-time weather information for cities worldwide. Built with Java servlets and powered by the OpenWeatherMap API.

## 🚀 Features

- **Real-time Weather Data**: Get current weather conditions for any city
- **Responsive Design**: Clean, modern UI that works on all devices  
- **Dynamic Weather Icons**: Visual weather representations that change based on conditions
- **Comprehensive Weather Info**: Temperature, humidity, wind speed, and weather conditions
- **User-friendly Interface**: Simple search functionality with intuitive design

## 🛠️ Technologies Used

### Backend
- **Java 17** - Core programming language
- **Jakarta Servlets** - Web application framework
- **Apache Tomcat 10.1** - Application server
- **Gson 2.8.5** - JSON parsing library
- **OpenWeatherMap API** - Weather data provider

### Frontend
- **HTML5** - Structure and markup
- **CSS3** - Styling and responsive design
- **JavaScript (ES6)** - Dynamic weather icons and interactivity
- **JSP (JavaServer Pages)** - Dynamic content rendering
- **Font Awesome 6.4.0** - Icons and visual elements

### Development Environment
- **Eclipse IDE** - Development environment
- **Dynamic Web Project** - Eclipse project type for web applications
- **Maven-style project structure** - Project organization

## 📁 Project Structure

```
WeatherSphere/
├── src/main/
│   ├── java/weathersphereapp/
│   │   └── WeatherController.java     # Main servlet 
│   │
│   └── webapp/
│       ├── Images/
│       │   └── weather-logo.png       # Application logo
│       ├── WEB-INF/
│       │   ├── lib/
│       │   │   └── gson-2.8.5.jar     # JSON processing 
│       │   │
│       │   └── web.xml                # Web application 
│       │
│       ├── index.html                 # Landing page
│       ├── weather.jsp                # Weather results page
│       ├── style.css                  # Application styling
│       └── weather-icons.js           # Dynamic weather 
│
└── README.md                          # Project 
```

## 🔧 How It Works

### Application Flow

1. **User Input**: User enters a city name on the landing page (`index.html`)
2. **Request Processing**: Form submission triggers a POST request to the `WeatherController` servlet
3. **API Integration**: Servlet makes HTTP request to OpenWeatherMap API
4. **Data Processing**: JSON response is parsed and weather data is extracted
5. **Data Transformation**: Temperature converted from Kelvin to Celsius, timestamps formatted
6. **Response Generation**: Processed data is forwarded to `weather.jsp` for display
7. **Dynamic UI**: JavaScript updates weather icons based on current conditions

### Key Components

#### WeatherController Servlet
- Handles HTTP POST requests from the weather search form
- Integrates with OpenWeatherMap API using HTTP connections
- Processes JSON responses using Gson library
- Converts temperature units and formats timestamps
- Forwards processed data to JSP for rendering

#### Frontend Interface
- **Landing Page**: Clean welcome interface with city search functionality
- **Results Page**: Comprehensive weather display with dynamic icons
- **Responsive Design**: Gradient backgrounds and modern card-based layout
- **Interactive Elements**: Hover effects and smooth transitions

#### Weather Icon System
- JavaScript-based dynamic icon switching
- Condition-based image selection (Clear, Clouds, Rain, Mist, Snow)
- External CDN-hosted weather icons for optimal performance

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Apache Tomcat 10.1 or compatible servlet container
- Internet connection for API calls
- Modern web browser

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd WeatherSphere
   ```

2. **Configure API Key**
   - Open `src/main/java/weathersphereapp/WeatherController.java`
   - Replace the API key with your OpenWeatherMap API key:
   ```java
   String apiKey = "YOUR_API_KEY_HERE";
   ```

3. **Deploy to Tomcat**
   - Import as Dynamic Web Project into Eclipse IDE
   - Configure Tomcat server in Eclipse
   - Deploy the application to Tomcat

4. **Access the Application**
   - Open browser and navigate to: `http://localhost:8080/WeatherSphere`

### API Configuration

Get your free API key from [OpenWeatherMap](https://openweathermap.org/api):
1. Create an account at OpenWeatherMap
2. Generate an API key
3. Replace the placeholder in `WeatherController.java`

## 🌐 API Integration

The application integrates with the OpenWeatherMap Current Weather Data API:
- **Endpoint**: `https://api.openweathermap.org/data/2.5/weather`
- **Parameters**: City name and API key
- **Response Format**: JSON with weather data
- **Data Retrieved**: Temperature, humidity, wind speed, weather conditions, timestamps

## 🎨 UI/UX Features

- **Modern Design**: Clean, card-based interface with gradient backgrounds
- **Responsive Layout**: Optimized for desktop and mobile devices
- **Visual Feedback**: Hover effects and smooth transitions
- **Intuitive Navigation**: Simple search-to-results workflow
- **Weather Visualization**: Dynamic icons representing current conditions

## 🔒 Security Considerations

- Input validation for city names
- Secure HTTP connections for API calls
- Proper error handling for invalid requests
- No sensitive data stored in client-side code

## 📱 Browser Compatibility

- Chrome 90+
- Firefox 88+
- Safari 14+
- Edge 90+

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


## 🙏 Acknowledgments

- [OpenWeatherMap](https://openweathermap.org/) for providing weather data API
- [Font Awesome](https://fontawesome.com/) for icons
- Weather icons from various CDN sources
- Eclipse IDE and Apache Tomcat communities

---

**WeatherSphere** - Your gateway to real-time weather information 🌍