public class NumberOfIslands {
    public static boolean dfs(char grid[][], int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0' || grid[row][col] == 'x') {
            return false;
        }

        grid[row][col] = 'x';
        boolean marked = true;

        boolean up = dfs(grid, row - 1, col);
        boolean down = dfs(grid, row + 1, col);
        boolean left = dfs(grid, row, col - 1);
        boolean right = dfs(grid, row, col + 1);

        boolean baakiKaAnswer = up || down || left || right;

        return marked || baakiKaAnswer;
    }

    public static int numIslands(char grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += dfs(grid, i, j) ? 1 : 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        char grid1[][] = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.println(numIslands(grid1)); // Output: 1

        char grid2[][] = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(numIslands(grid2)); // Output: 3
    }
}