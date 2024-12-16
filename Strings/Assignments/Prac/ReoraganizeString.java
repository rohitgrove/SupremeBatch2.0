public class ReoraganizeString {
    public static String reorganizeString(String s) {
        char hash[] = new char[26];
        char sArr[] = s.toCharArray();
        
        for (int i = 0; i < sArr.length; i++) {
            hash[sArr[i] - 'a']++;
        }

        int max_char_num = Integer.MIN_VALUE;
        char max_char = ' ';
        for (int i = 0; i < 26; i++) {
            if (hash[i] > max_char_num) {
                max_char_num = hash[i];
                max_char = (char) (i + 'a');
            }
        }

        int index = 0;
        while (max_char_num > 0 && index < sArr.length) {
            sArr[index] = max_char;
            max_char_num--;
            index += 2;
        }

        if (max_char_num != 0) {
            return "";
        }

        for (int i = 0; i < 26; i++) {
            while (hash[i] > 0) {
                index = index >= sArr.length ? 1 : index;
                sArr[index] = (char) (i + 'a');
                hash[i]--;
                index += 2;
            }
        }

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
