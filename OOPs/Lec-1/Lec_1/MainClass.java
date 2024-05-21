package Lec_1;

public class MainClass {
    public static void main(String[] args) {
        // Dog d1 = new Dog();
        // d1.name = "Tommy";
        // d1.bark();
        // d1.walk();

        // Dog d2 = new Dog();
        // d2.name = "Leo";
        // d2.walk();

        Complex1 num1 = new Complex1();
        num1.a = 3;
        num1.b = 5;
        num1.print();
    }
}

class Complex1 {
    int a, b;

    void print() {
        System.out.println(a + " + " + b + "i");
    }
}

class Dog { // factory
    String name;
    int age;
    String color;

    void walk() {
        System.out.println(name + " is walking");
    }

    void bark() {
        System.out.println(name + " is barking");
    }
}

class Cat {

}