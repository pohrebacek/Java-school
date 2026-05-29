package tretak.oopInheritence;

public class rectangle {
    double width, height;

    public rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return width*height;
    }
}
