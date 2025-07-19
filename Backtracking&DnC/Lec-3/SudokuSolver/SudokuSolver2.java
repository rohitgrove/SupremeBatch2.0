public class SudokuSolver2 {
    public static boolean isSafe(int row, int col, char value, char[][] board) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            // row check
            if (board[row][i] == value) {
                return false;
            }

            // col check
            if (board[i][col] == value) {
                return false;
            }

            // 3*3 box check
            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == value) {
                return false;
            }
        }

        return true;
    }

    public static boolean solveSudokuHelper(char[][] board) {
        int n = board.length;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isSafe(r, c, ch, board)) {
                            board[r][c] = ch;

                            if (solveSudokuHelper(board)) {
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
        solveSudokuHelper(board);
    }

    public static void printArr(char[][] board) {
        for (char[] row : board) {
            for (char ele : row) {
                System.out.print(ele + " ");
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
        System.out.println("Before Solving");
        printArr(board);
        solveSudoku(board);
        System.out.println("After Solving");
        printArr(board);
    }
}
