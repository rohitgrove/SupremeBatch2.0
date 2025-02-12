public class GasStation {
    public static int bruteForceApproach(int gas[], int cost[]) {
        int size = cost.length;
        for (int start = 0; start < size; start++) {
            int rear = start;
            int balance = 0;
            boolean canComplete = true;

            for (int count = 0; count < size; count++) {
                balance = balance + gas[rear] - cost[rear];
                if (balance < 0) {
                    canComplete = false;
                    break;
                }

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
        int balance = 0;
        int deficet = 0;
        int start = 0;

        for (int i = 0; i < cost.length; i++) {
            balance = balance + gas[i] - cost[i];

            if (balance < 0) {
                deficet += Math.abs(balance);
                balance = 0;
                start = i + 1;
            }
        }

        if (balance - deficet >= 0) {
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