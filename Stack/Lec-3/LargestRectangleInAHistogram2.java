import java.util.Stack;

public class LargestRectangleInAHistogram2 {
    public static int[] nextSmallerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int adult = st.pop();
                ans[adult] = i;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            ans[st.pop()] = arr.length;
        }

        return ans;
    }

    public static int[] prevSmallerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int adult = st.pop();
                ans[adult] = i;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            ans[st.pop()] = -1;
        }

        return ans;
    }

    public static int largestRectangleArea(int[] heights) {
        int next[] = nextSmallerElement(heights);
        int prev[] = prevSmallerElement(heights);

        int area[] = new int[next.length];
        for (int i = 0; i < next.length; i++) {
            int width = next[i] - prev[i] - 1;
            int length = heights[i];
            int currArea = width * length;
            area[i] = currArea;
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < area.length; i++) {
            maxi = Math.max(maxi, area[i]);
        }

        return maxi;
    }

    public static void main(String[] args) {
        int heights1[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights1));
        int heights2[] = { 8, 4, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights2));
    }
}
