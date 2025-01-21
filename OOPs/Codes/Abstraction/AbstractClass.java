abstract class Bird {
    abstract void fly();
    abstract void eat();

    public void sleep() {
        System.out.println("Bird Sleeping");
    }
}

class Sparrow extends Bird {
    @Override
    void fly() {
        System.out.println("Sparrow flying alg way se");
    }
    @Override
    void eat() {
        System.out.println("Sparrow eating");
    }
}

class Crow extends Bird {
    @Override
    void fly() {
        System.out.println("Crow flying 2");
    }
    @Override
    void eat() {
        System.out.println("Crow eating alag way se");
    }
}

public class AbstractClass {
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