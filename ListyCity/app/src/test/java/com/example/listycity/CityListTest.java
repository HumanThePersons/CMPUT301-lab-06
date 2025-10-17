package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
    // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
    // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity(){
        CityList cityList = mockCityList();
        // Test that the mock city is in the list
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // For the purposes of this test, test that the size of the list is 1
        assertEquals(1, cityList.getCities().size());
        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    void testDeleteCity(){
        // Test that a city is present in the list
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        // Test that the city is properly deleted
        cityList.DeleteCity(mockCity());
        assertEquals(0, cityList.getCities().size());

        // Tests that deleting a city that exists but is not in the list throws an exception
        City city = new City("Vancouver", "British Columbia");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            cityList.DeleteCity(city);
        });
    }

    @Test
    void testCountCities(){
        // Test that an empty list returns 0
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());
        // Test that a list counts 1 element
        cityList.add(mockCity());
        assertEquals(0, cityList.countCities());
        // Test that a list counts more than 1 element
        cityList.add(new City("Vancouver", "British Columbia"));
        cityList.add(new City("Saskatoon", "Saskatchewan"));
        assertEquals(3, cityList.countCities());
    }
}

