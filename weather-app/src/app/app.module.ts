import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WeatherComponent } from './weather/weather.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { WelcomeComponent } from './welcome/welcome.component';
import {MatInputModule} from '@angular/material/input';
import { CommonModule } from '@angular/common';
import {MatFormFieldModule} from '@angular/material/form-field';
import { BaseChartDirective } from 'ng2-charts';
import { CurrentWeatherComponent } from './current-weather/current-weather.component';
import { ForecastComponent } from './forecast/forecast.component';
import { HistoryComponent } from './history/history.component';
import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    WeatherComponent,
    WelcomeComponent,
    CurrentWeatherComponent,
    ForecastComponent,
    HistoryComponent

    


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    CommonModule,  
    MatAutocompleteModule,
    MatInputModule,
    MatFormFieldModule,
    BaseChartDirective,
    MatIconModule,
    BrowserAnimationsModule 
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
