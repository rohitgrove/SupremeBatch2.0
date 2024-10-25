public class RottingOranges {
    public static void dfs(int[][] grid, int i, int j, int min) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0
                || (grid[i][j] < min && grid[i][j] > 1)) {
            return;
        }

        grid[i][j] = min;
        dfs(grid, i + 1, j, min + 1);
        dfs(grid, i - 1, j, min + 1);
        dfs(grid, i, j + 1, min + 1);
        dfs(grid, i, j - 1, min + 1);
    }

    public static int orangesRotting(int[][] grid) {
        int min = 2;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    // dfs
                    dfs(grid, i, j, min);
                }
            }
        }

        for (int[] arr : grid) {
            for (int i : arr) {
                if (i == 1) {
                    return -1;
                }
                min = Math.max(min, i);
            }
        }

        return min - 2;
    }

    public static void main(String[] args) {
        int grid1[][] = { { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 } };
        System.out.println(orangesRotting(grid1));
        int grid2[][] = { { 2, 1, 1 },
                { 0, 1, 1 },
                { 1, 0, 1 } };
        System.out.println(orangesRotting(grid2));
    }
}