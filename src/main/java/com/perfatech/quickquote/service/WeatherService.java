package com.perfatech.quickquote.service;

import org.springframework.stereotype.Service;

@Service
public class WeatherService
{
    public String getWeatherForecast()
    {
        return "It's gonna snow!";
    }
}
