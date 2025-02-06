import java.util.Stack;

public class MaximalRectangle {
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

    public static int maximalRectangle(char[][] matrix) {
        int mat[][] = new int[matrix.length][matrix[0].length];
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = matrix[i][j] - '0';
            }
        }

        int area = largestRectangleArea(mat[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // let's update current row with previous values;
                if (mat[i][j] != 0) {
                    mat[i][j] += mat[i - 1][j];
                } else {
                    mat[i][j] = 0;
                }
            }

            area = Math.max(area, largestRectangleArea(mat[i]));
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
