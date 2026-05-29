package tretak.maps;

public class PointCategories {
    static class Point {
        double x,y;
        String pointID;

        public Point(double x, double y, String pointID) {
            this.x = x;
            this.y = y;
            this.pointID = pointID;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", pointID='" + pointID + '\'' +
                    '}';
        }
    }
}
