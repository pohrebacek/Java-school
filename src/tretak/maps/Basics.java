package tretak.maps;

import java.util.HashMap;
import java.util.Map;

public class Basics {
    public static void main(String[] args) {
        //Map je interface
        HashMap<String, String> countries = new HashMap<>();
        countries.put("USA", "Washington DC");
        countries.put("GB", "London");
        countries.put("Germany", "Berlin");
        countries.put("Czechia", "Prague");

        System.out.println(countries.size());
        System.out.println(countries);

        System.out.println(countries.get("Czechia"));
        System.out.println(countries.getOrDefault("Norway", "Country not found"));

        countries.remove("GB");
        System.out.println(countries);

        countries.replace("USA", "Detroit");
        System.out.println(countries);
        countries.replace("USA", countries.get("USA") + " NEW");
        System.out.println(countries);

        System.out.println(countries.containsKey("France"));
        System.out.println(countries.containsValue("Prague"));

        for (String country : countries.keySet()) { //co je keyset?? -> vrátí všechny klíče v dané map
            System.out.println(country);
            System.out.println("Capital: " + countries.get(country));
        }

        for (Map.Entry<String, String> entry : countries.entrySet()) {  //Map.Entry?? -> třída která je vlastně ten jeden konkrétní záznam z Map (kde v Map jsou všechny záznamy)
            System.out.println("Country: " + entry.getKey() + ", Capital: " + entry.getValue());
        }

        //avg délka jména města
        double averageNameLength = countries.values().stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
        System.out.println(averageNameLength);


    }
}
