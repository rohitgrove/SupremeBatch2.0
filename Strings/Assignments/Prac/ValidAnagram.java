public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int freqTable[] = new int[256];

        for (int i = 0; i < s.length(); i++) {
            freqTable[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            freqTable[t.charAt(i)]--;
        }

        for (int i = 0; i < freqTable.length; i++) {
            if (freqTable[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram", t1 = "nagaram";
        System.out.println(isAnagram(s1, t1));
        String s2 = "rat", t2 = "car";
        System.out.println(isAnagram(s2, t2));
    }
}
