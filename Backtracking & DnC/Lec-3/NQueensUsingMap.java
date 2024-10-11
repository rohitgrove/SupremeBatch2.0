import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NQueensUsingMap {
    static HashMap<Integer, Boolean> rowCheck = new HashMap<>();
    static HashMap<Integer, Boolean> upperLeftDiagonalCheck = new HashMap<>();
    static HashMap<Integer, Boolean> bottomLeftDiagonalCheck = new HashMap<>();

    public static void storeSolution(char[][] board, int n, List<List<String>> ans) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(String.valueOf(board[i]));
        }
        ans.add(temp);
    }

    public static boolean isSafe(int row, int col, char[][] board) {
        if (rowCheck.getOrDefault(row, false)) {
            return false;
        }

        if (upperLeftDiagonalCheck.getOrDefault(col - row, false)) {
            return false;
        }

        if (bottomLeftDiagonalCheck.getOrDefault(row + col, false)) {
            return false;
        }

        return true;
    }

    public static void solve(char[][] board, int col, int n, List<List<String>> ans) {
        // base case
        if (col >= n) {
            storeSolution(board, n, ans);
            return;
        }

        // 1 case solve karna h , baaki recursion sambhal lega

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board)) {
                // rakh do

                board[row][col] = 'Q';
                rowCheck.put(row, true);
                upperLeftDiagonalCheck.put(col - row, true);
                bottomLeftDiagonalCheck.put(row + col, true);

                // recursion solution laega

                solve(board, col + 1, n, ans);

                // backtracking
                board[row][col] = '.';
                rowCheck.put(row, false);
                upperLeftDiagonalCheck.put(col - row, false);
                bottomLeftDiagonalCheck.put(row + col, false);
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        // 0 -> empty cell
        // 1 -> Queen at the cell
        List<List<String>> ans = new ArrayList<>();
        solve(board, 0, n, ans);
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
