public class RemoveAllAdjacent2 {
    public static String removeDuplicates(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char newChar = s.charAt(i);
            ans.append(newChar);

            if (ans.length() >= k && areSameLastKChararters(ans, newChar, k)) {
                ans.delete(ans.length() - k, ans.length());
            }
            i++;
        }

        return ans.toString();
    }

    public static boolean areSameLastKChararters(StringBuilder ans, char newchar, int k) {
        for (int i = ans.length() - k; i < ans.length(); i++) {
            if (ans.charAt(i) != newchar) {
                return false;
            }
        }

        return true;
    }

    public static String removeDuplicates2(String s, int k) {
        StringBuilder ans = new StringBuilder(s);
        int i = 0, j = 0;
        int count[] = new int[s.length()];
        while (j < ans.length()) {
            ans.setCharAt(i, ans.charAt(j));
            count[i] = 1;

            if (i > 0 && ans.charAt(i) == ans.charAt(i - 1)) {
                count[i] += count[i - 1]; 
            }

            if (count[i] == k) {
                i -= k;
            }

            i++;j++;
        }

        return ans.substring(0, i);
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        int k1 = 2;
        System.out.println(removeDuplicates2(s1, k1));
        String s2 = "deeedbbcccbdaa";
        int k2 = 3;
        System.out.println(removeDuplicates2(s2, k2));
        String s3 = "pbbcggttciiippooaais";
        int k3 = 2;
        System.out.println(removeDuplicates2(s3, k3));
    }
}
