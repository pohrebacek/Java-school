package tretak.references;

public class ClassArray {
    public static void main(String[] args) {
        Coordinates c = new Coordinates(5.8, 7.22);
        Coordinates[] coords = new Coordinates[5];

        Coordinates[] coordinates = {
                new Coordinates(4.8, 8.48),
                new Coordinates(2.8, 9.78),
                c
        };


        for(Coordinates cord : coordinates){
            System.out.println(cord);
        }
    }
}

class Coordinates{
    double x,y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "[ "+x+";"+y+"]";
    }
}
