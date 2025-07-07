package com.meteo.model;

import java.util.List;

public record MeteoResponse(
	    Hourly hourly
	) {
	    public record Hourly(
	        List<String> time,
	        List<Double> temperature_2m,
	        List<Double> rain
	    ) {}
	}