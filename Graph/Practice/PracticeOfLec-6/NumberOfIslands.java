import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(i, j, visited, grid);
                    count++;
                }
            }
        }

        return count;
    }

    public static void bfs(int row, int col, boolean[][] visited, char[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { row, col });
        visited[row][col] = true;

        int direction[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int cell[] = q.poll();
            int frontNodeRow = cell[0];
            int frontNodeCol = cell[1];

            for (int dir[] : direction) {
                int newRow = frontNodeRow + dir[0];
                int newCol = frontNodeCol + dir[1];
                if (isSafe(newRow, newCol, grid, visited)) {
                    visited[newRow][newCol] = true;
                    q.add(new int[] { newRow, newCol });
                }
            }
        }
    }

    public static boolean isSafe(int newRow, int newCol, char grid[][], boolean visted[][]) {
        return (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && !visted[newRow][newCol]
                && grid[newRow][newCol] == '1');
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
