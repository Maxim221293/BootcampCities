import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public  static void choice() throws FileNotFoundException {
        System.out.println("Введите цифру от 1 до 4");
        System.out.println("1. Загрузка данных справочника городов России");
        System.out.println("2. Сортировка списка городов");
        System.out.println("3. Поиск города с наибольшим колличеством жителей");
        System.out.println("4. Поиск колличества городов в разрезе регионов");
        System.out.println("Число '0' выход");
        ConclusionCity conclusionCity = new ConclusionCity();
        ImplementSortCities implementSortCities = new ImplementSortCities();
        ImplementSearchNumberArray implementSearchNumberArray = new ImplementSearchNumberArray();

        List<City> cityList = conclusionCity.showCities();

        Scanner scanner = new Scanner(System.in);

        while (true){
           int num = scanner.nextInt();
               switch (num) {
                   case 1:
                       System.out.println(conclusionCity.showCities());
                       break;
                   case 2:
                       System.out.println(implementSortCities.sortByName(cityList));
                       System.out.println(implementSortCities.sortByNameAbdDistrict(cityList));
                       break;
                   case 3:
                       System.out.println(implementSearchNumberArray.largestPopulation(cityList));
                       break;
                   case 4:
                       System.out.println(implementSearchNumberArray.countCityFromRegion(cityList));
                       break;
                   case 0:scanner.close(); System.exit(0);
                   default:
                       System.out.println("Введите число от 0 до 4");
               }
           }


        }

    }

