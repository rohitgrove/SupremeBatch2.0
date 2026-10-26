import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NQueensUsingMap {
    public static HashMap<Integer, Boolean> rowCheck = new HashMap<>();
    public static HashMap<Integer, Boolean> upperLeftDiagnolCheck = new HashMap<>();
    public static HashMap<Integer, Boolean> bottomLeftDiagnolCheck = new HashMap<>();

    public static void storeSolution(char[][] board, int n, List<List<String>> ans) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String output = "";
            for (int j = 0; j < n; j++) {
                output += board[i][j];
            }
            temp.add(output);
        }
        ans.add(temp);
    }

    public static boolean isSafe(int row, int col, char[][] board, int n) {
        if (rowCheck.getOrDefault(row, false) == true)
            return false;

        if (upperLeftDiagnolCheck.getOrDefault(n - 1 + col - row, false) == true)
            return false;

        if (bottomLeftDiagnolCheck.getOrDefault(row + col, false) == true)
            return false;

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
            if (isSafe(row, col, board, n)) {
                // rakh do
                board[row][col] = 'Q';
                rowCheck.put(row, true);
                upperLeftDiagnolCheck.put(n - 1 + col - row, true);
                bottomLeftDiagnolCheck.put(row + col, true);

                // recursion solution laega
                solve(board, col + 1, n, ans);

                // backtracking
                board[row][col] = '.';
                rowCheck.put(row, false);
                upperLeftDiagnolCheck.put(n - 1 + col - row, false);
                bottomLeftDiagnolCheck.put(row + col, false);
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> ans = new ArrayList<>();
        int col = 0;
        // 0 -> empty cell
        // 1 -> Queen at the cell
        solve(board, col, n, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
