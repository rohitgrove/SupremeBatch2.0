import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NQueensUsingMap {
    public static HashMap<Integer, Boolean> rowCheck = new HashMap<>();
    public static HashMap<Integer, Boolean> topDiagnol = new HashMap<>();
    public static HashMap<Integer, Boolean> bottomDiagnol = new HashMap<>();

    public static boolean isSafe(int row, int col, char[][] board) {
        if (rowCheck.getOrDefault(row, false)) {
            return false;
        }

        if (topDiagnol.getOrDefault(col - row, false)) {
            return false;
        }

        if (bottomDiagnol.getOrDefault(row + col, false)) {
            return false;
        }
        // place is safe

        return true;
    }

    public static void storeSolution(char[][] board, List<List<String>> ans, int n) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(String.valueOf(board[i]));
        }
        ans.add(temp);
    }

    public static void solve(char[][] board, List<List<String>> ans, int n, int col) {
        // base case
        if (col >= n) {
            // saare column process hogye h
            // iska mtlb, we have a solution to store
            storeSolution(board, ans, n);
            return;
        }
        // main logic
        // iss column k hr row pr wueen place krke dekho
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                // queen place kardo
                board[row][col] = 'Q';
                // mark all the 3 direction that q is placed
                rowCheck.put(row, true);
                topDiagnol.put(col - row, true);
                bottomDiagnol.put(row + col, true);

                // recursion
                solve(board, ans, n, col + 1);
                // backtrack
                board[row][col] = '.';
                rowCheck.put(row, false);
                topDiagnol.put(col - row, false);
                bottomDiagnol.put(row + col, false);
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        int col = 0;
        solve(board, ans, n, col);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
