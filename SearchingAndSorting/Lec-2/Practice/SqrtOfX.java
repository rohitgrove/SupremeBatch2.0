public class SqrtOfX {
    public static int mySqrt(int x) {
        long start = 0;
        long end = x;
        long mid = start + (end - start) / 2;
        long ans = -1;

        while (start <= end) {
            long sq = mid * mid;
            if (sq == x) {
                return (int) mid;
            } else if (sq < x) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            mid = start + (end - start) / 2;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
    }
}
