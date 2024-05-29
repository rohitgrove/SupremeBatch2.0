package Design;

abstract class Bird {
    abstract void fly();
    abstract void eat();

    public void sleep() {
        System.out.println("Bird is sleeping");
    }
}

class sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow flying alag way se");
    }

    @Override
    public void eat() {
        System.out.println("Sparrow eating");
    }
}

class Crow extends Bird {
    @Override
    public void fly() {
        System.out.println("Crow flying alag tarike se");
    }

    @Override
    public void eat() {
        System.out.println("Crow eating");
    }
}

public class AbstractClasses {
    public static void doBirdStuff(Bird b) {
        b.fly();
        b.eat();
        b.sleep();
    }

    public static void main(String[] args) {
        // Bird bird = new sparrow();
        // bird.eat();
        // bird.fly();
        // bird = new Crow();
        // bird.eat();
        // bird.fly();
        doBirdStuff(new sparrow());
        doBirdStuff(new Crow());
    }
}
