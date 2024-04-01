public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (true) {
            char curr_ch = 0;
            for (String str : strs) {
                if (i >= str.length()) {
                    // out of bound
                    curr_ch = 0;
                    break;
                }
                // just started
                if (curr_ch == 0) {
                    curr_ch = str.charAt(i);
                } else if (str.charAt(i) != curr_ch) {
                    curr_ch = 0;
                    break;
                }
            }

            if (curr_ch == 0) {
                break;
            }
            ans.append(curr_ch);
            i++;
        }

        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        String strs[] = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }
}
