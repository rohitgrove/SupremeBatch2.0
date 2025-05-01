import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static boolean isSafe(char[][] grid, int row, int col, boolean[][] vis) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == '1'
                && !vis[row][col];
    }

    public static void bfs(char[][] grid, int row, int col, boolean[][] vis) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] { row, col });
        vis[row][col] = true;

        while (!q.isEmpty()) {
            int[] frontNode = q.poll();
            int currRow = frontNode[0];
            int currCol = frontNode[1];

            int dx[] = { -1, 0, 1, 0 };
            int dy[] = { 0, 1, 0, -1 };

            for (int i = 0; i < 4; i++) {
                int newRow = currRow + dx[i];
                int newCol = currCol + dy[i];
                if (isSafe(grid, newRow, newCol, vis)) {
                    q.offer(new int[] { newRow, newCol });
                    vis[newRow][newCol] = true;
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean vis[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    bfs(grid, i, j, vis);
                    count++;
                }
            }
        }

        return count;
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
