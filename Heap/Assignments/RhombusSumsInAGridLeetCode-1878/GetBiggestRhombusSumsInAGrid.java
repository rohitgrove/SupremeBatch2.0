import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class GetBiggestRhombusSumsInAGrid {
    public static boolean checkBounds(int[][] grid, Pair[] v) {
        int m = grid.length;
        int n = grid[0].length;
        for (Pair pt : v) {
            if (pt.row < 0 || pt.row >= m || pt.col < 0 || pt.col >= n) {
                return false;
            }
        }
        return true;
    }

    public static boolean getAllVertices(int[][] grid, Pair[] v, Pair roCo, int delta) {
        Pair A = new Pair(roCo.row - delta, roCo.col);
        Pair B = new Pair(roCo.row, roCo.col + delta);
        Pair C = new Pair(roCo.row + delta, roCo.col);
        Pair D = new Pair(roCo.row, roCo.col - delta);
        v[0] = A;
        v[1] = B;
        v[2] = C;
        v[3] = D;
        return checkBounds(grid, v);
    }

    public static void getAllSum(int[][] grid, int cx, int cy, PriorityQueue<Integer> pq) {
        // push RH sum of RH with area 0
        pq.offer(grid[cx][cy]);

        int delta = 1;
        Pair[] v = new Pair[4];

        while (getAllVertices(grid, v, new Pair(cx, cy), delta)) {
            int sum = 0;

            // Sum the border vertices
            sum += grid[v[0].row][v[0].col];
            sum += grid[v[1].row][v[1].col];
            sum += grid[v[2].row][v[2].col];
            sum += grid[v[3].row][v[3].col];

            // Sum the cells between A and B (top to right)
            for (int i = 1; i < delta; i++) {
                sum += grid[v[0].row + i][v[0].col + i];
            }

            // Sum the cells between B and C (right to bottom)
            for (int i = 1; i < delta; i++) {
                sum += grid[v[1].row + i][v[1].col - i];
            }

            // Sum the cells between C and D (bottom to left)
            for (int i = 1; i < delta; i++) {
                sum += grid[v[2].row - i][v[2].col - i];
            }

            // Sum the cells between D and A (left to top)
            for (int i = 1; i < delta; i++) {
                sum += grid[v[3].row - i][v[3].col + i];
            }

            pq.add(sum);
            delta++;
        }
    }

    public static boolean canPush(List<Integer> ans, int top) {
        for (Integer value : ans) {
            if (value == top) {
                return false;
            }
        }

        return true;
    }

    public static int[] getBiggestThree(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                getAllSum(grid, i, j, pq);
            }
        }

        while (!pq.isEmpty() && ans.size() < 3) {
            int top = pq.poll();
            if (canPush(ans, top)) {
                ans.add(top);
            }
        }

        int res[] = new int[ans.size()];
        int idx = 0;
        for (int val : ans) {
            res[idx++] = val;
        }
        return res;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int grid1[][] = { { 3, 4, 5, 1, 3 },
                { 3, 3, 4, 2, 3 },
                { 20, 30, 200, 40, 10 },
                { 1, 5, 5, 4, 1 },
                { 4, 3, 2, 2, 5 } };
        printArr(getBiggestThree(grid1));
        int grid2[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        printArr(getBiggestThree(grid2));
    }
}
