package oop_test;

public class RentableLand {
    int COST_PER_SQUARE_METER = 500;
    boolean farming;

    public int rent(int width, int length, int days){
        int rent = (width*length*500)*days;
        if (farming && days>= 183 && rent - 100000 < 0){
            rent -= 100000;
        }
        return rent;
    }

}
