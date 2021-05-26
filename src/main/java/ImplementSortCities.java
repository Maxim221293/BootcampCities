import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ImplementSortCities implements SortCities {


    @Override
    public List<City> sortByName(List<City> cityList) {
        cityList.sort(Comparator.comparing(City::getName, String::compareToIgnoreCase));
        return cityList;
    }

    @Override
    public List<City> sortByNameAbdDistrict(List<City> cityList) {
        cityList.sort(Comparator.comparing(City::getName).thenComparing(City::getDistrict));
        return cityList;
    }
}


