public class SqrtBSPrecision {
    public static int mySqrt(int x) {
        int s = 0;
        int e = x;
        float mid = s + (e - s) / 2;
        int ans = -1;

        while (s <= e) {
            // kya mid hi toh answer nahi
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                // ans store
                // right me jao
                ans = (int) mid;
                s = (int) mid + 1;
            } else {
                e = (int) mid - 1;
            }
            mid = s + (e - s) / 2;
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
        int n = 51;
        System.out.println(myPrecisionSqrt(n));
    }
}
