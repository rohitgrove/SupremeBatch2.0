public class ReorgainiseString {
    public static String reorganizeString(String s) {
        char sArr[] = s.toCharArray();
        int hash[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[sArr[i] - 'a']++;
        }

        int max_freq = Integer.MIN_VALUE;
        char most_freq_char = ' ';
        for (int i = 0; i < 26; i++) {
            if (hash[i] > max_freq) {
                max_freq = hash[i];
                most_freq_char = (char) (i + 'a');
            }
        }

        int index = 0;
        while (index < s.length() && max_freq > 0) {
            sArr[index] = most_freq_char;
            max_freq--;
            index += 2;
        }

        if (max_freq != 0) {
            return "";
        }

        for (int i = 0; i < 26; i++) {
            while (hash[i] > 0) {
                index = index >= s.length() ? 1 : index;
                sArr[index] = (char) (i + 'a');
                hash[i]--;
                index++;
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