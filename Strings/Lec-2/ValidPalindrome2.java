public class ValidPalindrome2 {
    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                // s[i] != s[j]
                // 1 removal allowed
                // check palindrome for remaining after removal

                // ith character -> remove
                boolean ans1 = checkPalindrome(s, i + 1, j);
                // jth character -> remove
                boolean ans2 = checkPalindrome(s, i, j - 1);

                return ans1 || ans2;
            }
        }

        // agar yaha tak pahoche ho 
        // iska matlab valid palidrome hai
        // iska mtlb -> 0 removal
        return true;
    }

    public static boolean checkPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(validPalindrome(s));
        s = "abca";
        System.out.println(validPalindrome(s));
        s = "abc";
        System.out.println(validPalindrome(s));
    }
}
