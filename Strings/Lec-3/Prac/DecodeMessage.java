public class DecodeMessage {
    public static String decodeMessage(String key, String message) {
        char mapping[] = new char[280];

        char start = 'a';
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if(ch != ' ' && mapping[ch] == 0) {
                mapping[ch] = start;    
                start++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch == ' ') {
                sb.append(' ');
            } else {
                char decodeMessage = mapping[ch];
                sb.append(decodeMessage);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv";
        System.out.println(decodeMessage(key, message));
        key = "eljuxhpwnyrdgtqkviszcfmabo"; message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        System.out.println(decodeMessage(key, message));
    }
}