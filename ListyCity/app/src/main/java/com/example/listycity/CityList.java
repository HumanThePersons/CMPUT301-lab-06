package com.example.listycity;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * This is a class that keeps track of a list of city objects
 * Also gives functionality to modify and analyze the list
 * @author zoe
 * @version 1
 * @see City
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist in the list already
     * @param city;
     * @throws IllegalArgumentException;
     * @see City;
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return List<City> list;
     * @see City;
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This checks if the given city is in the list or not
     * @param city;
     * @return boolean
     *      true if in list, false if not
     * @see City;
     */
    public boolean hasCity(City city){
        return cities.contains(city);
    }

    /**
     * This deletes a given city from the list
     * @param city;
     * @see City;
     * @throws IndexOutOfBoundsException;
     * If the city isn't in the list already, throws an exception
     */
    public void DeleteCity(City city){
        if (!cities.contains(city)){
            throw new IndexOutOfBoundsException("city to delete is not in cityList");
        }
        cities.remove(city);
    }

    /**
     * This returns the number of cities in the list
     * @return int
     *      number of cities in the list
     */
    public int countCities(){
        return (cities.size());
    }
}