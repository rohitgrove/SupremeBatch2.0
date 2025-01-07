import java.util.ArrayList;

public class RatInAMaze {
    public static ArrayList<String> findPath(int mat[][]) {
        ArrayList<String> ans = new ArrayList<>();
        String output = "";
        int row = mat.length;
        int col = mat[0].length;

        boolean visited[][] = new boolean[row][col];
        printAllPath(mat, row, col, 0, 0, output, visited, ans);
        return ans;
    }

    public static void printAllPath(int maze[][], int row, int col, int r, int c, String output, boolean visited[][], ArrayList<String> ans) {
        // base case
        if (r < 0 || c < 0 || r == row || c == col || visited[r][c] || maze[r][c] == 0) {
            return;
        }
        // destination coordination are [row - 1], [col - 1]
        if (r == row - 1 && c == col - 1) {
            ans.add(output);
            return;
        }

        // 1 case solve karo and baakai recursion sambhal lega
        visited[r][c] = true;

        // UP
        printAllPath(maze, row, col, r - 1, c, output + "U", visited, ans);

        // RIGHT
        printAllPath(maze, row, col, r, c + 1, output + "R", visited, ans);

        // DOWN
        printAllPath(maze, row, col, r + 1, c, output + "D", visited, ans);

        // LEFT
        printAllPath(maze, row, col, r, c - 1, output + "L", visited, ans);

        visited[r][c] = false;
    }

    public static void main(String[] args) {
        int mat1[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };
        System.out.println(findPath(mat1));

        int mat2[][] = { { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 } };
        System.out.println(findPath(mat2));

        int mat3[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 0 },
                { 1, 1, 1, 0 },
                { 1, 1, 1, 1 } };
        System.out.println(findPath(mat3));
    }
}
