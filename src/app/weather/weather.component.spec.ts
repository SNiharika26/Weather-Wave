import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Router, RouterModule } from '@angular/router';
import { WeatherComponent } from './weather.component';

describe('WeatherComponent', () => {
  let component: WeatherComponent;
  let fixture: ComponentFixture<WeatherComponent>;
  let router:Router;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [WeatherComponent],
      imports: [RouterModule.forRoot([])]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WeatherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    router=TestBed.inject(Router)
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('navigateToCurrentWeather should navigate to "/current-weather"', () => {
    const navigateSpy = spyOn(router, 'navigate');
    component.navigateToCurrentWeather();
    expect(navigateSpy).toHaveBeenCalledWith(['/current-weather']);
  });

  it('navigateToForecast should navigate to "/forecast"', () => {
    const navigateSpy = spyOn(router, 'navigate');
    component.navigateToForecast();
    expect(navigateSpy).toHaveBeenCalledWith(['/forecast']);
  });

  it('navigateToHistory should navigate to "/history"', () => {
    const navigateSpy = spyOn(router, 'navigate');
    component.navigateToHistory();
    expect(navigateSpy).toHaveBeenCalledWith(['/history']);
  });
});
