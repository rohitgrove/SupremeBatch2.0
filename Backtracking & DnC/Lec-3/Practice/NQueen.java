import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NQueen {
    public static void storeAnswer(char[][] board, List<List<String>> ans) {
        List<String> currAnswer = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            currAnswer.add(String.valueOf(board[i]));
        }
        ans.add(currAnswer);
    }

    public static boolean isSafe(int row, int col, char[][] board, int n) {
        int r = row;
        int c = col;

        // row
        while (c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            c--;
        }

        r = row;
        c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
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
    public static void solve(char board[][], int n, List<List<String>> ans, int col) {
        if (col >= n) {
            storeAnswer(board, ans);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(board, n, ans, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for (char[] cs : board) {
            Arrays.fill(cs, '.');
        }

        int col = 0;
        List<List<String>> ans = new ArrayList<>();
        solve(board, n, ans, col);
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}