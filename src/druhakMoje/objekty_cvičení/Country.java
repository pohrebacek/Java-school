package objekty_cvičení;

public class Country {
    private int population;
    private double area;
    private String name;
    private String code;

    public Country(int population, double area, String name, String code) {
        this.population = population;
        this.area = area;
        this.name = name;
        this.code = code;
    }

    public int getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }


    public void setPopulation(int population) {
        if (population > 0){
            this.population = population;
        }

    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        if (code.length() == 3){
            this.code = code;
        }

    }
}
