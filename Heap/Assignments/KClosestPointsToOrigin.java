import java.util.Comparator;
import java.util.PriorityQueue;

class Compare implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        int distA = o1[0] * o1[0] + o1[1] * o1[1];
        int distB = o2[0] * o2[0] + o2[1] * o2[1];
        return Integer.compare(distA, distB);
    }
}

public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int k) {
        int ans[][] = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Compare());

        for (int[] row : points) {
            pq.offer(new int[] { row[0], row[1] });
        }

        while (!pq.isEmpty() && k-- > 0) {
            int top[] = pq.poll();
            ans[k] = top;
        }

        return ans;
    }

    public static void printArr(int arr[][]) {
        for (int[] Array : arr) {
            for (int ele : Array) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int points1[][] = { { 1, 3 },
                { -2, 2 } };
        printArr(kClosest(points1, 1));

        int points2[][] = { { 3, 3 },
                { 5, -1 },
                { -2, 4 } };
        printArr(kClosest(points2, 2));
    }
}
