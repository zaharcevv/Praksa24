package com.praksa.test.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getWeatherForCity(String city) {
        String apiKey = "f5bb6c99e18be72006a0b3d308e12c6d"; // Replace with your API key
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";

        // Fetch the full response
        Map<String, Object> fullResponse = restTemplate.getForObject(url, Map.class);

        // Extract temp and humidity
        Map<String, Object> mainData = (Map<String, Object>) fullResponse.get("main");

        Map<String, Object> filteredData = new HashMap<>();
        filteredData.put("temp", mainData.get("temp"));
        filteredData.put("humidity", mainData.get("humidity"));

        return filteredData;
    }
}
