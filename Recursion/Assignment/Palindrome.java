public class Palindrome {
    public static boolean checkPalindrome(String str, int s, int e) {
        if (s > e) {
            return true;
        }

        if (str.charAt(s) != str.charAt(e)) {
            return false;
        }

        return checkPalindrome(str, s + 1, e - 1);
    }
    public static void main(String[] args) {
        String str1 = "racecar";
        System.out.println(checkPalindrome(str1, 0, str1.length() - 1));
        String str2 = "nitin";
        System.out.println(checkPalindrome(str2, 0, str2.length() - 1));
    }
}
