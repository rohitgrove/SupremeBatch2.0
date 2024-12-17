public class SlowExponentiation {
    public static int fastExponentiation(int a, int b) {
        int ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) { // odd
                ans = ans * a;
            }
            a = a * a;
            b >>= 1; // right shift -> division by 2
        }

        return ans;
    } // O(logb)

    public static int slowExponentiation(int a, int b) {
        int ans = 1;
        for (int i = 0; i < b; i++) {
            ans *= a;
        }

        return ans;
    } // O(b)

    public static void main(String[] args) {
        System.out.println(slowExponentiation(5, 4));
        System.out.println(fastExponentiation(5, 4));
    }
}
