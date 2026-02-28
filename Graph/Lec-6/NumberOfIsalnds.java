import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsalnds {
    public static boolean isSafe(int newRow, int newCol, char grid[][], boolean vis[][]) {
        return newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                && grid[newRow][newCol] == '1' && !vis[newRow][newCol];
    }

    public static void bfs(int row, int col, char[][] grid, boolean vis[][]) {
        Queue<int[]> q = new LinkedList<>();
        // intial state
        q.offer(new int[] { row, col });
        vis[row][col] = true;

        while (!q.isEmpty()) {
            int[] frontNode = q.poll();

            int tempRow = frontNode[0];
            int tempCol = frontNode[1];

            int dx[] = { -1, 0, 1, 0 };
            int dy[] = { 0, 1, 0, -1 };
            for (int i = 0; i < 4; i++) {
                int newRow = tempRow + dx[i];
                int newCol = tempCol + dy[i];
                if (isSafe(newRow, newCol, grid, vis)) {
                    q.offer(new int[] { newRow, newCol });
                    vis[newRow][newCol] = true;
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int count = 0;
        // hr node k liye loop laga dia
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    bfs(i, j, grid, vis);
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
