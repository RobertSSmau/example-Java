package com.meteo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meteo.service.MeteoService;

@RestController
public class MeteoController {

    private final MeteoService meteoService;

    // Costruttore manuale per l'iniezione
    public MeteoController(MeteoService meteoService) {
        this.meteoService = meteoService;
    }

    @GetMapping("/meteo")
    public ResponseEntity<Map<String, Object>> getMeteo(@RequestParam String city) {
        return ResponseEntity.ok(meteoService.getMeteoForCity(city));
    }
}