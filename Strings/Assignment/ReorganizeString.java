public class ReorganizeString {
    public static CharSequence reorganizeString(String s) { //tc: O(n)
        char sArr[] = s.toCharArray(); 
        int hash[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[sArr[i] - 'a']++;
        }

        // find the most frequent char
        char most_freq_char = ' ';
        int max_freq = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (hash[i] > max_freq) {
                max_freq = hash[i];
                most_freq_char = (char) (i + 'a');
            }
        }

        int index = 0;

        // place most freq character
        while (max_freq > 0 && index < s.length()) {
            sArr[index] = most_freq_char;
            max_freq--;
            index += 2;
        }

        if (max_freq != 0) {
            return "";
        }

        hash[most_freq_char - 'a'] = 0;

        // let's place the rest of the characters.
        for (int i = 0; i < 26; i++) {
            while (hash[i] > 0) {
                index = index >= s.length() ? 1 : index;
                sArr[index] = (char) (i + 'a');
                hash[i]--;
                index += 2;
            }
        }

        return String.valueOf(sArr);
    }
    public static void main(String[] args) {
        String s1 = "aab";
        System.out.println(reorganizeString(s1));
        String s2 = "aaab";
        System.out.println(reorganizeString(s2));
        String s3 = "aaabc";
        System.out.println(reorganizeString(s3));
        String s4 = "aaabb";
        System.out.println(reorganizeString(s4));
    }    
}
