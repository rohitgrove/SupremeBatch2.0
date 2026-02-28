import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInAStream {
    public static void solveForMedian(double[] median, PriorityQueue<Integer> maxi, PriorityQueue<Integer> mini,
            int element) {
        if (maxi.size() == mini.size()) {
            if (element > median[0]) {
                mini.offer(element);
                median[0] = mini.peek();
            } else {
                maxi.offer(element);
                median[0] = maxi.peek();
            }
        } else if (maxi.size() == mini.size() + 1) {
            if (element > median[0]) {
                mini.offer(element);
            } else {
                int maxiTop = maxi.poll();
                mini.offer(maxiTop);
                maxi.offer(element);
            }
            median[0] = (mini.peek() + maxi.peek()) / 2.0;
        } else if (mini.size() == maxi.size() + 1) {
            if (element > median[0]) {
                int minTop = mini.poll();
                maxi.offer(minTop);
                mini.offer(element);
            } else {
                maxi.offer(element);
            }
            median[0] = (mini.peek() + maxi.peek()) / 2.0;
        }
    }

    public static int[] findMedian(int[] arr, int n) {
        int ans[] = new int[n];
        double median[] = new double[1];
        PriorityQueue<Integer> maxi = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mini = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int element = arr[i];
            solveForMedian(median, maxi, mini, element);
            ans[i] = (int) median[0];
        }

        return ans;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 12, 10, 8, 4, 2, 3, 15 };
        int ans[] = findMedian(arr, arr.length);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
