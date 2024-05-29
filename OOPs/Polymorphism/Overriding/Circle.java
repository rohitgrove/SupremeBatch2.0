package Overriding;

public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle Drawing...");
    }

    public void persnal() {
        System.out.println("persnal Method of Circle");
    }
}
