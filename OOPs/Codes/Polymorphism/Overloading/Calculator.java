package Overloading;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    // overloading add, 3int addition
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(int a, int b, int c, double d) {
        return a + b + c + d;
    }
}
