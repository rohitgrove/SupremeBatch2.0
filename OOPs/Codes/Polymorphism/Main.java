import Overriding.*;

public class Main {
     public static void main(String[] args) {
          // Calculator c = new Calculator();
          // System.out.println(c.add(2, 3));
          // System.out.println(c.add(2, 3, 4));
          // System.out.println(c.add(2, 3, 4, 5.6));

          // Runtime Polymorphism
          // Up Casting
          // Circle c = new Circle();
          // doDrawingStuff1(c);

          Rect r = new Rect();
          doDrawingStuff1(r);

          Shape s = new Shape();
          doDrawingStuff1(s);

          // Down Casting
          Circle c = new Circle();
          doDrawingStuff2(c);

          // Rect r = new Rect();
          // doDrawingStuff2(r);
     }

     // Up Casting
     public static void doDrawingStuff1(Shape s) {
          s.draw(); // polymorphic
     }

     // Down Casting
     public static void doDrawingStuff2(Shape s) {
          s.draw(); // polymorphic
          Circle c = (Circle) s; // downcasting
          c.personal();
     }
}
