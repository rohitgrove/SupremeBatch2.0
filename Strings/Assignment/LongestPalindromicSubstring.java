public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    String t = s.substring(i, j + 1);
                    ans = t.length() > ans.length() ? t : ans;
                }
            }
        }

        return ans;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";

        System.out.println(longestPalindrome(s1)); // Output: "bab" or "aba"
        System.out.println(longestPalindrome(s2)); // Output: "bb"
    }
}
