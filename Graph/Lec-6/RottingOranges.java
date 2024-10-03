import java.util.Queue;
import java.util.LinkedList;

public class RottingOranges {
    public static boolean isSafe(int newRow, int newCol, int grid[][]) {
        return (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] == 1);
    }

    public static int orangesRotting(int[][] grid) {
        // first and second index -> coordinates
        // third index -> time
        Queue<int[]> q = new LinkedList<>();

        int minTime = 0;

        // find all rotton oranganges and put them in queue
        int n = grid.length;
        int m = grid[0].length;
        // intial state
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    // src node ka time 0 set krre hai
                    q.add(new int[] { i, j, 0 });
                }
            }
        }

        int direction[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // bfs logic
        while (!q.isEmpty()) {
            int frontNode[] = q.poll();

            int frontNodeRow = frontNode[0];
            int frontNodeCol = frontNode[1];
            int frontNodeTime = frontNode[2];
            
            for (int dir[] : direction) {
                int newRow = frontNodeRow + dir[0];
                int newCol = frontNodeCol + dir[1];

                if (isSafe(newRow, newCol, grid)) {
                    q.add(new int[] { newRow, newCol, frontNodeTime + 1 });
                    minTime = Math.max(minTime, frontNodeTime + 1);
                    // mark this node as rotten
                    grid[newRow][newCol] = 2;
                }
            }
        }

        // yaha tk aapne jitne orange rooten karne the aapne karliye hai
        // ab i want to check maine saare orange rotten kardiye ?
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
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
