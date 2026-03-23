abstract class Bird {
    abstract void fly();

    abstract void eat();

    private void sleep() {
        System.out.println("bird sleeping");
    }
}

class Sparrow extends Bird {
    @Override
    void fly() {
        System.out.println("Sparrow flying alag way se");
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
    }

    public static void main(String[] args) {
        doBirdStuff(new Sparrow());
        doBirdStuff(new Crow());
    }
}