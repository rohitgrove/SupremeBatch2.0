public class NumberOfDice {
    public static int numRollsToTarget(int n, int k, int target) {
        if (target < 0) {
            return 0;
        }

        if (n == 0 && target == 0) {
            return 1;
        }

        if (n != 0 && target == 0) {
            return 0;
        }

        if (n == 0 && target != 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = ans + numRollsToTarget(n - 1, k, target - i);
        }

        return ans;
    }
    public static void main(String[] args) {
        int n1 = 1, k1 = 6, target1 = 3;
        System.out.println(numRollsToTarget(n1, k1, target1));
        int n2 = 2, k2 = 6, target2 = 7;
        System.out.println(numRollsToTarget(n2, k2, target2));
        int n3 = 3, k3 = 6, target3 = 12;
        System.out.println(numRollsToTarget(n3, k3, target3));
    }
}
