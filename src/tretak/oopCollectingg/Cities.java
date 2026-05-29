package tretak.oopCollectingg;
import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;

public class Cities {
    public static void main(String[] args) {
        ArrayList<City> cities = new ArrayList<>();
        DataImport di = new DataImport("Cities.txt");
        String line;
        String[] info;
        while (di.hasNext()){
            line = di.readLine();
            info = line.split(",");
            City city = new City(info[0], info[1], info[2]);
            cities.add(city);
        }
        di.finishImport();

        cities.sort(new CityComparator());
        HashSet<City> hashCities = new HashSet<>(cities);
        System.out.println(hashCities);
        System.out.println("File size: "+cities.size());
        System.out.println("Unique file size: "+hashCities.size());

        for (City city: hashCities){
            city.printCities("Finland");
        }
    }

}

class City {
    String name, country, continent;

    public City(String name, String country, String continent) {
        this.name = name;
        this.country = country;
        this.continent = continent;
    }

    @Override
    public String toString() {
        return name +", " + country +", " + continent + '\n';
    }

    void printCities(String country){
        if (this.country.equals(country)){
            System.out.println("| - "+this.name);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) && Objects.equals(country, city.country) && Objects.equals(continent, city.continent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, continent);
    }
}

class CityComparator implements Comparator<City> {

    @Override
    public int compare(City o1, City o2) {
        return o1.continent.compareTo(o2.continent);
    }
}
