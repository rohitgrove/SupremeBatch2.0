import java.util.PriorityQueue;

public class FractionalKnapsack {
    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        double valWtRatio[] = new double[n];
        for (int i = 0; i < n; i++) {
            Double ratio = (val[i] * 1.0) / wt[i];
            valWtRatio[i] = ratio;
        }

        PriorityQueue<Pair<Double, Pair<Integer, Integer>>> maxi = new PriorityQueue<>(new Compare());
        for (int i = 0; i < n; i++) {
            maxi.add(new Pair<>(valWtRatio[i], new Pair<>(val[i], wt[i])));
        }
        // max heap is ready
        double totalVal = 0;
        while (capacity != 0 && !maxi.isEmpty()) {
            Pair<Double, Pair<Integer, Integer>> front = maxi.poll();
            Double ratio = front.key;
            int value = front.value.key;
            int weight = front.value.value;

            // max heap is ready
            if (capacity >= weight) {
                totalVal += value;
                capacity -= weight;
            } else {
                // fractional insert hoga
                double valueToInclude = ratio * capacity;
                totalVal += valueToInclude;
                break;
            }
        }
        return totalVal;
    }

    public static void main(String[] args) {
        int val1[] = { 60, 100, 120 }, wt1[] = { 10, 20, 30 }, capacity1 = 50;
        System.out.println(fractionalKnapsack(val1, wt1, capacity1));
        int val2[] = { 60, 100 }, wt2[] = { 10, 20 }, capacity2 = 50;
        System.out.println(fractionalKnapsack(val2, wt2, capacity2));
        int val3[] = { 10, 20, 30 }, wt3[] = { 5, 10, 15 }, capacity3 = 100;
        System.out.println(fractionalKnapsack(val3, wt3, capacity3));
    }
}
