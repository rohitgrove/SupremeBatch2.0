public class ValidPalindorme2 {
    public static boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                boolean ans1 = checkPalindrome(s, i + 1, j);
                boolean ans2 = checkPalindrome(s, i, j - 1);

                return ans1 || ans2;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "aba";
        System.out.println(validPalindrome(s1));
        String s2 = "abca";
        System.out.println(validPalindrome(s2));
        String s3 = "abc";
        System.out.println(validPalindrome(s3));
    }
}
