import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    public static void solveForMedian(double[] median, PriorityQueue<Integer> maxi, PriorityQueue<Integer> mini, int element) {
        if (maxi.size() == mini.size()) {
            if (element > median[0]) {
                mini.add(element);
                median[0] = mini.peek();
            } else {
                maxi.add(element);
                median[0] = maxi.peek();
            }
        } else if (maxi.size() == mini.size() + 1) {
            if (element > median[0]) {
                mini.add(element);
            } else {
                int maxTop = maxi.poll();
                mini.add(maxTop);
                maxi.add(element);
            }
            median[0] = (mini.peek() + maxi.peek()) / 2.0;
        } else if (mini.size() == maxi.size() + 1) {
            if (element > median[0]) {
                int minTop = mini.poll();
                maxi.add(minTop);
                mini.add(element);
            } else {
                maxi.add(element);
            }
            median[0] = (mini.peek() + maxi.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 10, 8, 4, 2, 3, 15};
        int n = 7;

        double[] median = {0.0};
        PriorityQueue<Integer> maxi = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mini = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int element = arr[i];
            solveForMedian(median, maxi, mini, element);
            System.out.println("Median found: " + median[0]);
        }
    }
}
