package dev.prasadgaikwad.example.springbootelasticsearch.controller;

import dev.prasadgaikwad.example.springbootelasticsearch.model.Location;
import dev.prasadgaikwad.example.springbootelasticsearch.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public Location getWeather(@RequestParam(value = "locationId", defaultValue = "44418") String locationId) {
        return weatherService.getWeather(locationId);
    }
}
