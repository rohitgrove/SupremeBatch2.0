import java.util.ArrayList;
import java.util.List;

public class PalindromePartitoning {
    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void solve(String s, int idx, List<String> curr, List<List<String>> result, int n) {
        if (idx == n) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = idx; i < n; i++) {
            if (isPalindrome(s, idx, i)) {
                curr.add(s.substring(idx, i + 1));
                solve(s, i + 1, curr, result, n);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int n = s.length();
        List<String> curr = new ArrayList<>();
        solve(s, 0, curr, result, n);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition("a"));
    }
}
