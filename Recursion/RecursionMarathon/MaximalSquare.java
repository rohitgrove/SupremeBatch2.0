public class MaximalSquare {
    static int maxi;
    public static int solve(char[][] matrix, int r, int c, int row, int col) {
        // base case
        if (r >= row || c >= col) {
            return 0;
        }

        // explore all 3 direction
        int right = solve(matrix, r, c + 1, row, col);
        int diagnol = solve(matrix, r + 1, c + 1, row, col);
        int down = solve(matrix, r + 1, c, row, col);

        // check can we build square from current position
        if (matrix[r][c] == '1') {
            int ans = 1 + Math.min(right, Math.min(diagnol, down));
            // ye important hai
            maxi = Math.max(maxi, ans);
            return ans;
        } else {
            // agar 0 par khade ho toh answer bhi zero hoga
            return 0;
        }
    }

    public static int maximalSquare(char[][] matrix) {
        int r = 0;
        int c = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        maxi = 0;
        solve(matrix, r, c, row, col);
        return maxi * maxi;
    }

    public static void main(String[] args) {
        char matrix1[][] = { { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(maximalSquare(matrix1));
        char matrix2[][] = { { '0', '1' },
                { '1', '0' } };
        System.out.println(maximalSquare(matrix2));
    }
}
