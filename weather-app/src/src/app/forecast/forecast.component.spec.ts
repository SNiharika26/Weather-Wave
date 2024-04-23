import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { Weather } from '../weather.model';
import { WeatherService } from '../weather.service';
import { ForecastComponent } from './forecast.component';
import { Router } from '@angular/router';

describe('ForecastComponent', () => {
  let component: ForecastComponent;
  let fixture: ComponentFixture<ForecastComponent>;
  let weatherServiceSpy: jasmine.SpyObj<WeatherService>;
  let routerSpy: jasmine.SpyObj<Router>;

  beforeEach(async () => {
    const spy = jasmine.createSpyObj('WeatherService', ['getForecast']);
    const routerSpyObj = jasmine.createSpyObj('Router', ['navigate']); // Create a spy for the Router service

    await TestBed.configureTestingModule({
      declarations: [ForecastComponent],
      imports: [RouterTestingModule.withRoutes([])], // Import RouterTestingModule here
      providers: [
        { provide: WeatherService, useValue: spy },
        { provide: Router, useValue: routerSpyObj } // Provide the spy Router service
      ]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ForecastComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    weatherServiceSpy = TestBed.inject(WeatherService) as jasmine.SpyObj<WeatherService>;
    routerSpy = TestBed.inject(Router) as jasmine.SpyObj<Router>;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should fetch forecast data', () => {
    // Set up the mock data
    const mockForecast: Weather = {
      days: [],
      description: 'The forecast data for the city',
      id: 1,
      latitude: 10.0,
      longitude: 10.0,
      queryCost: 1,
      timezone: 'UTC',
      address: ''
    };
    
    // Set up the spy to return the mock data
    weatherServiceSpy.getForecast.and.returnValue(of(mockForecast));
  
    // Set the city in the component
    component.city = 'Paris';
  
    // Call the method to fetch forecast data
    component.getForecast();
  
    // Check if the forecast data in the component matches the mock data
    expect(component.forecastData).toEqual(mockForecast);
  });
  
  it('should navigate to home page', () => {
    component.navigateToHome();

    expect(routerSpy.navigate).toHaveBeenCalledWith(['/weather']); // Use routerSpy.navigate instead of component.router.navigate
  });

});
