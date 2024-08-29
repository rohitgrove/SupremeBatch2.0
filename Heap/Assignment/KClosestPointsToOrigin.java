import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

class MyComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        int distA = a[0] * a[0] + a[1] * a[1];
        int distB = b[0] * b[0] + b[1] * b[1];
        return Integer.compare(distA, distB);
    }
}

public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator()); // min heap based on origin.

        for (int[] p : points) {
            pq.offer(p);
        }

        int[][] ans = new int[k][2]; // 2D array to store the result

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
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