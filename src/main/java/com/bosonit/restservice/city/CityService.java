package com.bosonit.restservice.city;

import java.util.Collection;

public interface CityService {
    void addCity(String name, int population);
    void deleteCity(String name);
    Boolean exists(String name);
    City getCity(String name);
    Collection<City> getCities();
}
