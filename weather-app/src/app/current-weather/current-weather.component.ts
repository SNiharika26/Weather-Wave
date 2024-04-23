import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Weather } from '../weather.model';
import { WeatherService } from '../weather.service';

@Component({
  selector: 'app-current-weather',
  templateUrl: './current-weather.component.html',
  styleUrl: './current-weather.component.css'
})
export class CurrentWeatherComponent implements OnInit {
  city: string = '';
  weatherData: Weather | null = null;
  showAllData: boolean = false; 
  favoriteLocation: string | null = null

  constructor(private weatherService: WeatherService, private router: Router) { }

  ngOnInit() {
    // Load favorite location from local storage on initialization
    this.favoriteLocation = localStorage.getItem('favoriteLocation');
    if (this.favoriteLocation) {
      // Fetch weather data for the favorite location
      this.getWeatherData(this.favoriteLocation);
    }
  }

  getCurrentWeather() {
    this.weatherService.getWeather(this.city).subscribe((data: Weather) => {
      this.weatherData = data;
    });
  }
  getWeatherData(city: string) {
    this.weatherService.getWeather(city).subscribe((data: Weather) => {
      this.weatherData = data;
      this.city = city; // Update the current city
    });
  }

  // Save favorite location
  saveFavoriteLocation() {
    if (this.city) {
      localStorage.setItem('favoriteLocation', this.city);
      alert(`Saved ${this.city} as favorite location!`);
    }
  }


  // Navigation to home page
  navigateToHome() {
    this.router.navigate(['weather']);
  }
  toggleShowAllData() {
    this.showAllData = !this.showAllData;
  }
}
