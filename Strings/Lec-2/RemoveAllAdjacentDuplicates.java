public class RemoveAllAdjacentDuplicates {
    public static String removeDuplicates(String s) {
        StringBuilder ans = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            // same
            // ans ka rightmost character and string s corrent character
            if (ans.length() > 0 && ans.charAt(ans.length() - 1) == s.charAt(index)) {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                ans.append(s.charAt(index));
            }

            index++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
        s = "azxxzy";
        System.out.println(removeDuplicates(s));
    }
}