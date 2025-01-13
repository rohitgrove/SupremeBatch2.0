import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensUsingLoop {
    public static void storeAnswer(List<List<String>> ans, char[][] board) {
        List<String> currAnswer = new ArrayList<>();
        for (char[] row : board) {
            currAnswer.add(String.valueOf(row));
        }
        ans.add(currAnswer);
    }

    public static boolean isSafe(char[][] board, int n, int row, int col) {
        // check karna chahte h , k kya main
        // current cell [row,col] pr QUEEN rakh
        // sakta hu ya nahi
        int r = row;
        int c = col;

        // check row
        while (c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            c--;
        }

        // check upper left diaglnol
        r = row;
        c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }

        // check bottom left diagnol
        r = row;
        c = col;
        while (r < n && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r++;
            c--;
        }

        // kahin pr bhi queen nahi mili
        // iska matlab ye position safe hai
        // iska matlab return kardo true
        return true;
    }

    public static void solve(char board[][], List<List<String>> ans, int n, int col) {
        if (col >= n) {
            storeAnswer(ans, board);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, n, row, col)) {
                board[row][col] = 'Q';
                solve(board, ans, n, col + 1);
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
        solve(board, ans, n, col);
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}