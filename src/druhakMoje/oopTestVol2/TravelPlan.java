package oopTestVol2;

public class TravelPlan {
    Geolocation start;
    Geolocation destination;
    Plane plane;



    public TravelPlan(Geolocation start, Geolocation destination, Plane plane) {
        this.start = start;
        this.destination = destination;
        this.plane = plane;
    }

    void getPlan(){
        System.out.println("Cesta z "+start.toString()+" do "+destination.toString());
        double vzdalenost = Math.sqrt(Math.pow(destination.x - start.x, 2) + Math.pow(destination.y - start.y, 2));
        System.out.println("Vzdálenost: "+vzdalenost);
        System.out.println("Doba letu: "+vzdalenost/plane.velocity);
    }
}
