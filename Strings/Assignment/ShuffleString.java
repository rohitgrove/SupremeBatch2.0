import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class ShuffleString {
    public static String restoreStringItr(String s, int[] indices) {
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[indices[i]] = s.charAt(i);
        }
        return new String(res);
    }

    public static String restoreStringMap(String s, int[] indices) {
        HashMap<Integer, Character> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(indices[i], s.charAt(i));
        }
        String st = "";
        for (int i = 0; i < s.length(); i++) {
            st = st + hm.get(i);
        }
        return st;
    }

    static class Pair {
        char ch;
        int index;
        public Pair(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }

    static class CustomComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.index - o2.index;
        } 
    }

    public static String restoreStringClass(String s, int[] indices) {
        ArrayList<Pair> correctRes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Pair pair = new Pair(s.charAt(i), indices[i]);
            correctRes.add(pair); 
        }

        Collections.sort(correctRes, new CustomComparator());
        String res = "";
        for (int i = 0; i < correctRes.size(); i++) {
            res += correctRes.get(i).ch;
        }

        return res;
    }

    public static void main(String[] args) {
        String s1 = "codeleet";
        int indices1[] = { 4, 5, 6, 7, 0, 2, 1, 3 };
        System.out.println(restoreStringClass(s1, indices1));
        String s2 = "abc";
        int indices2[] = { 0, 1, 2 };
        System.out.println(restoreStringClass(s2, indices2));
    }
}
