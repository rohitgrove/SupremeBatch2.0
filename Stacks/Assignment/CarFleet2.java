import java.util.Arrays;
import java.util.Stack;

public class CarFleet2 {
    public static double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] answer = new double[n];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Check if car ahead of current car is faster
            while (!stack.isEmpty() && cars[stack.peek()][1] >= cars[i][1]) {
                stack.pop();
            }

            while (!stack.isEmpty()) {
                double colTime = (double) (cars[stack.peek()][0] - cars[i][0]) / (cars[i][1] - cars[stack.peek()][1]);
                if (answer[stack.peek()] == -1 || colTime <= answer[stack.peek()]) {
                    answer[i] = colTime;
                    break;
                }
                stack.pop();
            }

            stack.push(i);
        }

        return answer;
    }

    public static void printArr(double arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int cars1[][] = { { 1, 2 }, { 2, 1 }, { 4, 3 }, { 7, 2 } };
        printArr(getCollisionTimes(cars1));
        int cars2[][] = { { 3, 4 }, { 5, 4 }, { 6, 3 }, { 9, 1 } };
        printArr(getCollisionTimes(cars2));
    }
}
