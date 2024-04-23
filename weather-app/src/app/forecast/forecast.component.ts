import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Weather } from '../weather.model';
import { WeatherService } from '../weather.service';
import { trigger, state, style, transition, animate } from '@angular/animations';

@Component({
  selector: 'app-forecast',
  templateUrl: './forecast.component.html',
  styleUrl: './forecast.component.css'
})
export class ForecastComponent {
  city: string = '';
  forecastData: Weather | null = null;

  constructor(private weatherService: WeatherService, private router: Router) { }

  getForecast() {
    this.weatherService.getForecast(this.city).subscribe((data: Weather) => {
      this.forecastData = data;
    });
  }

  // Navigation to home (weather component)
  navigateToHome() {
    this.router.navigate(['/weather']);
  }
}
