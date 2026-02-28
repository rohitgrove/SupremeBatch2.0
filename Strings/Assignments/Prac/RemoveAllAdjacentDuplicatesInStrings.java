public class RemoveAllAdjacentDuplicatesInStrings {
    public static String removeDuplicates1(String s, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ans.length() < k - 1) {
                ans.append(ch);
            } else {
                if (areLastK_1CharsSame(ans, k, ch)) {
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

    public static boolean areLastK_1CharsSame(StringBuilder ans, int k, char ch) {
        int idx = ans.length() - 1;
        for (int i = 0; i < k - 1; i++) {
            if (ch != ans.charAt(idx)) {
                return false;
            }
            idx--;
        }
        return true;
    }

    public static String removeDuplicates2(String s, int k) {
        StringBuilder str = new StringBuilder(s);
        int count[] = new int[s.length()];
        int i = 0, j = 0;
        while (j < str.length()) {
            str.setCharAt(i, str.charAt(j));
            count[i] = 1;
            if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                count[i] += count[i - 1];
            }
            if (count[i] == k) {
                i -= k;
            }
            i++;
            j++;
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
