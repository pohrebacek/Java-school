package tretak.files;

import fileworks.DataImport;

public class countryRead {
    public static void main(String[] args) {
        String line;
        String[] info;
        double age = 0;
        double countAge = 0;
        Country biggestCountry = new Country("none", "none", 0, 0);
        int europe = 0;
        DataImport di = new DataImport("countries.txt");
        // TODO: 23.09.2024 1 - spocitat prumerny vek doziti
        // TODO: 23.09.2024 2 - nejvetsi zeme rozlohou
        // TODO: 23.09.2024 3 - pocet zemi v evrope
        while (di.hasNext()){
            line = di.readLine();
            info = line.split(";");
            Country country = new Country(info[0], info[1], Integer.parseInt(info[2]), Double.parseDouble(info[3]));
            if (country.area > biggestCountry.area){
                biggestCountry = country;
            }
            if (country.continent.equals("Europe")){
                europe ++;
            }
            System.out.println(country);
            countAge ++;
            age += country.expectedAge;
        }
        System.out.println("Průměrný věk dožití: "+age/countAge);
        System.out.println("Největší země je: "+biggestCountry.name);
        System.out.println("Počet zemí v evropě: "+europe);
        di.finishImport();
    }
}

class Country {
    String name, continent;
    int area;
    double expectedAge;

    public Country(String name, String continent, int area, double expectedAge) {
        this.name = name;
        this.continent = continent;
        this.area = area;
        this.expectedAge = expectedAge;
    }


    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", area=" + area +
                ", expectedAge=" + expectedAge +
                '}';
    }
}
