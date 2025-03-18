import java.util.*;

public class MergeKSortedArrays {
    public static List<Integer> mergeKArrays(int[][] arr, int K) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Info> pq = new PriorityQueue<>(new Compare());

        // Insert first elements of each array into the priority queue
        for (int i = 0; i < K; i++) {
            pq.offer(new Info(arr[i][0], i, 0));
        }

        // Merge process
        while (!pq.isEmpty()) {
            Info front = pq.poll(); // Extract minimum
            ans.add(front.data);

            // Push next element from the same row if exists
            if (front.colIndex + 1 < arr[front.rowIndex].length) {
                pq.offer(new Info(arr[front.rowIndex][front.colIndex + 1], front.rowIndex, front.colIndex + 1));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int k1 = 3, arr1[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        System.out.println(mergeKArrays(arr1, k1));
        int k2 = 4, arr2[][] = { { 1, 2, 3, 4 },
                { 2, 2, 3, 4 },
                { 5, 5, 6, 6 },
                { 7, 8, 9, 9 } };
        System.out.println(mergeKArrays(arr2, k2));
    }
}
