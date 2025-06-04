package com.Tushar.weather.controller;

import com.Tushar.weather.dto.WeatherResponse;
import com.Tushar.weather.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home() {
        return "weather";
    }

    @PostMapping("/get-weather")
    public String getWeather(@RequestParam String city, Model model) {
        WeatherResponse response = weatherService.getWeatherByCity(city);
        model.addAttribute("weather", response);
        return "weather";
    }
}
