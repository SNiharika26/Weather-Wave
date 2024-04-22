package com.app.Weather.Controller;

import com.app.Weather.Entity.Weather;
import com.app.Weather.Service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@CrossOrigin(origins = "*")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Operation(summary = "Get current weather", description = "Get the current weather for the specified city")
    @GetMapping("/{city}")
    public Weather getCurrentWeather(
            @Parameter(description = "City name") @PathVariable String city) {
        return weatherService.getWeatherData(city);
    }

    @Operation(summary = "Get historical weather", description = "Get the historical weather data for the specified city")
    @GetMapping("/history/{city}")
    public Weather getHistoricalWeather(
            @Parameter(description = "City name") @PathVariable String city) {
        return weatherService.getHistoryData(city);
    }

    @Operation(summary = "Get weather forecast", description = "Get the weather forecast for the specified city")
    @GetMapping("/forecast/{city}")
    public Weather getWeatherForecast(
            @Parameter(description = "City name") @PathVariable String city) {
        return weatherService.getWeatherForecast(city);
    }
}
