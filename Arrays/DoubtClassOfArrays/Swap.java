public class Swap {
    public static void main(String[] args) {
        // Airthmatic Swap
        int a = 2;
        int b = 3;

        System.out.println(a + " " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + " " + b);
        System.out.println("=======================================");
        // Xor Method
        a = 2;
        b = 3;
        System.out.println(a + " " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }
}
