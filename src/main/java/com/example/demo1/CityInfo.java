package com.example.demo1;

public class CityInfo {
    public String cityName;
    public int population;
    public CityInfo(String cityName, int population) {
        this.cityName = cityName;
        this.population = population;
    }
    public CityInfo() {  
    }
    public int getCleanlinessScore() {
        throw new RuntimeException("method not implemented");
    }
}  
