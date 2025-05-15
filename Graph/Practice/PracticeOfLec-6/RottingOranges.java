import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static boolean isSafe(int newX, int newY, int temp[][]) {
        return newX >= 0 && newY >= 0 && newX < temp.length && newY < temp[0].length && temp[newX][newY] == 1;
    }

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int temp[][] = grid.clone();
        int minTime = 0;

        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 2) {
                    q.offer(new int[] { i, j, 0 });
                }
            }
        }

        int dx[] = { -1, 0, 1, 0 };
        int dy[] = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int frontNode[] = q.poll();

            int currNodeRow = frontNode[0];
            int currNodeCol = frontNode[1];
            int currNodeTime = frontNode[2];
            
            for (int i = 0; i < 4; i++) {
                int newRow = currNodeRow + dx[i];
                int newCol = currNodeCol + dy[i];

                if (isSafe(newRow, newCol, grid)) {
                    q.add(new int[] { newRow, newCol, currNodeTime + 1 });
                    minTime = Math.max(minTime, currNodeTime + 1);
                    // mark this node as rotten
                    grid[newRow][newCol] = 2;
                }
            }
        }


        // yaha tk aapne jitne oranges rotten krne the
        // aapne kar liye h
        // ab i want to check k kya maine saare oranges rotten krdiye?
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minTime;
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
