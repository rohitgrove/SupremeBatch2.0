public class MaximalSquare {
    public static int solve(char[][] matrix, int i, int j, int row, int col, int maxi[]) {
        if (i >= row || j >= col) {
            return 0;
        }

        int right = solve(matrix, i, j + 1, row, col, maxi);
        int diagnal = solve(matrix, i + 1, j + 1, row, col, maxi);
        int down = solve(matrix, i + 1, j, row, col, maxi);

        if (matrix[i][j] == '1') {
            int ans = 1 + Math.min(right, Math.min(down, diagnal));
            maxi[0] = Math.max(maxi[0], ans);
            return ans;
        } else {
            return 0;
        }
    }

    public static int maximalSquare(char[][] matrix) {
        int i = 0;
        int j = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int maxi[] = { 0 };
        solve(matrix, i, j, row, col, maxi);
        int area = maxi[0] * maxi[0];
        return area;
    }

    public static void main(String[] args) {
        char matrix[][] = { { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(maximalSquare(matrix));
    }
}
