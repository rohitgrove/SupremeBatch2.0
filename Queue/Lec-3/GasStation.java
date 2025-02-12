public class GasStation {
    public static int bruteForceApproach(int[] gas, int[] cost) {
        int size = cost.length;
        for (int start = 0; start < size; start++) {
            int balance = 0;
            boolean canComplete = true;
            int rear = start;

            // we have made a full circle back to the starting point
            for (int count = 0; count < size; count++) {
                balance += gas[rear] - cost[rear];
                if (balance < 0) {
                    canComplete = false;
                    break;
                }
                // Move to the next station in a circular manner
                if ((rear + 1) == size) {
                    rear = 0;
                } else {
                    rear++;
                }
            }

            if (canComplete) {
                return start;
            }
        }

        return -1;
    }

    public static int optimizedApproach(int gas[], int cost[]) {
        int deficit = 0;
        int balance = 0;
        // index from where we are starting the movment
        int start = 0;

        // har ek index ko check kar rha hai, k woh answer hai ya nhi.
        for (int i = 0; i < gas.length; i++) {
            balance = balance + gas[i] - cost[i];

            if (balance < 0) {
                deficit += Math.abs(balance);
                start = i + 1;
                balance = 0;
            }
        }

        if (balance - deficit >= 0) {
            return start;
        } else {
            return -1;
        }
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        return optimizedApproach(gas, cost);
    }

    public static void main(String[] args) {
        int gas1[] = { 1, 2, 3, 4, 5 }, cost1[] = { 3, 4, 5, 1, 2 };
        System.out.println(canCompleteCircuit(gas1, cost1));
        int gas2[] = { 2, 3, 4 }, cost2[] = { 3, 4, 3 };
        System.out.println(canCompleteCircuit(gas2, cost2));
    }
}
