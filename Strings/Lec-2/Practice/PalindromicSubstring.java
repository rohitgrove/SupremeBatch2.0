public class PalindromicSubstring {
    public static int expend(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            count++;
        }

        return count;
    }

    public static int countSubstrings(String s) {
        int center = 0;
        int totalCount = 0;

        while (center < s.length()) {
            int oddCount = expend(s, center, center);
            int evenCount = expend(s, center, center + 1);
            totalCount += oddCount + evenCount;
            center++;
        }

        return totalCount;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }
}
