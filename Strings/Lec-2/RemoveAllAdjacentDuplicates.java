public class RemoveAllAdjacentDuplicates {
    public static String removeDuplicates(String s) {
        StringBuilder ans = new StringBuilder();
        int index = 0;

        while (index < s.length()) {
            // same
            // ans ka rightmost character ans string s ka current character
            if (ans.length() > 0 && ans.charAt(ans.length() - 1) == s.charAt(index)) {
                // delete from ans string
                ans.deleteCharAt(ans.length() - 1);
            } else {
                // append
                ans.append(s.charAt(index));
            }
            index++;
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        String s1 = "abbaca";
        System.out.println(removeDuplicates(s1));
        String s2 = "azxxzy";
        System.out.println(removeDuplicates(s2));
    }
}