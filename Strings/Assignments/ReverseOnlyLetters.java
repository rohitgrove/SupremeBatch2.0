public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String s) {
        int l = 0;
        int h = s.length() - 1;
        char character[] = s.toCharArray();

        while (l < h) {
            if (Character.isAlphabetic(character[l]) && Character.isAlphabetic(character[h])) {
                char temp = character[l];
                character[l] = character[h];
                character[h] = temp;
                l++;
                h--;
            } else if (!Character.isAlphabetic(character[l])) {
                l++;
            } else {
                h--;
            }
        }
        return String.valueOf(character);
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
