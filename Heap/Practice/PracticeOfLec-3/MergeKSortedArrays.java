import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeKArrays(int arr[][], int K) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Info> pq = new PriorityQueue<>(new Compare());
        int n = arr[0].length;
        for (int row = 0; row < K; row++) {
            pq.offer(new Info(arr[row][0], row, 0));
        }

        while (!pq.isEmpty()) {
            Info temp = pq.poll();

            int topData = temp.data;
            int topRow = temp.rowIndex;
            int topCol = temp.colIndex;

            ans.add(topData);

            if (topCol + 1 < n) {
                pq.add(new Info(arr[topRow][topCol + 1], topRow, topCol + 1));
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