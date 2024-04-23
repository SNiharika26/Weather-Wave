import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { Weather } from '../weather.model';
import { WeatherService } from '../weather.service';
import { HistoryComponent } from './history.component';
import { Router } from '@angular/router';

describe('HistoryComponent', () => {
  let component: HistoryComponent;
  let fixture: ComponentFixture<HistoryComponent>;
  let weatherServiceSpy: jasmine.SpyObj<WeatherService>;
  let routerSpy: jasmine.SpyObj<Router>;

  beforeEach(async () => {
    const spy = jasmine.createSpyObj('WeatherService', ['getHistory']);
    const routerSpyObj = jasmine.createSpyObj('Router', ['navigate']); // Create a spy for the Router service

    await TestBed.configureTestingModule({
      declarations: [HistoryComponent],
      imports: [RouterTestingModule.withRoutes([])], // Import RouterTestingModule here
      providers: [
        { provide: WeatherService, useValue: spy },
        { provide: Router, useValue: routerSpyObj } // Provide the spy Router service
      ]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    weatherServiceSpy = TestBed.inject(WeatherService) as jasmine.SpyObj<WeatherService>;
    routerSpy = TestBed.inject(Router) as jasmine.SpyObj<Router>;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should fetch history data', () => {
    // Set up the mock data
    const mockHistory: Weather = {
      days: [],
      description: 'The history data for the city',
      id: 1,
      latitude: 10.0,
      longitude: 10.0,
      queryCost: 1,
      timezone: 'UTC',
      address: ''
    };
    
    // Set up the spy to return the mock data
    weatherServiceSpy.getHistory.and.returnValue(of(mockHistory));
  
    // Set the city in the component
    component.city = 'New York';
  
    // Call the method to fetch history data
    component.getHistory();
  
    // Check if the history data in the component matches the mock data
    expect(component.historyData).toEqual(mockHistory);
  });
  
  it('should navigate to home page', () => {
    component.navigateToHome();

    expect(routerSpy.navigate).toHaveBeenCalledWith(['/weather']); // Use routerSpy.navigate instead of component.router.navigate
  });

});
