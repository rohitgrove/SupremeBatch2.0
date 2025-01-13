public class SudokuSolver {
    public static boolean isSafe(char[][] board, int row, int col, char value) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        int r = (row / 3) * 3;
        int c = (col / 3) * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solveHelper(char board[][]) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (board[r][c] == '.') {
                    for (char value = '1'; value <= '9'; value++) {
                        if (isSafe(board, r, c, value)) {
                            board[r][c] = value;

                            if (solveHelper(board)) {
                                return true;
                            } else {
                                board[r][c] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void solveSudoku(char[][] board) {
        solveHelper(board);
    }

    public static void printArr(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char board[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        printArr(board);
        solveSudoku(board);
        printArr(board);
    }
}
