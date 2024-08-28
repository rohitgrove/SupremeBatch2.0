import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

class Info {
    int data;
    int rowIndex;
    int colIndex;
    public Info(int data, int rowIndex, int colIndex) {
        this.data = data;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }
}

class Coustom implements Comparator<Info> {
    @Override
    public int compare(Info o1, Info o2) {
        return o1.data - o2.data;
    }
    
}

public class MergeKSortedArray {
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Info> pq = new PriorityQueue<>(new Coustom());

        for (int row = 0; row < k; row++) {
            int element = arr[row][0];
            Info temp = new Info(element, row, 0);
            pq.add(temp);
        }

        while (!pq.isEmpty()) {
            Info temp = pq.poll();
            int data = temp.data;
            int rowIndex = temp.rowIndex;
            int colIndex = temp.colIndex;

            ans.add(data);

            if (colIndex + 1 < arr[0].length) {
                int element = arr[rowIndex][colIndex + 1];
                pq.add(new Info(element, rowIndex, colIndex + 1));
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