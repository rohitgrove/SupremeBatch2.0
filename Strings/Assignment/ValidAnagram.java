import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram1(String s, String t) { // tc: O(logn)
        char sArr[] = s.toCharArray();
        char tArr[] = t.toCharArray();
        Arrays.sort(tArr);
        Arrays.sort(sArr);

        return Arrays.equals(sArr, tArr);
    }

    public static boolean isAnagram2(String s, String t) { // tc: O(n+m)
        int freqTable[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freqTable[s.charAt(i)]++;
        } // (n)

        for (int i = 0; i < t.length(); i++) {
            freqTable[t.charAt(i)]--;
        } // (m)

        for (int i = 0; i < freqTable.length; i++) {
            if (freqTable[i] != 0) {
                return false;
            }
        } // (256)
        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram", t1 = "nagaram";
        System.out.println(isAnagram2(s1, t1));
        String s2 = "car", t2 = "rat";
        System.out.println(isAnagram2(s2, t2));
    }
}