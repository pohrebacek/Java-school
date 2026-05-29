package tretak.oopInheritence;

public class Cuboid extends rectangle{

    double depth;
    public Cuboid(double width, double height, double depth) {
        super(width, height);
        this.depth = depth;
    }

    double getVolume() {
        return super.getArea()*depth;
    }

    @Override
    public double getArea() {
        return 2 * ((height*width) + (height*depth) + (width*depth));
    }

    public static void main(String[] args) {
        rectangle r = new rectangle(5, 8);
        System.out.println(r.getArea());

        Cuboid c = new Cuboid(5, 8, 2);
    }
}
