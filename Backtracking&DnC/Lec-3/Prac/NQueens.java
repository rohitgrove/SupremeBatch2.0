import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void storeSolution(char[][] board, List<List<String>> ans) {
        List<String> currAns = new ArrayList<>();
        for (char row[] : board) {
            currAns.add(String.valueOf(row));
        }
        ans.add(currAns);
    }

    public static boolean isSafe(char[][] board, int row, int col, int n) {
        int r = row;
        int c = col;

        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }
        r = row;
        c = col;

        while (c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            c--;
        }

        r = row;
        c = col;

        while (r < n && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r++;
            c--;
        }

        return true;
    }

    public static void solve(char[][] board, int col, int n, List<List<String>> ans) {
        if (col >= n) {
            storeSolution(board, ans);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(board, col + 1, n, ans);
                board[row][col] = '.';
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
        solve(board, col, n, ans);

        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
