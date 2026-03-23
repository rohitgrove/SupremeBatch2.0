import java.util.ArrayList;
import java.util.List;

public class SubsequncesOfString {
    public static void findSubsequnce(String str, String output, int idx, List<String> ans) {
        // base case
        if (idx >= str.length()) {
            // ans jo h, vo output string me build ho chuka h
            // ans main add kar lo
            ans.add(output);
            return;
        }

        char ch = str.charAt(idx);

        // include
        // output String me ch character ko include kardo
        findSubsequnce(str, output + ch, idx + 1, ans);
        // exclude
        findSubsequnce(str, output, idx + 1, ans);
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> ans = new ArrayList<>();
        findSubsequnce(str, "", 0, ans);
        System.out.println(ans);
    }
}
