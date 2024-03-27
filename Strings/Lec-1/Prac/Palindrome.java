public class Palindrome {
    public static boolean checkPalindrome(String str) {
        int s = 0;
        int e = str.length() - 1;
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }

        return true;
    }
    public static void main(String[] args) {
        String str = "racecar";        
        System.out.println(checkPalindrome(str));
    }
}