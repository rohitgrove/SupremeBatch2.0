import java.util.Stack;

public class LargestRectInHistogram {
    public static int[] nextSmaller(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.add(-1);
        int ans[] = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            int curr = heights[i];
            while (st.peek() != -1 && heights[st.peek()] >= curr) {
                st.pop();
            }

            if (st.peek() == -1) {
                ans[i] = heights.length;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }

        return ans;
    }

    public static int[] prevSmaller(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.add(-1);
        int ans[] = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {

            int curr = heights[i];
            while (st.peek() != -1 && heights[st.peek()] >= curr) {
                st.pop();
            }

            ans[i] = st.peek();
            st.push(i);
        }

        return ans;
    }

    public static int largestRectangleArea(int[] heights) {
        int next[] = nextSmaller(heights);
        int prev[] = prevSmaller(heights);

        int area[] = new int[heights.length];
        for (int i = 0; i < area.length; i++) {
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
