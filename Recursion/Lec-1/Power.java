public class Power {
    public static int pow(int n) {
        // base case
        if (n == 0) {
            return 1;
        }

        int ans = 2 * pow(n - 1);
        return ans;
    }

    public static int pow(int a, int b) {
        if (b == 0) {
            return 1;
        }

        if (b == 1) {
            return a;
        }

        int ans = a * pow(a, b - 1);
        return ans;
    }

    public static int optimizedPower(int a, int n) { // O(logn)
        if (n == 0) {
            return 1;
        }

        int halfPower = optimizedPower(a, n / 2);
        // System.out.println(halfPower);
        int halfPowerSq = halfPower * halfPower;

        // n is odd
        if (n % 2 != 0) {
            halfPowerSq = a * halfPowerSq;
        }
        return halfPowerSq;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 5));
    }
}
