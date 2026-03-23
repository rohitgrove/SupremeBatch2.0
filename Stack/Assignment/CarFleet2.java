import java.util.Arrays;
import java.util.Stack;

public class CarFleet2 {
    public static double[] getCollisionTimes(int[][] cars) {
        double answer[] = new double[cars.length]; // collision time of ith car with the next car.
        Arrays.fill(answer, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = cars.length - 1; i >= 0; i--) {
            // check if car ahead of current car is faster?
            while (!st.isEmpty() && cars[st.peek()][1] >= cars[i][1]) {
                st.pop();
            }

            while (!st.isEmpty()) {
                double colTime = (double) (cars[st.peek()][0] - cars[i][0]) / (cars[i][1] - cars[st.peek()][1]);
                if (answer[st.peek()] == -1 || colTime <= answer[st.peek()]) {
                    answer[i] = colTime;
                    break;
                }
                st.pop();
            }
            st.push(i);
        }

        return answer;
    }

    public static void printArr(double ans[]) {
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int cars1[][] = { { 1, 2 },
                { 2, 1 },
                { 4, 3 },
                { 7, 2 } };
        printArr(getCollisionTimes(cars1));
        int cars2[][] = { { 3, 4 },
                { 5, 4 },
                { 6, 3 },
                { 9, 1 } };
        printArr(getCollisionTimes(cars2));
    }
}
