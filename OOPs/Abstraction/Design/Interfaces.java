package Design;

interface Bird {
    void fly();

    void eat();
}

class sparrow implements Bird {
    @Override
    public void fly() {
        System.out.println("Sparow flying 2445454");
        System.out.println("Sparow flying 244124515");
        System.out.println("Sparow flying 244878784");
        System.out.println("Sparow flying 2442544");

    }

    @Override
    public void eat() {
        System.out.println("Sparrow eating");
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

public class Interfaces {
    public static void doBirdStuff(Bird b) {
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
