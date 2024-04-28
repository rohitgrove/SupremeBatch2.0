public class WildCardMatching {
    public static boolean solve(String s, int sIdx, String p, int pIdx) {
        if (sIdx == s.length() && pIdx == p.length()) {
            return true;
        }

        if (sIdx == s.length() && pIdx < p.length()) {
            while (pIdx < p.length()) {
                if (p.charAt(pIdx) != '*') {
                    return false;
                }
                pIdx++;
            }
            return true;
        }

        if (sIdx < s.length() && pIdx == p.length()) {
            return false;
        }


        if (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '?') {
            return solve(s, sIdx + 1, p, pIdx + 1);
        }

        if (p.charAt(pIdx) == '*') {
            boolean option1 = solve(s, sIdx, p, pIdx + 1);
            boolean option2 = solve(s, sIdx + 1, p, pIdx);
            return option1 || option2;
        }

        return false;
    }
    public static boolean isMatch(String s, String p) {
        int sIdx = 0;
        int pIdx = 0;

        return solve(s, sIdx, p, pIdx);
    }
    public static void main(String[] args) {
        String s1 = "aa", p1 = "a";
        System.out.println(isMatch(s1, p1));
        String s2 = "aa", p2 = "*";
        System.out.println(isMatch(s2, p2));
        String s3 = "cb", p3 = "?a";
        System.out.println(isMatch(s3, p3));
        String s4 = "abcdefg", p4 = "ab*fg";
        System.out.println(isMatch(s4, p4));   
    }
}
