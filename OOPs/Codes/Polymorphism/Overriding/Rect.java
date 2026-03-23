package Overriding;

public class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle drawing...");
    }
}
