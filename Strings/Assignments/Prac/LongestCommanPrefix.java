public class LongestCommanPrefix {
    public static String longestCommonPrefix(String strs[]) {
        int i = 0;
        StringBuilder ans = new StringBuilder();

        while (true) {
            char currChar = 0;
            
            for (String str : strs) {
                if (i >= str.length()) {
                    currChar = 0;
                    break;
                }
                if (currChar == 0) {
                    currChar = str.charAt(i);
                } else if (currChar != str.charAt(i)) {
                    currChar = 0;
                    break;
                }
            }

            if (currChar == 0) {
                break;
            }   
            ans.append(currChar);
            i++;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String strs1[] = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs1));
        String strs2[] = { "dog", "racecar", "car" };
        System.out.println(longestCommonPrefix(strs2));
    }
}