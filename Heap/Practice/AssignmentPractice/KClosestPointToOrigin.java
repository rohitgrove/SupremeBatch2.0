import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

class Comp implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        int distA = o1[0] * o1[0] + o1[1] * o1[1]; 
        int distB = o2[0] * o2[0] + o2[1] * o2[1];
        return Integer.compare(distA, distB); 
    }
}

public class KClosestPointToOrigin {
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comp());

        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
        }

        int ans[][] = new int[k][2];

        for (int i = 0; i < k; i++) {
            int[] front = pq.poll();
            ans[i] = front;
        }

        return ans;
    }
    
    public static void printArr(int[][] result) {
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }

    public static void main(String[] args) {
        // Test case 1
        int[][] points1 = { { 1, 3 }, { -2, 2 } };
        int k1 = 1;
        int[][] result1 = kClosest(points1, k1);
        System.out.println("Test Case 1:");
        printArr(result1);

        // Test case 2
        int[][] points2 = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k2 = 2;
        int[][] result2 = kClosest(points2, k2);
        System.out.println("Test Case 2:");
        printArr(result2);
    }
}
