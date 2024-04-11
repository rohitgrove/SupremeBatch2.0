public class RemoveAllAdjacentDuplicatesString2 {
    public static String removeDuplicates(String s, int k) { // tc: O(n*k) sc:O(1)
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char newch = s.charAt(i);
            ans.append(newch); // Append the new character first

            if (ans.length() >= k && areLastKCharsSame(ans, newch, k)) {
                // Delete the last k characters if they are the same
                ans.delete(ans.length() - k, ans.length());
            }
        }
        return ans.toString();
    }

    public static boolean areLastKCharsSame(StringBuilder ans, char newch, int k) {
        for (int j = ans.length() - k; j < ans.length(); j++) {
            if (ans.charAt(j) != newch) {
                return false;
            }
        }
        return true;
    }

    public static String removeDuplicates2(String s, int k) { // tc: O(n) sc: O(n)
        // two Pointer
        StringBuilder sArr = new StringBuilder(s);
        int i = 0, j = 0;
        int count[] = new int[s.length()];
        while (j < sArr.length()) {
            sArr.setCharAt(i, sArr.charAt(j));
            count[i] = 1;
            if (i > 0 && sArr.charAt(i) == sArr.charAt(i - 1)) {
                count[i] += count[i - 1];
            }
            if (count[i] == k) {
                i -= k;
            }
            ++i;
            ++j;
        }

        return sArr.substring(0, i);
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
