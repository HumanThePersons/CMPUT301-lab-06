package com.example.listycity;

/**
 * This is a class that defines a City.
 * Side note: I'm mildly unsure of what goes under 'version'
 * @author zoe
 * @version 1
 * @see CityList
 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    /**
     * City constructor
     * @param city
     *      city name
     * @param province
     *      province name
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * @return String
     *      city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * @return String
     *      province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * @param o
     *      the object to be compared.
     * @return int
     *      0 if strings are equal, 1 otherwise
     */
    @Override
    public int compareTo(City o){
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
}
