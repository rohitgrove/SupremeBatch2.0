public class PalidormicSubstring {
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
        int totalPalindorme = 0;

        for (int center = 0; center < s.length(); center++) {
            int oddKaAnswer = expand(s, center, center);
            int evenKaAnswer = expand(s, center, center + 1);
            totalPalindorme = totalPalindorme + oddKaAnswer + evenKaAnswer;
        }

        return totalPalindorme;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        System.out.println(countSubstrings(s1));
        String s2 = "aaa";
        System.out.println(countSubstrings(s2));
        String s3 = "madam";
        System.out.println(countSubstrings(s3));
    }
}
