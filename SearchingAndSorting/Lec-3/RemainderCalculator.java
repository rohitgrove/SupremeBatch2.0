public class RemainderCalculator {
    public static int getQuotient(int divisor, int dividend) {
        int s = 0;
        int e = dividend;
        int ans = -1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (mid * divisor == dividend) {
                return mid;
            }
            if (mid * divisor < dividend) {
                // ans store
                ans = mid;
                // right me jao
                s = mid + 1;
            } else {
                // left
                e = mid - 1;
            }

            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int divisor = 1;
        int dividend = -35;
        int ans = getQuotient(Math.abs(divisor), Math.abs(dividend));

        if ((divisor > 0 && dividend < 0) || (divisor < 0 && dividend > 0)) {
            ans = 0 - ans;
        }

        System.out.println("Final Ans is: " + ans);
    }
}