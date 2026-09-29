public class DecodeMessage {
    public static String decodeMessage(String key, String message) {
        char mapping[] = new char[256];
        char start = 'a';
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (mapping[ch] == 0 && ch != ' ') {
                mapping[ch] = start;
                start++;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch != ' ') {
                ans.append(mapping[ch]);
            } else {
                ans.append(' ');
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String key1 = "the quick brown fox jumps over the lazy dog", message1 = "vkbs bs t suepuv";
        System.out.println(decodeMessage(key1, message1));
        String key2 = "eljuxhpwnyrdgtqkviszcfmabo", message2 = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        System.out.println(decodeMessage(key2, message2));
    }
}
