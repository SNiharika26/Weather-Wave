package com.app.Weather.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Entity
@Data
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int queryCost;
    private float latitude;
    private float longitude;
    private String address;
    private String timezone;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("days")
    private List<Day> days;
}
