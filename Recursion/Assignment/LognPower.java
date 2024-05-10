public class LognPower {
    public static int pow(int a, int n) {
        // Both are right conditions
        // if (n == 1) { 
        //     return a;
        // }
        if (n == 0) {
            return 1;
        }

        int halfSquare = pow(a, n / 2);
        int square = halfSquare * halfSquare;
        if (n % 2 != 0) {
            square = a * square;
        }
        return square;
    }

    public static void main(String[] args) {
        int a = 2;
        int n = 5;
        System.out.println(pow(a, n));
    }
}
