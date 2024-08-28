import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

class Info {
    public int data;
    public int rowIndex;
    public int colIndex;

    public Info(int data, int rowIndex, int colIndex) {
        this.data = data;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }
}

class Coustom implements Comparator<Info> {
    @Override
    public int compare(Info o1, Info o2) {
        return Integer.compare(o1.data, o2.data);
    }
}

public class MergeKSortedArray {
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Info> pq = new PriorityQueue<>(new Coustom());
        int n = arr[0].length;

        // 1 step : first k elements
        for (int row = 0; row < K; row++) {
            int element = arr[row][0];
            Info temp = new Info(element, row, 0);
            pq.add(temp);
        }

        while (!pq.isEmpty()) {
            Info temp = pq.poll();
            int topData = temp.data;
            int topRow = temp.rowIndex;
            int topCol = temp.colIndex;

            // store in ans ArrayList
            ans.add(topData);
            // next element for the same row, jisme se pop kia h just abhi
            // use insert bhi toh karna hai
            if (topCol + 1 < n) {
                // iska matlab row me or element abhi present hai
                Info newInfo = new Info(arr[topRow][topCol + 1], topRow, topCol + 1);
                pq.add(newInfo);
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