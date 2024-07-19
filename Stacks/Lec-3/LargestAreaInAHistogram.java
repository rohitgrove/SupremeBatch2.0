import java.util.Stack;

public class LargestAreaInAHistogram {
    public static int[] nextSmaller(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        st.push(-1);
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            while (st.peek() != -1 && arr[st.peek()] >= curr) {
                st.pop();
            }
            if (st.peek() == -1) {
                ans[i] = n;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public static int[] prevSmaller(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        st.push(-1);
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            while (st.peek() != -1 && arr[st.peek()] >= curr) {
                st.pop();
            }
            ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 1)
            return heights[0];

        int[] leftToRight = prevSmaller(heights, n);
        int[] rightToLeft = nextSmaller(heights, n);
        int LargestArea = Integer.MIN_VALUE;

        for (int i = 0; i < leftToRight.length; i++) {
            int width = rightToLeft[i] - leftToRight[i] - 1;
            int length = heights[i];
            int currArea = width * length;
            LargestArea = Math.max(LargestArea, currArea);
        }

        return LargestArea;
    }

    public static void main(String[] args) {
        int heights[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
    }
}