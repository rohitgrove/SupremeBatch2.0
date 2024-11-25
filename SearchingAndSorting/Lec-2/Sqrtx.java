public class Sqrtx {
    public static int mySqrt1(int x) {
        int s = 0;
        int e = x;
        long mid = s + (e - s) / 2;
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

    public static double mySqrt2(int number) {
        double low = 0;
        double high = number;
        double mid = 0;

        // Precision up to 3 decimal places
        double precision = 0.001;

        while ((high - low) > precision) {
            mid = (low + high) / 2;

            if (mid * mid > number) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return Math.round(mid * 1000.0) / 1000.0;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt2(4));
        System.out.println(mySqrt2(68));
    }
}
