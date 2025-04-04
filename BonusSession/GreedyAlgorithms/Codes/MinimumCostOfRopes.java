import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // insert all elements
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            minHeap.offer(val);
        }

        int cost = 0;
        while (minHeap.size() > 1) {
            int a = minHeap.poll();
            int b = minHeap.poll();
            cost += a + b;
            int sum = a + b;
            minHeap.offer(sum);
        }

        return cost;
    }

    public static void main(String[] args) {
        int arr1[] = { 4, 3, 2, 6 };
        System.out.println(minCost(arr1));
        int arr2[] = { 4, 2, 7, 6, 9 };
        System.out.println(minCost(arr2));
    }
}
