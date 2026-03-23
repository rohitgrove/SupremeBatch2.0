public class NumberOfDiceRollsWithTargetSum {
    public static int numRollsToTarget(int n, int k, int target) {
        // base
        if (target < 0) {
            return 0;
        }

        if (n == 0 && target == 0) {
            return 1;
        }

        if (n == 0 && target != 0) {
            return 0;
        }

        if (n != 0 && target == 0) {
            return 0;
        }

        int ans = 0;

        for (int i = 1; i <= k; i++) {
            ans += numRollsToTarget(n - 1, k, target - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1, 6, 3));
        System.out.println(numRollsToTarget(2, 6, 7));
        System.out.println(numRollsToTarget(30, 30, 500));
    }
}
