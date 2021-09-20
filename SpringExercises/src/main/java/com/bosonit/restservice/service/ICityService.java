package com.bosonit.restservice.service;

import com.bosonit.restservice.domain.City;

import java.util.Collection;

public interface ICityService {
    void addCity(String name, int population);
    void deleteCity(String name);
    Boolean existsCity(String name);
    City getCity(String name);
    Collection<City> getCities();
}
