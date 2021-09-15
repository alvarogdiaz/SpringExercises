package com.bosonit.restservice.interfaces;

import com.bosonit.restservice.entities.City;

import java.util.Collection;

public interface ICityService {
    void addCity(String name, int population);
    void deleteCity(String name);
    Boolean existsCity(String name);
    City getCity(String name);
    Collection<City> getCities();
}
