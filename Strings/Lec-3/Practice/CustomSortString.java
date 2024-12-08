import java.util.Arrays;
import java.util.Comparator;

public class CustomSortString {
    static String str;

    static class Custom implements Comparator<Character> {
        @Override
        public int compare(Character o1, Character o2) {
            return str.indexOf(o1) - str.indexOf(o2);
        }
    }

    public static String customSortString(String order, String s) {
        str = order;

        Character sArr[] = new Character[s.length()];
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = s.charAt(i);
        }

        Arrays.sort(sArr, new Custom());

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < sArr.length; i++) {
            ans.append(sArr[i]);
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
