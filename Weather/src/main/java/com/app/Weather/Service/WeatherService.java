package com.app.Weather.Service;

import com.app.Weather.Entity.Weather;
import com.app.Weather.Repo.WeatherRepo;
import com.app.Weather.WeatherServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class WeatherService {

    @Value("${visualcrossing.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final WeatherRepo weatherRepo;

    public WeatherService(RestTemplate restTemplate,WeatherRepo weatherRepo) {
        this.restTemplate = restTemplate;
        this.weatherRepo = weatherRepo;
    }

    public Weather getWeatherData(String city) {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = today.format(dateFormatter);
        String url = String.format("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s/%s?key=%s",
                city, formattedDate, apiKey);

        try {
            Weather weather = restTemplate.getForObject(url, Weather.class);
            // Save the weather data in the repository
            weatherRepo.save(weather);
            return weather;
        } catch (HttpClientErrorException.NotFound e) {
            throw new WeatherServiceException("City not found", e);
        } catch (HttpClientErrorException.BadRequest e) {
            throw new WeatherServiceException("Invalid city name or request", e);
        } catch (HttpClientErrorException.Unauthorized e) {
            throw new WeatherServiceException("Invalid API key", e);
        } catch (HttpClientErrorException e) {
            throw new WeatherServiceException("Client error occurred while fetching weather data", e);
        } catch (Exception e) {
            throw new WeatherServiceException("An unexpected error occurred", e);
        }
    }

    public Weather getHistoryData(String city) {
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.minusDays(30);
        LocalDate endDate = today.minusDays(1);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedStartDate = startDate.format(dateFormatter);
        String formattedEndDate = endDate.format(dateFormatter);
        String url = String.format(
                "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s/%s/%s?key=%s&include=days",
                city, formattedStartDate, formattedEndDate, apiKey
        );

        try {
            Weather weather = restTemplate.getForObject(url, Weather.class);
            // Save the weather data in the repository
            weatherRepo.save(weather);
            return weather;
        } catch (HttpClientErrorException.NotFound e) {
            throw new WeatherServiceException("City not found", e);
        } catch (HttpClientErrorException.BadRequest e) {
            throw new WeatherServiceException("Invalid city name or request", e);
        } catch (HttpClientErrorException.Unauthorized e) {
            throw new WeatherServiceException("Invalid API key", e);
        } catch (HttpClientErrorException e) {
            throw new WeatherServiceException("Client error occurred while fetching weather data", e);
        } catch (Exception e) {
            throw new WeatherServiceException("An unexpected error occurred", e);
        }
    }

    public Weather getWeatherForecast(String city) {
        String url = String.format(
                "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/%s?key=%s&include=days",
                city, apiKey
        );

        try {
            Weather weather = restTemplate.getForObject(url, Weather.class);
            // Save the weather data in the repository
            weatherRepo.save(weather);
            return weather;
        } catch (HttpClientErrorException.NotFound e) {
            throw new WeatherServiceException("City not found", e);
        } catch (HttpClientErrorException.BadRequest e) {
            throw new WeatherServiceException("Invalid city name or request", e);
        } catch (HttpClientErrorException.Unauthorized e) {
            throw new WeatherServiceException("Invalid API key", e);
        } catch (HttpClientErrorException e) {
            throw new WeatherServiceException("Client error occurred while fetching weather data", e);
        } catch (Exception e) {
            throw new WeatherServiceException("An unexpected error occurred", e);
        }
    }
}
