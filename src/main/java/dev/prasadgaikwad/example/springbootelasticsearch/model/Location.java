package dev.prasadgaikwad.example.springbootelasticsearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.time.Instant;

@Data
@ToString
@Document(indexName = "weather-v1")
@TypeAlias(value = "LocationWeather")
public class Location extends BaseModel {
    @Id
    private String id;
    private String title;
    @JsonProperty(value = "location_type")
    @Field(value = "location_type")
    private String locationType;
    @JsonProperty(value = "woeid")
    @Field(value = "woeid")
    private String woeId;
    @JsonProperty(value = "latt_long")
    @Field(value = "latt_long")
    private String lattLong;
    private String timezone;
    @JsonProperty(value = "timezone_name")
    @Field(value = "timezone_name")
    private String timezoneName;
    @JsonProperty(value = "sun_set")
    @Field(value = "sun_set")
    private Instant sunSet;
    @JsonProperty(value = "sun_rise")
    @Field(value = "sun_rise")
    private Instant sunRise;
    private Instant time;
    private Location parent;
}
