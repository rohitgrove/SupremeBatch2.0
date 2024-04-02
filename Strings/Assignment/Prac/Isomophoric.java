import java.util.Arrays;

public class Isomophoric {
    public static boolean isIsomorphic1(String s, String t) {
        int hash[] = new int[256];

        boolean strTMapped[] = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] == 0 && strTMapped[t.charAt(i)] == false) {
                hash[s.charAt(i)] = t.charAt(i);
                strTMapped[t.charAt(i)] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] != t.charAt(i)) {
                return false;
            }
        }


        return true;
    }

    public static String updateMapString(StringBuilder str) {
        char mapping[] = new char[256];
        char start = 'a';
        
        for (int i = 0; i < str.length(); i++) {
            if (mapping[str.charAt(i)] == 0) {
                mapping[str.charAt(i)] = start;
                start++;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            str.setCharAt(i, mapping[str.charAt(i)]);
        }

        return String.valueOf(str);
    }

    public static boolean isIsomorphic2(String s, String t) {
        s = updateMapString(new StringBuilder(s));
        t = updateMapString(new StringBuilder(t));
        char sArr[] = s.toCharArray();
        char tArr[] = t.toCharArray();
        return Arrays.equals(sArr, tArr);
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
