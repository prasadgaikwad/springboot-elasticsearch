package dev.prasadgaikwad.example.springbootelasticsearch.repository;

import dev.prasadgaikwad.example.springbootelasticsearch.model.Location;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface WeatherRepository extends ElasticsearchRepository<Location, String> {
}
