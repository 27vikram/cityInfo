package com.cityinfo.mycity;

public class CityInfoResponse {
	Double Temperature;
	Double PollutionLevel;
	Long Population;
	String Airport;
	
	public Double getTemperature() {
		return Temperature;
	}
	public void setTemperature(Double temperature) {
		Temperature = temperature;
	}
	public Double getPollutionLevel() {
		return PollutionLevel;
	}
	public void setPollutionLevel(Double pollutionLevel) {
		PollutionLevel = pollutionLevel;
	}
	public Long getPopulation() {
		return Population;
	}
	public void setPopulation(Long population) {
		Population = population;
	}
	public String getAirport() {
		return Airport;
	}
	public void setAirport(String airport) {
		Airport = airport;
	}

	

}
