public class MaximalSquare {
    public static int solve(char[][] matrix, int i, int j, int row, int col, int[] maxi) {
        // Base case
        if (i >= row || j >= col) {
            return 0;
        }

        // Explore all 3 directions
        int right = solve(matrix, i, j + 1, row, col, maxi);
        int diagnol = solve(matrix, i + 1, j + 1, row, col, maxi);
        int down = solve(matrix, i + 1, j, row, col, maxi);

        // Check if we can build a square from the current position
        if (matrix[i][j] == '1') {
            int ans = 1 + Math.min(right, Math.min(down, diagnol));
            // Update maxi
            maxi[0] = Math.max(maxi[0], ans);
            return ans;
        } else {
            // If standing on '0', answer is also zero
            return 0;
        }
    }

    public static int maximalSquare(char[][] matrix) {
        int i = 0;
        int j = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] maxi = new int[1];
        int ans = solve(matrix, i, j, row, col, maxi);
        return maxi[0] * maxi[0];
    }

    public static void main(String[] args) {
        char matrix[][] = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));   
    }
}