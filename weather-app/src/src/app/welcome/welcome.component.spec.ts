import { ComponentFixture, TestBed } from '@angular/core/testing';
import { WelcomeComponent } from './welcome.component';
import { Router, RouterModule } from '@angular/router';


describe('WelcomeComponent', () => {
  let component: WelcomeComponent;
  let fixture: ComponentFixture<WelcomeComponent>;
  let router: Router;
  
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [WelcomeComponent],
      imports: [RouterModule.forRoot([])]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WelcomeComponent);
    component = fixture.componentInstance;
    router = TestBed.inject(Router);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should navigate to weather', () => {
    const navigateSpy = spyOn(router, 'navigate');

    component.navigateToWeather();

    expect(navigateSpy).toHaveBeenCalledWith(['/weather']);
  });

  it('should create snowflakes', () => {
    component.createSnowflakes();

    expect(component.snowflakes.length).toBe(50); // Check if snowflakes are created
  });
});
