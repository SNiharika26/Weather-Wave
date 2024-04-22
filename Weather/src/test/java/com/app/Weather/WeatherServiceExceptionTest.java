package com.app.Weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class WeatherServiceExceptionTest {
    /**
     * Method under test:
     * {@link WeatherServiceException#WeatherServiceException(String)}
     */
    @Test
    void testConstructor() {
        WeatherServiceException actualWeatherServiceException = new WeatherServiceException("An error occurred");
        assertEquals("An error occurred", actualWeatherServiceException.getLocalizedMessage());
        assertEquals("An error occurred", actualWeatherServiceException.getMessage());
        assertNull(actualWeatherServiceException.getCause());
        assertEquals(0, actualWeatherServiceException.getSuppressed().length);
    }

    /**
     * Method under test:
     * {@link WeatherServiceException#WeatherServiceException(String, Throwable)}
     */
    @Test
    void testConstructor2() {
        Throwable cause = new Throwable();
        WeatherServiceException actualWeatherServiceException = new WeatherServiceException("An error occurred", cause);

        assertEquals("An error occurred", actualWeatherServiceException.getLocalizedMessage());
        assertEquals("An error occurred", actualWeatherServiceException.getMessage());
        Throwable cause2 = actualWeatherServiceException.getCause();
        assertNull(cause2.getLocalizedMessage());
        assertNull(cause2.getMessage());
        assertNull(cause2.getCause());
        Throwable[] suppressed = actualWeatherServiceException.getSuppressed();
        assertEquals(0, suppressed.length);
        assertSame(cause, cause2);
        assertSame(suppressed, cause2.getSuppressed());
    }
}
