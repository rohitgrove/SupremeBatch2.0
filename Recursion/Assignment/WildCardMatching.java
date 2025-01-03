public class WildCardMatching {
    public static boolean isMatchHelper(String s, int si, String p, int pi) {
        // base case
        if (si == s.length() && pi == p.length()) {
            return true;
        }

        if (si == s.length() && pi < p.length()) {
            while (pi < p.length()) {
                if (p.charAt(pi) != '*') {
                    return false;
                }

                pi++;
            }

            return true;
        }

        if (si < s.length() && pi == p.length()) {
            return false;
        }

        // single char matching
        if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') {
            return isMatchHelper(s, si + 1, p, pi + 1);
        }

        if (p.charAt(pi) == '*') {
            // treat '*' as empty or null
            boolean caseA = isMatchHelper(s, si, p, pi + 1);

            // let '*' consume one char.
            boolean caseB = isMatchHelper(s, si + 1, p, pi);

            return caseA || caseB;
        }

        // char doesn't match
        return false;
    }
    public static boolean isMatch(String s, String p) {
        int si = 0; // pointer index for s string
        int pi = 0; // pointer index for p string

        return isMatchHelper(s, si, p, pi);
    }

    public static void main(String[] args) {
        String s1 = "aa", p1 = "a";
        System.out.println(isMatch(s1, p1));
        String s2 = "aa", p2 = "*";
        System.out.println(isMatch(s2, p2));
        String s3 = "cb", p3 = "?a";
        System.out.println(isMatch(s3, p3));
    }
}
