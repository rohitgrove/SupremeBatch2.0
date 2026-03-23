public class ClimbingStairs {
    public static int solve1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int step1 = solve1(n - 1);
        int step2 = solve1(n - 2);
        return step1 + step2;
    }

    public static int solve2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int step1 = solve2(n - 1);
        int step2 = solve2(n - 2);
        return step1 + step2;
    }

    public static int climbStairs(int n) {
        return solve1(n);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }
}