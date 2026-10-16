import java.util.ArrayList;
import java.util.List;

public class SubsequneceOfString {
    public static void solve(String s, int idx, List<String> ans, String currAns) {
        if (idx >= s.length()) {
            ans.add(currAns);
            return;
        }

        solve(s, idx + 1, ans, currAns + s.charAt(idx));
        solve(s, idx + 1, ans, currAns);
    }

    public static List<String> powerSet(String s) {
        List<String> ans = new ArrayList<>();
        solve(s, 0, ans, "");
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(powerSet("abc"));
    }
}
