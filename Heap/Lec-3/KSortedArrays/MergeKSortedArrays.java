import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        int n = arr[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Info> pq = new PriorityQueue<>(new Compare());

        // 1 step: process first k elements
        for (int row = 0; row < K; row++) {
            int element = arr[row][0];
            Info temp = new Info(element, row, 0);
            pq.offer(temp);
        }

        while (!pq.isEmpty()) {
            Info temp = pq.poll();

            int topData = temp.data;
            int topRow = temp.rowIndex;
            int topCol = temp.colIndex;

            // store in ans
            ans.add(topData);

            // next element for the same row, jitme se pop kia h just abhi
            // use insert bhi toh karna hai
            if (topCol + 1 < n) {
                // iska matlab row me or element abhi present hai
                Info newInfo = new Info(arr[topRow][topCol + 1], topRow, topCol + 1);
                pq.offer(newInfo);
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