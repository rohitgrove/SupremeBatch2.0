public class PalindromeCheck {
    public static boolean isPalindrome(String str, int start, int end) {
        // base case
        if (start >= end) {
            return true;
        }
        // one case solution
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindrome(str, start + 1, end - 1);
    }
    public static void main(String[] args) {
        String str = "raceycar";
        System.out.println(isPalindrome(str, 0, str.length() - 1));
    }
}