package com.meteo.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CityService {
    public Map<String, String> getCityCoordinates() {
        return Map.of(
            "torino", "45.0705,7.6868",
            "milano", "45.4642,9.1900",
            "roma", "41.9028,12.4964",
            "napoli", "40.8522,14.2681",
            "bucarest", "44.4268,26.1025",
            "parigi", "48.8566,2.3522",
            "londra", "51.5072,-0.1276",
            "berlino", "52.52,13.4050"
        );
    }
}