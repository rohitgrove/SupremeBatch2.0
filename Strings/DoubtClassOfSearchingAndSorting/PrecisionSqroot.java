public class PrecisionSqroot {
    public static int mySqrt(int n) {
        int s = 0, e = n;
        int ans = 0;
        while (s <= e) {
            int mid = (e - s) / 2 + s;
            if (mid * mid <= n) {
                ans = mid;
                s = mid + 1; // go right
            } else
                e = mid - 1; // go left
        }
        return ans;
    }

    public static double myPrecisionSqrt(int n) {
        double sqrt = mySqrt(n);
        int precision = 10;
        double step = 0.1;
        for (int i = 0; i < precision; ++i) {
            double j = sqrt;
            while (j * j <= n) {
                sqrt = j;
                j += step;
            }
            step /= 10;
        }
        return sqrt;
    }

    public static void main(String[] args) {
        int n = 63;
        double sqrt = myPrecisionSqrt(n);
        System.out.printf("%.10f\n", sqrt);
    }
}
