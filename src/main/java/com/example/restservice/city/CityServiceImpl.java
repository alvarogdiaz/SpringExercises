package com.example.restservice.city;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CityServiceImpl implements CityService {
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
    public Boolean exists(String name) {
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
