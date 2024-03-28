public class PalindromicSubstrings {
    public static int expand(String s, int i, int j) {
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
            // ODD
            int oddKaAns = expand(s, center, center);
            // EVEN
            int evenKaAns = expand(s, center, center + 1);

            totalCount = totalCount + oddKaAns + evenKaAns;
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