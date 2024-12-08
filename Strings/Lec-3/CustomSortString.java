import java.util.Arrays;
import java.util.Comparator;

public class CustomSortString {
    // Custom comparator
    static String str;

    static class Custom implements Comparator<Character> {
        @Override
        public int compare(Character o1, Character o2) {
            return str.indexOf(o1) - str.indexOf(o2);   
        }
    }

    public static String customSortString(String order, String s) {
        str = order;
        Character[] charArray = new Character[s.length()];
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = s.charAt(i);
        }
        Arrays.sort(charArray, new Custom());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            ans.append(charArray[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String order1 = "cba", s1 = "abcd";
        System.out.println(customSortString(order1, s1));
        String order2 = "bcafg", s2 = "abcd";
        System.out.println(customSortString(order2, s2));
    }
}
