interface Bird {
    public void fly();

    public void eat();

    default void sleep() {
        System.out.println("Bird Sleep");
    }
}

interface walk {
    int legs = 4;
    public void walking();
}

class Sparrow implements Bird, walk {
    @Override
    public void fly() {
        System.out.println("Sparrow flying 2");
        System.out.println("Sparrow flying 23e23");
        System.out.println("Sparrow flying 4582");
        System.out.println("Sparrow flying 542");
    }

    @Override
    public void eat() {
        System.out.println("Sparrow eating");
    }

    @Override
    public void walking() {
        int a = walk.legs;
        System.out.println("Sparrow walking on " + a + " legs");
    }
}

class Crow implements Bird {
    @Override
    public void fly() {
        System.out.println("Crow flying");
    }

    @Override
    public void eat() {
        System.out.println("Crow eating");
    }
}

public class Main {
    public static void doBirdStuff(Bird b) {
        b.eat();
        b.fly();
        b.eat();
        b.fly();
        b.eat();
        b.fly();
        b.eat();
        b.fly();
        b.eat();
        b.fly();
        b.eat();
        b.fly();
        b.eat();
        b.fly();
        b.eat();
        b.fly();
        b.sleep();
    }

    public static void main(String[] args) {
        doBirdStuff(new Sparrow());
        doBirdStuff(new Crow());
    }
}
