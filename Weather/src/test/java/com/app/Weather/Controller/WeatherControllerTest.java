package com.app.Weather.Controller;

import static org.mockito.Mockito.when;

import com.app.Weather.Entity.Weather;
import com.app.Weather.Service.WeatherService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {WeatherController.class})
@ExtendWith(SpringExtension.class)
class WeatherControllerTest {
    @Autowired
    private WeatherController weatherController;

    @MockBean
    private WeatherService weatherService;

    @Test
    void testGetCurrentWeather() throws Exception {
        Weather weather = new Weather();
        weather.setAddress("42 Main St");
        weather.setDays(new ArrayList<>());
        weather.setDescription("The characteristics of someone or something");
        weather.setId(1L);
        weather.setLatitude(10.0f);
        weather.setLongitude(10.0f);
        weather.setQueryCost(1);
        weather.setTimezone("UTC");
        when(weatherService.getWeatherData(Mockito.<String>any())).thenReturn(weather);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/weather/{city}", "Oxford");
        MockMvcBuilders.standaloneSetup(weatherController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"queryCost\":1,\"latitude\":10.0,\"longitude\":10.0,\"address\":\"42 Main St\",\"timezone\":\"UTC\","
                                        + "\"description\":\"The characteristics of someone or something\",\"days\":[]}"));
    }

    @Test
    void testGetWeatherForecast() throws Exception {
        Weather weather = new Weather();
        weather.setAddress("42 Main St");
        weather.setDays(new ArrayList<>());
        weather.setDescription("The characteristics of someone or something");
        weather.setId(1L);
        weather.setLatitude(10.0f);
        weather.setLongitude(10.0f);
        weather.setQueryCost(1);
        weather.setTimezone("UTC");
        when(weatherService.getWeatherForecast(Mockito.<String>any())).thenReturn(weather);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/weather/forecast/{city}", "Oxford");
        MockMvcBuilders.standaloneSetup(weatherController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"queryCost\":1,\"latitude\":10.0,\"longitude\":10.0,\"address\":\"42 Main St\",\"timezone\":\"UTC\","
                                        + "\"description\":\"The characteristics of someone or something\",\"days\":[]}"));
    }

    @Test
    void testGetHistoricalWeather() throws Exception {
        Weather weather = new Weather();
        weather.setAddress("42 Main St");
        weather.setDays(new ArrayList<>());
        weather.setDescription("The characteristics of someone or something");
        weather.setId(1L);
        weather.setLatitude(10.0f);
        weather.setLongitude(10.0f);
        weather.setQueryCost(1);
        weather.setTimezone("UTC");
        when(weatherService.getHistoryData(Mockito.<String>any())).thenReturn(weather);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/weather/history/{city}", "Oxford");
        MockMvcBuilders.standaloneSetup(weatherController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"queryCost\":1,\"latitude\":10.0,\"longitude\":10.0,\"address\":\"42 Main St\",\"timezone\":\"UTC\","
                                        + "\"description\":\"The characteristics of someone or something\",\"days\":[]}"));
    }

    @Test
    void testGetCurrentWeather_WhenServiceThrowsException() throws Exception {
        when(weatherService.getWeatherData(Mockito.<String>any())).thenThrow(new RuntimeException("Service exception"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/weather/{city}", "Oxford");
        MockMvcBuilders.standaloneSetup(weatherController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void testGetWeatherForecast_WhenServiceThrowsException() throws Exception {
        when(weatherService.getWeatherForecast(Mockito.<String>any())).thenThrow(new RuntimeException("Service exception"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/weather/forecast/{city}", "Oxford");
        MockMvcBuilders.standaloneSetup(weatherController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    void testGetHistoricalWeather_WhenServiceThrowsException() throws Exception {
        when(weatherService.getHistoryData(Mockito.<String>any())).thenThrow(new RuntimeException("Service exception"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/weather/history/{city}", "Oxford");
        MockMvcBuilders.standaloneSetup(weatherController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}
