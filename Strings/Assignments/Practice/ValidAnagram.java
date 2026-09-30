import java.util.Arrays;

public class ValidAnagram {
    public static boolean bruteForce(String s, String t) {
        char sArray[] = s.toCharArray();
        char tArray[] = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);
    
        return Arrays.equals(tArray, sArray);
    }

    public static boolean optimizedApptoach(String s, String t) {
        int hash[] = new int[256];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]--;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram(String s, String t) {
        return optimizedApptoach(s, t);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
