public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String s) {
        int l = 0;
        int h = s.length() - 1;
        char characterArray[] = s.toCharArray();

        while (l < h) {
            if (Character.isAlphabetic(characterArray[l]) && Character.isAlphabetic(characterArray[h])) {
                char temp = characterArray[l];
                characterArray[l] = characterArray[h];
                characterArray[h] = temp;
                l++;
                h--;
            } else if (!Character.isAlphabetic(characterArray[l])) {
                l++;
            } else {
                h--;
            }
        }

        return String.copyValueOf(characterArray);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
