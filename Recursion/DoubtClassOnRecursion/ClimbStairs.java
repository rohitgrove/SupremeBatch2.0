public class ClimbStairs {
    public static int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int step1 = climbStairs(n - 1);
        int step2 = climbStairs(n - 2);
        return step1 + step2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}