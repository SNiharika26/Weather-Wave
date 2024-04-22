export interface Weather {
    id: number;
    queryCost: number;
    latitude: number;
    longitude: number;
    address: string;
    timezone: string;
    description: string;
    days: Day[];
  }
  
  export interface Day {
    date: string;
    datetime: string; 
    tempmax: number;
    tempmin: number;
    temp: number;
    feelslikemax: number;
    feelslikemin: number;
    feelslike: number;
    dew: number;
    humidity: number;
    precip: number;
    snow: number;
    windspeed: number;
    windDir: number;
    pressure: number;
    cloudcover: number;
    visibility: number;
    uvindex: number;
    sunrise: string;
    sunset: string;
    conditions: string;
    description: string;
    icon: string;
    hours: Hour[];
  }
  
  export interface Hour {
    datetime: string;
    temp: number;
    feelslike: number;
    humidity: number;
    dew: number;
    precip: number;
    snow: number;
    windspeed: number;
    pressure: number;
    visibility: number;
    cloudcover: number;
    conditions: string;
  
  }
  