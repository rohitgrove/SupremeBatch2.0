public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String s) { // tc: O(n)
        char[] characters = s.toCharArray();
        int l = 0;
        int h = characters.length - 1;
        while (l < h) {
            if (Character.isAlphabetic(characters[l]) && Character.isAlphabetic(characters[h])) {
                char temp = characters[l];
                characters[l] = characters[h];
                characters[h] = temp;
                l++;
                h--;
            } else if (!Character.isAlphabetic(characters[l])) {
                l++;
            } else {
                h--;
            }
        }

        return String.valueOf(characters);
    }

    public static void main(String[] args) {
        String s1 = "ab-cd";
        System.out.println(reverseOnlyLetters(s1));
        String s2 = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s2));
        String s3 = "Test1ng-Leet=code-Q!";
        System.out.println(reverseOnlyLetters(s3));
    }
}
