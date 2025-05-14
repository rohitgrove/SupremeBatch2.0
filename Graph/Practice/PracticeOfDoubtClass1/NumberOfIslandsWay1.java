public class NumberOfIslandsWay1 {
    public static boolean dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0'
                || grid[row][col] == 'x') {
            return false;
        }

        grid[row][col] = 'x';
        boolean marked = true;

        boolean up = dfs(grid, row - 1, col);
        boolean down = dfs(grid, row + 1, col);
        boolean right = dfs(grid, row, col + 1);
        boolean left = dfs(grid, row, col - 1);

        boolean ans = up || down || right || left;

        return marked || ans;
    }

    public static int numIslands(char[][] grid) {
        int ans = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    ans += dfs(grid, r, c) ? 1 : 0;
                }
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
        System.out.println(numIslands(grid1));

        char grid2[][] = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(numIslands(grid2));
    }
}