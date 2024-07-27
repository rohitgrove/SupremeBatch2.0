import java.util.Stack;

public class LargestHistogram2 {
    public static int[] nextSmaller(int[] heights, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && heights[i] < heights[st.peek()]) {
                // means, ith elemnt is the nextsmaller of the element index present in stack
                int kids = st.pop();
                ans[kids] = i;
            }
            st.push(i);
        }

        while (!st.empty()) {
            ans[st.pop()] = n;
        }

        return ans;
    }

    public static int[] prevSmaller(int[] heights, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && heights[i] < heights[st.peek()]) {
                // means, ith elemnt is the prevsmaller of the element index present in stack
                int kids = st.pop();
                ans[kids] = i;
            }
            st.push(i);
        }

        while (!st.empty()) {
            ans[st.pop()] = -1;
        }

        return ans;
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }

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
        int heights2[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println(largestRectangleArea(heights2));
    }
}
