package com.app.Weather.Service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.app.Weather.Entity.Weather;
import com.app.Weather.Repo.WeatherRepo;
import com.app.Weather.WeatherServiceException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @Mock
    private WeatherRepo weatherRepo;

    @InjectMocks
    private WeatherService weatherService;


    @Test
    void testGetWeatherData() throws RestClientException {
        Weather weather = new Weather();
        weather.setAddress("42 Main St");
        weather.setDays(new ArrayList<>());
        weather.setDescription("The characteristics of someone or something");
        weather.setId(1L);
        weather.setLatitude(10.0f);
        weather.setLongitude(10.0f);
        weather.setQueryCost(1);
        weather.setTimezone("UTC");
        when(restTemplate.getForObject(any(String.class), eq(Weather.class))).thenReturn(weather);
        Weather actualWeatherData = weatherService.getWeatherData("Oxford");
        verify(restTemplate).getForObject(any(String.class), eq(Weather.class));
        verify(weatherRepo).save(weather); // Verify that save method is called on the repo
        assertSame(weather, actualWeatherData);
    }


    @Test
    void testGetWeatherData2() throws RestClientException {
        when(restTemplate.getForObject(any(String.class), eq(Weather.class)))
                .thenThrow(new WeatherServiceException("An error occurred"));
        assertThrows(WeatherServiceException.class, () -> weatherService.getWeatherData("Oxford"));
        verify(restTemplate).getForObject(any(String.class), eq(Weather.class));
    }


    @Test
    void testGetHistoryData() throws RestClientException {
        Weather weather = new Weather();
        weather.setAddress("42 Main St");
        weather.setDays(new ArrayList<>());
        weather.setDescription("The characteristics of someone or something");
        weather.setId(1L);
        weather.setLatitude(10.0f);
        weather.setLongitude(10.0f);
        weather.setQueryCost(1);
        weather.setTimezone("UTC");
        when(restTemplate.getForObject(any(String.class), eq(Weather.class))).thenReturn(weather);
        Weather actualHistoryData = weatherService.getHistoryData("Oxford");
        verify(restTemplate).getForObject(any(String.class), eq(Weather.class));
        verify(weatherRepo).save(weather); // Verify that save method is called on the repo
        assertSame(weather, actualHistoryData);
    }


    @Test
    void testGetHistoryData2() throws RestClientException {
        when(restTemplate.getForObject(any(String.class), eq(Weather.class)))
                .thenThrow(new WeatherServiceException("An error occurred"));
        assertThrows(WeatherServiceException.class, () -> weatherService.getHistoryData("Oxford"));
        verify(restTemplate).getForObject(any(String.class), eq(Weather.class));
    }


    @Test
    void testGetWeatherForecast() throws RestClientException {
        Weather weather = new Weather();
        weather.setAddress("42 Main St");
        weather.setDays(new ArrayList<>());
        weather.setDescription("The characteristics of someone or something");
        weather.setId(1L);
        weather.setLatitude(10.0f);
        weather.setLongitude(10.0f);
        weather.setQueryCost(1);
        weather.setTimezone("UTC");
        when(restTemplate.getForObject(any(String.class), eq(Weather.class))).thenReturn(weather);
        Weather actualWeatherForecast = weatherService.getWeatherForecast("Oxford");
        verify(restTemplate).getForObject(any(String.class), eq(Weather.class));
        verify(weatherRepo).save(weather); // Verify that save method is called on the repo
        assertSame(weather, actualWeatherForecast);
    }


    @Test
    void testGetWeatherForecast2() throws RestClientException {
        when(restTemplate.getForObject(any(String.class), eq(Weather.class)))
                .thenThrow(new WeatherServiceException("An error occurred"));
        assertThrows(WeatherServiceException.class, () -> weatherService.getWeatherForecast("Oxford"));
        verify(restTemplate).getForObject(any(String.class), eq(Weather.class));
    }
}
