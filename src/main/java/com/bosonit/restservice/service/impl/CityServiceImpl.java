package com.bosonit.restservice.service.impl;

import com.bosonit.restservice.domain.City;
import com.bosonit.restservice.service.ICityService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CityServiceImpl implements ICityService {
    private Map<String, City> cities = new HashMap<>();

    @Override
    public void addCity(String name, int population) {
        cities.put(name, new City(name, population));
    }

    @Override
    public void deleteCity(String name) {
        cities.remove(name);
    }

    @Override
    public Boolean existsCity(String name) {
        return cities.containsKey(name);
    }

    @Override
    public City getCity(String name) {
        return cities.get(name);
    }

    @Override
    public Collection<City> getCities() {
        return cities.values();
    }
}
