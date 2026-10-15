public class RemoveAllAdjacentDuplicatesString2 {
    public static boolean areLastK_1charsSame(StringBuilder ans, char ch, int k) {
        int it = ans.length() - 1;
        for (int i = 0; i < k - 1; i++) {
            if (ans.charAt(it) != ch) {
                return false;
            }
            it--;
        }

        return true;
    }

    public static String bruteForce(String s, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ans.length() < k - 1) {
                ans.append(ch);
            } else {
                if (areLastK_1charsSame(ans, ch, k)) {
                    for (int j = 0; j < k - 1; j++) {
                        ans.deleteCharAt(ans.length() - 1);
                    }
                } else {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }

    public static String optimalSolution(String s, int k) {
        StringBuilder str = new StringBuilder(s);
        int i = 0;
        int j = 0;
        int count[] = new int[s.length()];

        while (j < s.length()) {
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

    public static String removeDuplicates(String s, int k) {
        return optimalSolution(s, k);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcd", 2));
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
