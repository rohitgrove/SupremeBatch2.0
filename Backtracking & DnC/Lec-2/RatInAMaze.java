import java.util.ArrayList;

public class RatInAMaze {
    public static void solve(int r, int c, String path, boolean[][] visited, int[][] maze, ArrayList<String> res) {
        if (r < 0 || c < 0 || r == maze.length || c == maze[0].length ||
                visited[r][c] || maze[r][c] == 0) {
            return;
        }
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            res.add(path);
            return;
        }
        visited[r][c] = true;
        solve(r - 1, c, path + "U", visited, maze, res);
        solve(r + 1, c, path + "D", visited, maze, res);
        solve(r, c - 1, path + "L", visited, maze, res);
        solve(r, c + 1, path + "R", visited, maze, res);
        visited[r][c] = false;
    }

    public static ArrayList<String> findPath(int[][] maze, int n) {
        ArrayList<String> res = new ArrayList<>();

        solve(0, 0, "", new boolean[maze.length][maze[0].length], maze, res);

        return res;
    }

    public static void main(String[] args) {
        int maze1[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };
        System.out.println(findPath(maze1, maze1.length));
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 0 },
                { 1, 1, 1, 0 },
                { 1, 1, 1, 1 }
        };
        System.out.println(findPath(maze, maze.length));
    }
}
