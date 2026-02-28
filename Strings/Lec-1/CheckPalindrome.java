public class CheckPalindrome {
    public static boolean checkPalindorme(String str) {
        int s = 0;
        int e = str.length() - 1;
        while (s < e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else {
                // character are not matching
                return false;
            }
        }
        // agar yaha pohoch gye ho
        // iska matlab palindorme characters match kr gye h
        // iska matlab palindrome hai
        // iska matalb return true krdo
        return true;
    }

    public static void main(String[] args) {
        String str1 = "NooN";
        System.out.println(checkPalindorme(str1));
        String str2 = "RacecaR";
        System.out.println(checkPalindorme(str2));
        String str3 = "BABBAB";
        System.out.println(checkPalindorme(str3));
        String str4 = "TAPAT";
        System.out.println(checkPalindorme(str4));
    }    
}
