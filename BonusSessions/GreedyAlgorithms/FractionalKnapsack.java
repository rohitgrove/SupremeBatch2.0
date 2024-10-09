import java.util.Comparator;
import java.util.Arrays;

public class FractionalKnapsack {
    public static double fractionalKnapsack(int w, int value[], int weight[], int n) {
        double ratio[][] = new double[value.length][2];
        // 0th col => idx; 1st col => ratio

        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }

        // ascending
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        int finalVal = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) { // include full item
                finalVal += value[idx];
                capacity -= weight[idx];
            } else {
                // include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        return finalVal;
    }

    public static void main(String[] args) {
        int n = 3, w = 50, value[] = { 60, 100, 120 }, weight[] = { 10, 20, 30 };
        System.out.println(fractionalKnapsack(w, value, weight, n));
        int n1 = 2, w1 = 50, value1[] = { 60, 100 }, weight1[] = { 10, 20 };
        System.out.println(fractionalKnapsack(w1, value1, weight1, n1));
    }
}
