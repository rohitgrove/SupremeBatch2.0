import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VowelSort {
    public static boolean isVowel(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }

    public static String sortVowels(String s) {
        StringBuilder t = new StringBuilder(s);
        List<Character> vowel = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                vowel.add(s.charAt(i));
            }
        }

        if (vowel.size() == 0) {
            return s;
        }

        Collections.sort(vowel);

        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (isVowel(t.charAt(i))) {
                t.setCharAt(i, vowel.get(j++));
            }
        }

        return t.toString();
    }

    public static void main(String[] args) {
        String input = "Hello, how are you?";
        String result = sortVowels(input);
        System.out.println("Sorted Vowels: " + result);
    }
}
