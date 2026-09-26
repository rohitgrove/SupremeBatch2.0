public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s) {
        StringBuilder ans = new StringBuilder();

        int index = 0;
        while (index < s.length()) {
            char ch = s.charAt(index);

            if (ans.length() > 0 && ans.charAt(ans.length() - 1) == ch) {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                ans.append(ch);
            }

            index++;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));
    }
}
