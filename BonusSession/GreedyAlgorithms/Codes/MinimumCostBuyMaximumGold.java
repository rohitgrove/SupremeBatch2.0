import java.util.Arrays;

public class MinimumCostBuyMaximumGold {
    public static int[] minCost(int arr[]) {
        Arrays.sort(arr);

        int buy = 0;
        int free = arr.length - 1;
        int ans[] = new int[2];

        while (buy < free) {
            ans[0] += arr[buy];
            ans[1] += arr[buy] + arr[free] + arr[free - 1];
            buy++;
            free -= 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 3, 2, 4, 6 };
        int ans[] = minCost(arr);
        System.out.println("Minimum Cost: " + ans[0]);
        System.out.println("Maximum Gold: " + ans[1]);
    }
}