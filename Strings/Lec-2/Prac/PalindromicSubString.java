public class PalindromicSubString {
    public static int countSubStringHelper(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }

        return count;
    }

    public static int countSubstrings(String s) {
        int totalCount = 0;
        for (int center = 0; center < s.length(); center++) {
            int oddCase = countSubStringHelper(s, center, center);
            int evenCase = countSubStringHelper(s, center, center + 1);
            totalCount = totalCount + oddCase + evenCase;
        }
        return totalCount;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
        s = "aaa";
        System.out.println(countSubstrings(s));
    }
}
