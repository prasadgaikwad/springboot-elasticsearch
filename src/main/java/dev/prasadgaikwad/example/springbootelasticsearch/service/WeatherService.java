package dev.prasadgaikwad.example.springbootelasticsearch.service;

import dev.prasadgaikwad.example.springbootelasticsearch.client.WeatherApiClient;
import dev.prasadgaikwad.example.springbootelasticsearch.model.Location;
import dev.prasadgaikwad.example.springbootelasticsearch.repository.WeatherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WeatherService {
    private WeatherApiClient weatherApiClient;
    private WeatherRepository weatherRepository;

    public WeatherService(WeatherApiClient weatherApiClient, WeatherRepository weatherRepository) {
        this.weatherApiClient = weatherApiClient;
        this.weatherRepository = weatherRepository;
    }

    public Location getWeather(String woeId) {
        log.info("Getting weather for location with woeId = {}", woeId);
        Location location = weatherApiClient.getLocationWeather(woeId);
        weatherRepository.save(location);
        log.info("Weather for location with woeId = {}, weather = {}", woeId, location);
        return location;
    }
}
