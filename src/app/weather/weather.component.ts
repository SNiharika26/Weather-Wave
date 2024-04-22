import { Component, ViewEncapsulation } from '@angular/core';
import { Weather } from '../weather.model';
import { WeatherService } from '../weather.service';
import { Observable } from 'rxjs/internal/Observable';
import { Router } from '@angular/router';

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrl: './weather.component.css',
  // encapsulation: ViewEncapsulation.None 
})
export class WeatherComponent {
  constructor(private router: Router) {}

  // Navigation to current weather, forecast, and history
  navigateToCurrentWeather() {
    this.router.navigate(['/current-weather']);
  }

  navigateToForecast() {
    this.router.navigate(['/forecast']);
  }

  navigateToHistory() {
    this.router.navigate(['/history']);
  }
}
