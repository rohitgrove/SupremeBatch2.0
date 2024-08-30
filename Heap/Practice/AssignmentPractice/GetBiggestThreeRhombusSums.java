import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

class Pair {
    public int row;
    public int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class GetBiggestThreeRhombusSums {
    public static boolean checkIsNotOutOfBound(int[][] grid, Pair[] v) {
        int n = grid.length;
        int m = grid[0].length;

        for (Pair p : v) {
            if (p.row < 0 || p.row >= n || p.col < 0 || p.col >= m) {
                return false;
            }
        }

        return true;
    }

    public static boolean giveAllVertices(int[][] grid, Pair c, int delta, Pair[] v) {
        Pair A = new Pair(c.row - delta, c.col);
        Pair B = new Pair(c.row, c.col + delta);
        Pair C = new Pair(c.row + delta, c.col);
        Pair D = new Pair(c.row, c.col - delta);
        v[0] = A;
        v[1] = B;
        v[2] = C;
        v[3] = D;

        return checkIsNotOutOfBound(grid, v);
    }

    public static void getAllSum(int r, int c, PriorityQueue<Integer> pq, int[][] grid) {
        pq.add(grid[r][c]);
        Pair v[] = new Pair[4];
        int delta = 1;

        while (giveAllVertices(grid, new Pair(r, c), delta, v)) {
            Pair A = v[0];
            Pair B = v[1];
            Pair C = v[2];
            Pair D = v[3];
            int csum = grid[A.row][A.col] + grid[B.row][B.col] + grid[C.row][C.col] + grid[D.row][D.col];

            for (int i = 1; i < (B.row - A.row); i++) {
                csum += grid[A.row + i][A.col + i];
            }

            for (int i = 1; i < (C.row - B.row); i++) {
                csum += grid[B.row + i][B.col - i];
            }

            for (int i = 1; i < (C.row - D.row); i++) {
                csum += grid[C.row - i][C.col - i];
            }

            for (int i = 1; i < (D.row - A.row); i++) {
                csum += grid[D.row - i][D.col + i];
            }

            pq.add(csum);
            delta++;
        }
    }

    public static boolean canInsert(ArrayList<Integer> ans, int top) {
        for (Integer ele : ans) {
            if (ele == top) {
                return false;
            }
        }
        return true;
    }

    public static int[] getBiggestThree(int[][] grid) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                getAllSum(r, c, pq, grid);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty() && ans.size() < 3) {
            int element = pq.poll();
            if (canInsert(ans, element)) {
                ans.add(element);                
            }
        }

        int res[] = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    public static void print2DArr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Input 1: ");
        int grid1[][] = { { 3, 4, 5, 1, 3 },
                { 3, 3, 4, 2, 3 },
                { 20, 30, 200, 40, 10 },
                { 1, 5, 5, 4, 1 },
                { 4, 3, 2, 2, 5 } };
        print2DArr(grid1);
        System.out.println("Output 1: ");
        printArr(getBiggestThree(grid1));

        System.out.println("Input 2: ");
        int grid2[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        print2DArr(grid2);
        System.out.println("Output 2: ");
        printArr(getBiggestThree(grid2));
    }
}
