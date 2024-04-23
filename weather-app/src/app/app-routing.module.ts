import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WeatherComponent } from './weather/weather.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { CurrentWeatherComponent } from './current-weather/current-weather.component';
import { ForecastComponent } from './forecast/forecast.component';
import { HistoryComponent } from './history/history.component';

const routes: Routes = [
  {
    path: '',component: WelcomeComponent
},
{ path: 'weather', component: WeatherComponent },
// Define a route for the weather component
{ path: 'current-weather', component: CurrentWeatherComponent },
{ path: 'forecast', component: ForecastComponent },
{ path: 'history', component: HistoryComponent },
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
