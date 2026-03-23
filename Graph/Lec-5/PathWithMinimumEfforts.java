import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEfforts {
    public static boolean isSafe(int newX, int newY, int row, int col, int[][] diff, int currX, int currY) {
        return newX >= 0 && newY >= 0 && newX < row && newY < col && diff[currX][currY] < diff[newX][newY];
    }

    public static int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> mini = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int row = heights.length;
        int col = heights[0].length;
        int[][] diff = new int[row][col];
        for (int[] d : diff) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        int destRow = row - 1;
        int destCol = col - 1;

        // initial state
        // set srcn ka distance 0
        diff[0][0] = 0;
        // min heap meentry for src push krdo
        mini.offer(new int[] { 0, 0, 0 });

        // now we can travel to all nbr i.e. top, down, left, right
        int[] rowDirection = { -1, 0, 1, 0 };
        int[] colDirection = { 0, 1, 0, -1 };

        while (!mini.isEmpty()) {
            int[] top = mini.poll();
            int currDiff = top[0];
            int currRow = top[1];
            int currCol = top[2];

            for (int i = 0; i < 4; i++) {
                int newRow = currRow + rowDirection[i];
                int newCol = currCol + colDirection[i];
                if (isSafe(newRow, newCol, row, col, diff, currRow, currCol)) {
                    int maxDiff = Math.max(currDiff, Math.abs(heights[currRow][currCol] - heights[newRow][newCol]));
                    if (maxDiff < diff[newRow][newCol]) {
                        diff[newRow][newCol] = maxDiff;
                        if (newRow != destRow || newCol != destCol) {
                            mini.offer(new int[] { diff[newRow][newCol], newRow, newCol });
                        }
                    }
                }
            }
        }

        return diff[destRow][destCol];
    }

    public static void main(String[] args) {
        int heights1[][] = { { 1, 2, 2 },
                { 3, 8, 2 },
                { 5, 3, 5 } };
        System.out.println(minimumEffortPath(heights1));
        int heights2[][] = { { 1, 2, 3 },
                { 3, 8, 4 },
                { 5, 3, 5 } };
        System.out.println(minimumEffortPath(heights2));
        int heights3[][] = { { 1, 2, 1, 1, 1 },
                { 1, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 1 },
                { 1, 2, 1, 2, 1 },
                { 1, 1, 1, 2, 1 } };
        System.out.println(minimumEffortPath(heights3));
    }
}
