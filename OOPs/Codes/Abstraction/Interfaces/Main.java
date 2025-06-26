interface Bird {
    void fly();
    void eat();

    default void sleep(){
        System.out.println("Bird sleep");
    }
}

interface Walk{
    int legs = 4;
    void walking();
}

class Sparrow implements Bird, Walk {
    @Override
    public void fly() {
        System.out.println("Sparrow flying 2");
        System.out.println("Sparrow flying 23e23233");
        System.out.println("Sparrow 3423 32");
        System.out.println("Sparrow 434 2");
    }

    @Override
    public void eat() {
        System.out.println("Sparrow eating");
    }

    @Override
    public void walking() {
        int a = Walk.legs;
        System.out.println("Sparrow walking");
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
    public static void doBirdStuff(Bird b){
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

