import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Weather } from './weather.model';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
   baseUrl = 'http://localhost:8080/weather';

  constructor(private http: HttpClient) {}

  getWeather(city: string): Observable<Weather> {
    return this.http.get<Weather>(`${this.baseUrl}/${city}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  getForecast(city: string): Observable<Weather> {
    return this.http.get<Weather>(`${this.baseUrl}/forecast/${city}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  getHistory(city: string): Observable<Weather> {
    return this.http.get<Weather>(`${this.baseUrl}/history/${city}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'An error occurred';
    if (error.error instanceof ErrorEvent) {
      // Client-side error
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }
}
