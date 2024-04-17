import java.util.ArrayList;

public class Subsequences {
    public static void findSubsequences(String str, String output, int index, ArrayList<String> ans) {
        // base case
        if (index >= str.length()) {
            // ans jo hai, vo output string ban chuka h
            ans.add(output);
            return;
        }

        char currChar = str.charAt(index);
        // include
        findSubsequences(str, output + currChar, index + 1, ans);
        // exclude
        findSubsequences(str, output, index + 1, ans);
    }

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> ans = new ArrayList<>();
        findSubsequences(str, "", 0, ans);
        System.out.println(ans);
    }
}
