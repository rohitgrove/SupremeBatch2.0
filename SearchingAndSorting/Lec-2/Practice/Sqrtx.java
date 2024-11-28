public class Sqrtx {
    public static int mySqrt(int x) {
        int s = 0;
        int e = x;
        int mid = s + (e - s) / 2;
        int ans = -1;

        while (s <= e) {
            int sqrt = mid * mid;
            if (sqrt == x) {
                return mid;
            } else if (sqrt < x) {
                ans = mid;
                s = mid + 1;                
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static double mySqrt2(int x) {
        int s = 0;
        int e = x;
        long mid = s + (e - s) / 2;
        double ans = -1.0;

        while (s <= e) {
            // kya mid hi toh answer nahi
            if (mid * mid == x) {
                return (double) mid;
            } else if (mid * mid < x) {
                // ans store
                // right me jao
                ans = (double) mid;
                s = (int) mid + 1;
            } else {
                e = (int) mid - 1;
            }
            mid = s + (e - s) / 2;
        }

        double incr = 0.1;
        while (incr > 0.001) {
            while (ans * ans <= x) {
                ans += incr;
            }
            ans -= incr;
            incr /= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt2(4));
        System.out.println(mySqrt2(68));
    }
}