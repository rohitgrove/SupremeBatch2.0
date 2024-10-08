import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class MinimumMultiplicationsToReachEnd {
    public static int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        int mod = 100000;

        int ans[] = new int[100000]; // will also mark as visited array in BFS
        Arrays.fill(ans, -1);
        ans[start] = 0;
        q.add(start);
        while (!q.isEmpty()) {
            int front = q.poll();
            if (front == end) {
                return ans[end];
            }

            for (int it : arr) {
                int newNode = (front * it) % mod;
                if (ans[newNode] == -1) {
                    ans[newNode] = ans[front] + 1;
                    q.add(newNode);
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int arr1[] = { 2, 5, 7 }, start1 = 3, end1 = 30;
        System.out.println(minimumMultiplications(arr1, start1, end1));
        int arr2[] = { 3, 4, 65 }, start2 = 7, end2 = 66175;
        System.out.println(minimumMultiplications(arr2, start2, end2));
    }
}
