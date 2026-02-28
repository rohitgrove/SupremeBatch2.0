public class RemoveAllAdjacentDuplicatesString2 {
    public static boolean areLastK_1CharsSame(StringBuilder ans, char ch, int k) {
        int it = ans.length() - 1;
        for (int i = 0; i < k - 1; i++) {
            if (ans.charAt(it) != ch) {
                return false;
            }
            it--;
        }

        return true;
    }

    public static String removeDuplicates1(String s, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ans.length() < k - 1) {
                ans.append(ch);
            } else {
                if (areLastK_1CharsSame(ans, ch, k)) {
                    for (int j = 0; j < k - 1; j++) {
                        ans.deleteCharAt(ans.length() - 1);
                    }
                } else {
                    ans.append(ch);
                }
            }
        }

        return String.valueOf(ans);
    }

    public static String removeDuplicates2(String s, int k) {
        // two pointer
        StringBuilder str = new StringBuilder(s);
        int i = 0, j = 0;
        int count[] = new int[s.length()];

        while (j < str.length()) {
            str.setCharAt(i, str.charAt(j));
            count[i] = 1;
            if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                count[i] += count[i - 1];
            }
            if (count[i] == k) {
                i -= k;
            }
            ++i;
            ++j;
        }

        return str.substring(0, i);
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
