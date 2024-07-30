import java.util.Stack;

public class DailyTemprature {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!st.empty() && temperatures[i] > temperatures[st.peek()]) {
                ans[st.peek()] = i - st.peek();
                st.pop();
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
        int temperatures2[] = { 30, 40, 50, 60 };
        int temperatures3[] = { 30, 60, 90 };
        System.out.println("Tempratures");
        printArr(temperatures1);
        printArr(temperatures2);
        printArr(temperatures3);

        System.out.println("How Much day waited for next warmer day");
        int[] result1 = dailyTemperatures(temperatures1);
        int[] result2 = dailyTemperatures(temperatures2);
        int[] result3 = dailyTemperatures(temperatures3);
        printArr(result1);
        printArr(result2);
        printArr(result3);
    }
}
