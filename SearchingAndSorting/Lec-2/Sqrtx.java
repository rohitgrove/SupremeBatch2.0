public class Sqrtx {
    public static int mySqrt(int x) {
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

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(68));
    }
}
