import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConclusionCity {

    public List<City> showCities() throws FileNotFoundException {

        List<City> cityList = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader("src/main/java/city"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            String[] values = line.split(";");

            cityList.add(new City(values[1], values[2], values[3], Integer.parseInt(values[4]), values[5]));
        }
        return cityList;
    }
}

