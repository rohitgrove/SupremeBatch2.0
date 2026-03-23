public class OddEven {
    public static void checkEvenOdd(int n) {
        if ((n&1) == 1) {
            System.out.print("odd");
        } else {
            System.out.print("even");
        }
    }
    public static void main(String[] args) {
        int n = 19;
        checkEvenOdd(n);
    }
}