import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.Assert.*;

public class ConclusionCityTest {
    List<City> cityList;
    ImplementSortCities implementSortCities = new ImplementSortCities();
    ImplementSearchNumberArray implementSearchNumberArray = new ImplementSearchNumberArray();
    @Before
    public void setUp() throws FileNotFoundException {
        ConclusionCity conclusionCity = new ConclusionCity();

        cityList = conclusionCity.showCities();
    }


    @Test
    public void testShowCities() {
        List<City> testCityList = new ArrayList<>();
        City city1 = new City("Абакан", "Хакасия", "Сибирский", 165183, "1931");
        City city2 = new City("Абаза", "Хакасия", "Сибирский", 17111, "1867");
        City city3 = new City("Абдулино", "Оренбургсая область", "Приволжский", 10663, "1795");
        testCityList.add(city1);
        testCityList.add(city2);
        testCityList.add(city3);
        Assert.assertEquals(cityList, testCityList);
    }

    @Test
    public void sortByName(){
        cityList.sort(Comparator.comparing(City::getName, String::compareToIgnoreCase));
        List<City> testCityList2 = new ArrayList<>();
        City city1 = new City("Абаза", "Хакасия", "Сибирский", 17111, "1867");
        City city2 = new City("Абакан", "Хакасия", "Сибирский", 165183, "1931");
        City city3 = new City("Абдулино", "Оренбургсая область", "Приволжский", 10663, "1795");
        testCityList2.add(city1);
        testCityList2.add(city2);
        testCityList2.add(city3);
        Assert.assertEquals(cityList, testCityList2);
    }
    @Test
    public void sortByNameAbdDistrict(){
        cityList.sort(Comparator.comparing(City::getName).thenComparing(City::getDistrict));
        List<City> testCityList3 = new ArrayList<>();
        City city1 = new City("Абаза", "Хакасия", "Сибирский", 17111, "1867");
        City city2 = new City("Абакан", "Хакасия", "Сибирский", 165183, "1931");
        City city3 = new City("Абдулино", "Оренбургсая область", "Приволжский", 10663, "1795");
        testCityList3.add(city1);
        testCityList3.add(city2);
        testCityList3.add(city3);
        Assert.assertEquals(cityList, testCityList3);
    }
    @Test
    public void largestPopulation(){
        Assert.assertEquals("[0] = 165183", implementSearchNumberArray.largestPopulation(cityList));
    }
    @Test
    public void countCityFromRegion(){
        Map<String, Integer> hash = new HashMap<>();

        for (City city : cityList) {
            int count = 1;
            if (hash.containsKey(city.getDistrict())) {
                count = hash.get(city.getDistrict()) + 1;
            }
            hash.put(city.getDistrict(), count);
        }

        Map<String, Integer> test = new HashMap<>();
        test.put("Сибирский", 2);
        test.put("Приволжский", 1);
        Assert.assertEquals(test, hash);

    }

}