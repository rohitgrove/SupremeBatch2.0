public class WildCardMatching {
    public static boolean solve(String s, String p, int idx1, int idx2) {
        if (idx1 == s.length() && idx2 == p.length()) {
            return true;
        }

        if (idx1 == s.length() && idx2 < p.length()) {
            while (idx2 < p.length()) {
                if (p.charAt(idx2) != '*') {
                    return false;
                }

                idx2++;
            }

            return true;
        }

        if (idx1 < s.length() && idx2 == p.length()) {
            return false;
        }

        if (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '?') {
            return solve(s, p, idx1 + 1, idx2 + 1);
        }

        if (p.charAt(idx2) == '*') {
            boolean caseA = solve(s, p, idx1 + 1, idx2);
            boolean caseB = solve(s, p, idx1, idx2 + 1);
            return caseA || caseB;
        }

        return false;
    }

    public static boolean isMatch(String s, String p) {
        return solve(s, p, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("cb", "?a"));
    }
}
