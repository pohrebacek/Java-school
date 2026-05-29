package oopTestVol2;

public class TravelPlanBonus {
    City start;
    City destination;
    Plane plane;

    int pricePerHour = 10000;

    public TravelPlanBonus(City start, City destination, Plane plane) {
        this.start = start;
        this.destination = destination;
        this.plane = plane;
    }

    void getPlan(){
        System.out.println("Cesta z "+start.toString()+" do "+destination.toString());
        double vzdalenost = Math.sqrt(Math.pow(destination.location.x - start.location.x, 2) + Math.pow(destination.location.y - start.location.y, 2));
        System.out.println("Vzdálenost: "+vzdalenost);
        double doba = vzdalenost/plane.velocity;
        System.out.println("Doba letu: "+doba);
        System.out.println("Cena "+doba*pricePerHour);
    }
}
