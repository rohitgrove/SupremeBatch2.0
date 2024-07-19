import java.util.*;

public class Histogram {
    public static int[] nextSmaller(int nums[]) {
        int n = nums.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = n - 1; i >= 0; i--) {
            int curr = nums[i];
            while (st.peek() != -1 && nums[st.peek()] >= curr) {
                st.pop();
            }

            if (st.peek() == -1) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.add(i);
        }

        return ans;
    }

    public static int[] prevSmaller(int nums[]) {
        int n = nums.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            while (st.peek() != -1 && nums[st.peek()] >= curr) {
                st.pop();
            }
            ans[i] = st.peek();

            st.add(i);
        }

        return ans;
    }

    public static int largestRectangleArea(int[] heights) {
        int nextSmaller[] = nextSmaller(heights);
        int prevSmaller[] = prevSmaller(heights);

        int LargestArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = width * heights[i];
            LargestArea = Math.max(LargestArea, area);
        }

        return LargestArea;
    }

    public static void main(String[] args) {
        int heights[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
    }
}
