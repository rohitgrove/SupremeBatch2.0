public class RemoveAllOccurrencesOfASubstring {
    public static String solveUsingRec(String s, String part) {
        int found = s.indexOf(part);
        if (found != -1) {
            String left = s.substring(0, found);
            String right = s.substring(found + part.length());
            s = left + right;
            return solveUsingRec(s, part);
        } else {
            return s;
        }
    }

    public static String removeOccurrences(String s, String part) {
        return solveUsingRec(s, part);
    }

    public static void main(String[] args) {
        String s1 = "daabcbaabcbc", part1 = "abc";
        System.out.println(removeOccurrences(s1, part1));
        String s2 = "axxxxyyyyb", part2 = "xy";
        System.out.println(removeOccurrences(s2, part2));
    }
}
