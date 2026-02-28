public class ValidPalindrome2 {
    public static boolean checkPalindorme(String s, int i, int j) {
        while (i <= j) {
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
                // s.charAt(i)!=s.charAt(j)
                // 1removal allowed
                // check palidorme for remaining string after removal

                // ith character -> remove
                boolean ans1 = checkPalindorme(s, i + 1, j);
                // jth character -> remove
                boolean ans2 = checkPalindorme(s, i, j - 1);
                return ans1 || ans2;
            }
        }

        // agar yha tak poheche ho
        // iska matlab valid palindrome hai
        // iska matlab -> 0 removal
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
