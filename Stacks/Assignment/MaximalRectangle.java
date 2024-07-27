import java.util.Stack;

public class MaximalRectangle {
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

    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int v[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                v[i][j] = matrix[i][j] - '0';
            }
        }

        int area = largestRectangleArea(v[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // let's update current row with previous values;
                if (v[i][j] == 1) {
                    v[i][j] += v[i - 1][j];
                } else {
                    v[i][j] = 0;
                }
            }
            area = Math.max(area, largestRectangleArea(v[i]));
        }

        return area;
    }

    public static void main(String[] args) {
        char matrix[][] = { { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(maximalRectangle(matrix));
    }
}
