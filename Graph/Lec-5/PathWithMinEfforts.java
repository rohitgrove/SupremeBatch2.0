import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinEfforts {
    public static boolean isSafe(int newRow, int newCol, int rows, int cols) {
        return (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols);
    }

    public static int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> mini = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int rows = heights.length;
        int cols = heights[0].length;

        int minDiff[][] = new int[rows][cols];
        for (int[] row : minDiff) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Define possible directions (top, down, left, right)
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        // intial state
        // set srcn ka distance 0
        minDiff[0][0] = 0;
        mini.add(new int[] { 0, 0, 0 });

        while (!mini.isEmpty()) {
            int[] cell = mini.poll();
            int currRow = cell[0];
            int currCol = cell[1];
            int currDiff = cell[2];

            // If we reached the bottom-right cell, return the minimum effort
            if (currRow == rows - 1 && currCol == cols - 1) {
                return currDiff;
            }

            // now we can travel to all nbr i.e. top, down, left, right
            for (int dir[] : directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                if (isSafe(newRow, newCol, rows, cols)) {
                    int maxDiff = Math.max(currDiff, Math.abs(heights[currRow][currCol] - heights[newRow][newCol]));
                    // entry create karo min heap me & check can we update diff array
                    if (maxDiff < minDiff[newRow][newCol]) {
                        minDiff[newRow][newCol] = Math.min(minDiff[newRow][newCol], maxDiff);
                        mini.add(new int[] { newRow, newCol, maxDiff });
                    }
                }
            }
        }

        return -1;
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
