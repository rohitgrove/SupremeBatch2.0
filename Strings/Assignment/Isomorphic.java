import java.util.Arrays;

public class Isomorphic {
    public static boolean isIsomorphic1(String s, String t) {
        int hash[] = new int[256]; // mapping of each char of language 's' to language 't'
        boolean istCharsMapped[] = new boolean[256]; // stores if t[i] char already mapped with s[i].

        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] == 0 && istCharsMapped[t.charAt(i)] == false) {
                hash[s.charAt(i)] = t.charAt(i);
                istCharsMapped[t.charAt(i)] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }


    public static String updateMappingString(StringBuilder str) {
        char hash[] = new char[256];
        char start = 'a';

        for (int i = 0; i < str.length(); i++) {
            if (hash[str.charAt(i)] == 0) {
                hash[str.charAt(i)] = start;
                start++;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            str.setCharAt(i, hash[ch]);
        }

        return String.valueOf(str);
    }

    public static boolean isIsomorphic2(String s, String t) {
        s = updateMappingString(new StringBuilder(s));
        t = updateMappingString(new StringBuilder(t));
        char arrs[] = s.toCharArray();
        char arrt[] = t.toCharArray();
        return Arrays.equals(arrs, arrt);
    }

    public static void main(String[] args) {
        String s1 = "egg", t1 = "add";
        System.out.println(isIsomorphic2(s1, t1));
        String s2 = "foo", t2 = "bar";
        System.out.println(isIsomorphic2(s2, t2));
        String s3 = "paper", t3 = "title";
        System.out.println(isIsomorphic2(s3, t3));
        String s4 = "badc", t4 = "baba";
        System.out.println(isIsomorphic2(s4, t4));
    }
}
