import java.util.Stack;

public class DailyTempratures {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int kids = st.pop();
                ans[kids] = i - kids;
            }
            st.push(i);
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
        int temperatures1[] = { 73, 74, 75, 71, 69, 72, 76, 73 };
        printArr(dailyTemperatures(temperatures1));
        int temperatures2[] = { 30, 40, 50, 60 };
        printArr(dailyTemperatures(temperatures2));
        int temperatures3[] = { 30, 60, 90 };
        printArr(dailyTemperatures(temperatures3));
    }
}
