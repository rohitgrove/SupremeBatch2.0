import java.util.ArrayList;
import java.util.List;

public class ClimbingStairsPrintWays {
    public static void Climb(int curr, int dest, String path, List<String> ans) {
        if (curr == dest) { // pos!!
            ans.add(path);
            return;
        }
        if (curr > dest) { // Neg
            return;
        }
        // BP :
        Climb(curr + 1, dest, path + 1, ans);
        Climb(curr + 2, dest, path + 2, ans);
    }

    public static void solve(int n, String path, List<String> ans) {
        if (n == 0) {
            ans.add(path);
            return;
        }
        if (n == 1) {
            ans.add(path + "1");
            return;
        }

        solve(n - 1, path + "1", ans);
        solve(n - 2, path + "2", ans);
    }

    public static List<String> WaysToClimb(int n) {
        List<String> ans = new ArrayList<>();
        // Climb(0, n, "", ans);
        solve(n, "", ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(WaysToClimb(2));
        System.out.println(WaysToClimb(3));
    }
}
