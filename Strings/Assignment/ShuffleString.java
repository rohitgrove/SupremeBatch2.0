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

    public static void main(String[] args) {
        String s1 = "codeleet";
        int indices1[] = { 4, 5, 6, 7, 0, 2, 1, 3 };
        System.out.println(restoreStringMap(s1, indices1));
        String s2 = "abc";
        int indices2[] = { 0, 1, 2 };
        System.out.println(restoreStringMap(s2, indices2));
    }
}
