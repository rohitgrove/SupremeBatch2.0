package Overloading;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(2, 3));

        System.out.println(calculator.add(2, 3, 4));

        System.out.println(calculator.add(2, 3, 4, 5.6));
    }
}
