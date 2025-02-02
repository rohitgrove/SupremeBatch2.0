import java.util.Stack;

public class LargestRectangleInAHistogram {
    public static int[] nextSmallerElement(int arr[]) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];
            // answer find karo curr k liye
            while (st.peek() != -1 && arr[st.peek()] >= curr) {
                st.pop();
            }

            if (st.peek() == -1) {
                ans[i] = arr.length;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }

        return ans;
    }

    public static int[] prevSmallerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int ans[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
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
