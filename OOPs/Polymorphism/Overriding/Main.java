package Overriding;

public class Main {
    public static void main(String[] args) {
        // Circle c = new Circle();
        // c.draw();
        // doDrawing(new Shape());
        // doDrawing(c);
        // Rect r = new Rect();
        // r.draw();
        // both are same
        // Shape s = new Rect();
        // doDrawing(r);

        // Shape s = new Shape();
        // s.draw();

        // down Casting
        Circle c = new Circle();
        doDrawing(c);

        // Rect r = new Rect();
        // doDrawing(r);
    }

    // Dynamic Method Dispatch
    public static void doDrawing(Shape s) {
        s.draw(); // polymorphic
        Circle c = (Circle)s; // downcasting
        c.persnal();
    }
}
