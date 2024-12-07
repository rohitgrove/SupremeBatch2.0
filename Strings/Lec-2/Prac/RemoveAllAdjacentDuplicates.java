public class RemoveAllAdjacentDuplicates {
    public static String removeDuplicates(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (ans.length() > 0 && ans.charAt(ans.length() - 1) == s.charAt(i)) {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                ans.append(s.charAt(i));
            }
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