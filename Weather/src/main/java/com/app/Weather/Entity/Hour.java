package com.app.Weather.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Hour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("datetime")
    private String datetime;

    @JsonProperty("temp")
    private float temp;

    @JsonProperty("feelslike")
    private float feelslike;

    @JsonProperty("humidity")
    private float humidity;

    @JsonProperty("dew")
    private float dew;

    @JsonProperty("precip")
    private float precip;

    @JsonProperty("snow")
    private float snow;

    @JsonProperty("windspeed")
    private float windSpeed;

    @JsonProperty("pressure")
    private float pressure;

    @JsonProperty("visibility")
    private float visibility;

    @JsonProperty("cloudcover")
    private float cloudCover;

    @JsonProperty("conditions")
    private String conditions;

    @JsonProperty("icon")
    private String icon;
}
