public class GasStation {
    public static int bruteForce(int gas[], int cost[]) {
        int size = gas.length;
        for (int start = 0; start < size; start++) {
            int tank = 0;
            boolean canCovered = true;
            int rear = start;
            for (int count = 0; count < size; count++) {
                tank += gas[rear] - cost[rear];
                if (tank < 0) {
                    canCovered = false;
                    break;
                }

                if ((rear + 1) == size) {
                    rear = 0;
                } else {
                    rear++;
                }
            }

            if (canCovered) {
                return start;
            }
        }

        return -1;
    }

    public static int optimizedApproach(int gas[], int cost[]) {
        int dificient = 0;
        int balance = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            balance = balance + gas[i] - cost[i];
            
            if (balance < 0) {
                dificient += Math.abs(balance);
                start = i + 1;
                balance = 0;
            }
        }

        if (balance - dificient >= 0) {
            return start;
        } else {
            return -1;
        }
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // return bruteForce(gas, cost);
        return optimizedApproach(gas, cost);
    }

    public static void main(String[] args) {
        int gas1[] = { 1, 2, 3, 4, 5 }, cost1[] = { 3, 4, 5, 1, 2 };
        System.out.println(canCompleteCircuit(gas1, cost1));
        int gas2[] = { 2, 3, 4 }, cost2[] = { 3, 4, 3 };
        System.out.println(canCompleteCircuit(gas2, cost2));
        int gas3[] = { 3, 3, 4 }, cost3[] = { 3, 4, 4 };
        System.out.println(canCompleteCircuit(gas3, cost3));
    }
}
