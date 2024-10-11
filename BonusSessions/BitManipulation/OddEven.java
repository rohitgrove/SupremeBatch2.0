public class OddEven {
    public static void checkEvenOdd(int n) {
        if ((n & 1) == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }

    public static void main(String[] args) {
        int n = 178;
        checkEvenOdd(n);
    }
}