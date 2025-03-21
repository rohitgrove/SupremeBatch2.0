import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void solve(String ans, List<String> res, int open, int close) {
        if (open < 0 || close < 0 || open > close) {
            return;
        }

        if (open == 0 && close == 0) {
            res.add(ans);
        }

        solve(ans + "(", res, open - 1, close);
        solve(ans + ")", res, open, close - 1);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String ans = "";
        solve(ans, res, n, n);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}