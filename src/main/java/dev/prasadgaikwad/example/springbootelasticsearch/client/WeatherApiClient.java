package dev.prasadgaikwad.example.springbootelasticsearch.client;

import dev.prasadgaikwad.example.springbootelasticsearch.model.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class WeatherApiClient {
    @Value("${source.weather_api}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public WeatherApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Location getLocationWeather(String woeId) {
        Location location = restTemplate.getForObject(apiUrl + woeId, Location.class);
        assert location != null;
        log.info(location.toString());
        return location;
    }
}
