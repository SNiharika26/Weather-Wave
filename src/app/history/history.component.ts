import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Weather } from '../weather.model';
import { WeatherService } from '../weather.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrl: './history.component.css'
})
export class HistoryComponent {
  city: string = '';
  historyData: Weather | null = null;

  constructor(private weatherService: WeatherService, private router: Router) { }

  getHistory() {
    this.weatherService.getHistory(this.city).subscribe((data: Weather) => {
      this.historyData = data;
    });
  }

  // Navigation to home (weather component)
  navigateToHome() {
    this.router.navigate(['/weather']);
  }
}
