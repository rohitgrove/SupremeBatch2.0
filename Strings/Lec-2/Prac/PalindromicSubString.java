public class PalindromicSubString {
    public static int expendStr(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }

        return count;
    }

    public static int countSubstrings(String s) {
        int totalAns = 0;
        for (int center = 0; center < s.length(); center++) {
            int oddKaAns = expendStr(s, center, center);
            int eveKaAns = expendStr(s, center, center + 1);
            totalAns = totalAns + oddKaAns + eveKaAns;
        }

        return totalAns;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
        s = "aaa";
        System.out.println(countSubstrings(s));
    }
}