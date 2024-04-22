package com.app.Weather.Repo;

import com.app.Weather.Entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepo extends JpaRepository<Weather,Long> {
}
