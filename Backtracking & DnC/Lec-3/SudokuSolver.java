public class SudokuSolver {
    public static boolean isSafe(int row, int col, char value, char[][] board) {
        // same row me vo number na ho
        // same column me vo number na ho
        // same 3*3 matrix me no ho
        int n = board.length;
        
        // row check
        for (int i = 0; i < n; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        // column check
        for (int i = 0; i < n; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        // yaha pr galti ho sakti hai
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        // 3*3 box check karo
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudokuHelper(char[][] board) {
        int n = board.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                // empty cell check karo
                if (board[r][c] == '.') {
                    // try karenge -> 1 -> 9 insert krne ka
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isSafe(r, c, ch, board)) {
                            // place krdo
                            board[r][c] = ch;
                            // recursion
                            boolean recursionKaAnswer = solveSudokuHelper(board);
                            if (recursionKaAnswer) {
                                return true;
                            }
                            // recursion ans nhi la paya
                            // iska mtlb jo ch insert kia, vo galat tha
                            // iska mtlb backtrack karo, wapas jao
                            board[r][c] = '.';
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
