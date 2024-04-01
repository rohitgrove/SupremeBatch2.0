public class ValidAnagram {
    public static boolean isAnagram2(String s, String t) {
        int frequency[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            frequency[t.charAt(i)]--;
        }

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String s1 = "anagram", t1 = "nagaram";
        System.out.println(isAnagram2(s1, t1));
        String s2 = "car", t2 = "rat";
        System.out.println(isAnagram2(s2, t2));
    }
}