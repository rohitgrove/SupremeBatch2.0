package Exeptions;

public class ThrowsKeyword {
    public static void printName(String name) throws ArithmeticException, NullPointerException {
        if (name.equalsIgnoreCase("Rohit")) {
            throw new RohitExeption("Bhut bhyankar exeption aya hai");
        }
        System.out.println("Hello, " + name);
    }
    public static void main(String[] args) {
        try {
            printName("Rohit");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Badia");
        }
    }
}

class RohitExeption extends RuntimeException {
    RohitExeption(String msg) {
        super(msg);
        System.out.println("Hello");
    }
}