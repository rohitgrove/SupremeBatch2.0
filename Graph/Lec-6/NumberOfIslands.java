import java.util.Queue;
import java.util.LinkedList;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    public static boolean isSafe(int nextRow, int nextCol, char grid[][], boolean visited[][]) {
        return (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length
                && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == '1');
    }

    public static void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { row, col });

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!q.isEmpty()) {
            int frontCell[] = q.poll();
            int currRow = frontCell[0];
            int currCol = frontCell[1];

            for (int dir[] : directions) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if (isSafe(nextRow, nextCol, grid, visited)) {
                    visited[nextRow][nextCol] = true;
                    q.add(new int[] { nextRow, nextCol });
                }
            }
        }
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