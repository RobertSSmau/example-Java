package com.meteo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.meteo.model.MeteoResponse;

@Service
public class MeteoService {

    private final WebClient webClient = WebClient.create("https://api.open-meteo.com/v1/forecast");
    private final CityService cityService;

    public MeteoService(CityService cityService) {
        this.cityService = cityService;
    }

    public Map<String, Object> getMeteoForCity(String city) {
        Map<String, String> coords = cityService.getCityCoordinates();
        if (!coords.containsKey(city.toLowerCase())) throw new IllegalArgumentException("Città non supportata");

        String[] latlon = coords.get(city.toLowerCase()).split(",");

        String uri = String.format("?latitude=%s&longitude=%s&hourly=temperature_2m,rain&timezone=auto",
                latlon[0], latlon[1]);

        MeteoResponse response = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(MeteoResponse.class)
                .block();

        Map<String, Object> result = new HashMap<>();
        result.put("city", city);
        result.put("hours", response.hourly().time());
        result.put("temperature", response.hourly().temperature_2m());
        result.put("rain", response.hourly().rain());

        return result;
    }
}
