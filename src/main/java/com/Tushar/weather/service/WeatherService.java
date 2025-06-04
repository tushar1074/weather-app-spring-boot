package com.Tushar.weather.service;

import com.Tushar.weather.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse getWeatherByCity(String city) {
        String url = String.format("%s?q=%s&appid=%s&units=metric", apiUrl, city, apiKey);
        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}
