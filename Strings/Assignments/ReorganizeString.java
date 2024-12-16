public class ReorganizeString {
    public static String reorganizeString(String s) {
        char sArr[] = s.toCharArray();
        int hash[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            hash[sArr[i] - 'a']++;
        } // tc: O(n)
        
        // find the most frequent char
        char max_freq_char = ' ';
        int max_freq = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (hash[i] > max_freq) {
                max_freq = hash[i];
                max_freq_char = (char) (i + 'a');
            }
        } // tc: O(1)

        int index = 0;
        while (max_freq > 0 && index < s.length()) {
            sArr[index] = max_freq_char;
            max_freq--;
            index += 2;
        } // tc: O(n)

        if (max_freq != 0) {
            return "";
        }

        hash[max_freq_char - 'a'] = 0;

        // let's place the rest of the characters.
        for (int i = 0; i < 26; i++) {
            while (hash[i] > 0) {
                index = index >= s.length() ? 1 : index;
                sArr[index] = (char) (i + 'a');
                hash[i]--;
                index += 2;
            }
        } // tc: O(n)

        return String.valueOf(sArr);
    }

    public static void main(String[] args) {
        String s1 = "aab";
        System.out.println(reorganizeString(s1)); // output: aba
        String s2 = "aaab";
        System.out.println(reorganizeString(s2)); // output: ""
        String s3 = "aaabbef";
        System.out.println(reorganizeString(s3)); // output: abaeafb
    }
}
