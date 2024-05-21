package Lec_1;

public class MethodOverloading {
    public static void main(String[] args) {
        Greet obj = new Greet();
        // obj.greetings();
        // obj.greetings("Rohit");
        obj.greetings("Rohit", 6);
    }
}

class Greet {
    void greetings() {
        System.out.println("Hello, Good Morning");
    }

    void greetings(String name) {
        System.out.println("Hello " + name + ", Good Morning");
    }

    void greetings(String name, int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println("Hello " + name + ", Good Morning");
        }
    }
}
