public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (true) {
            char curr_char = 0;
            for (String str : strs) {
                if (i >= str.length()) {
                    curr_char = 0;
                    break;
                }
                if (curr_char == 0) {
                    curr_char = str.charAt(i);
                } else if (str.charAt(i) != curr_char) {
                    curr_char = 0;
                    break;
                }
            }

            if (curr_char == 0) {
                break;
            }
            ans.append(curr_char);
            i++;
        } 

        return String.valueOf(ans);
    }    
    public static void main(String[] args) {
        String strs[] = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }
}
