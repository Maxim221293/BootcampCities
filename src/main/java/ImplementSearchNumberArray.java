import java.util.*;
import java.util.stream.Collectors;

public class ImplementSearchNumberArray implements SearchNumberArray{
    List<City> cityList;

    @Override
    public String largestPopulation (List<City> cityList) {
        City[] array = cityList.toArray(new City[0]);
        City max = array[0];
        int index = 0;
        for (int i = 0; i<array.length; i++){
            if (max.getPopulation() < (array[i].getPopulation())){
                max = array[i];
                index = i;
            }
        }
        return "["+index+"]"+" = "+max.getPopulation();
    }
    @Override
    public Map<String, Integer> countCityFromRegion (List<City> cityList){
        Map<String, Integer> hash = new HashMap<>();

        for (City city : cityList) {
            int count = 1;
            if (hash.containsKey(city.getDistrict())) {
                count = hash.get(city.getDistrict()) + 1;
            }
            hash.put(city.getDistrict(), count);
        }
        return hash;

    }
}


