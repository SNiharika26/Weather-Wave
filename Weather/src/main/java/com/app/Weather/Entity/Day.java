package com.app.Weather.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("datetime")
    private LocalDate date;
    @JsonProperty("tempmax")
    private double tempmax;

    @JsonProperty("tempmin")
    private double tempmin;

    @JsonProperty("temp")
    private double temp;

    @JsonProperty("feelslikemax")
    private double feelslikemax;

    @JsonProperty("feelslikemin")
    private double feelslikemin;

    @JsonProperty("feelslike")
    private double feelslike;

    @JsonProperty("dew")
    private double dew;

    @JsonProperty("humidity")
    private double humidity;
    @JsonProperty("precip")
    private double precip;
    @JsonProperty("preciptype")
    private List<String> precipType;

    @JsonProperty("snow")
    private double snow;

    @JsonProperty("windspeed")
    private double windSpeed;

    @JsonProperty("winddir")
    private int windDir;

    @JsonProperty("pressure")
    private double pressure;

    @JsonProperty("cloudcover")
    private double cloudCover;

    @JsonProperty("visibility")
    private double visibility;
    @JsonProperty("uvindex")
    private int uvIndex;

    @JsonProperty("sunrise")
    private String sunrise;

    @JsonProperty("sunset")
    private String sunset;


    @JsonProperty("conditions")
    private String conditions;

    @JsonProperty("description")
    private String description;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("hours")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hour> hours;
}
