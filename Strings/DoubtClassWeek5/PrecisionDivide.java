public class PrecisionDivide {
    public static int divide(int dividend, int divisor) {
        int s = 0, e = dividend;
        int ans = 0;
        while (s <= e) {
            int mid = (e - s) / 2 + s;
            if (mid * divisor <= dividend) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    public static double myPrecisionDivide(int dividend, int divisor) {
        double quotient = divide(dividend, divisor);
        int precision = 5;
        double step = 0.1;
        for (int i = 0; i < precision; ++i) {
            double j = quotient;
            while (j * divisor <= dividend) {
                quotient = j;
                j += step;
            }
            step /= 10;
        }
        return quotient;
    }

    public static void main(String[] args) {
        int dividend = 29;
        int divisor = 7;
        System.out.println(myPrecisionDivide(dividend, divisor));
    }
}
