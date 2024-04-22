import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { WeatherService } from './weather.service';

describe('WeatherService', () => {
  let service: WeatherService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [WeatherService]
    });
    service = TestBed.inject(WeatherService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify(); // Ensure that there are no outstanding requests
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should handle client-side error', () => {
    const cityName = 'London';
    const errorMessage = 'Client-side error occurred';
    const mockErrorResponse = new ErrorEvent('Network error', {
      message: errorMessage
    });

    service.getWeather(cityName).subscribe(
      () => fail('expected an error, not data'),
      (error: string) => {
        expect(error).toContain(errorMessage);
      }
    );

    const req = httpTestingController.expectOne(`${service.baseUrl}/${cityName}`);
    req.error(mockErrorResponse);
  });

  it('should handle server-side error', () => {
    const cityName = 'Paris';
    const errorCode = 500;
    const errorMessage = 'Internal Server Error';

    service.getForecast(cityName).subscribe(
      () => fail('expected an error, not data'),
      (error: string) => {
        expect(error).toContain(`Error Code: ${errorCode}`);
        expect(error).toContain(`Message: ${errorMessage}`);
      }
    );

    const req = httpTestingController.expectOne(`${service.baseUrl}/forecast/${cityName}`);
    req.flush(errorMessage, { status: errorCode, statusText: 'Server Error' });
  });
});
