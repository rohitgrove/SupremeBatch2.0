public class RemoveAllOccurncesOfASubString {
    public static String removeOCCRE(String s, String part) {
        int found = s.indexOf(part);
        if (found != -1) {
            // part string has been located
            // please remove it
            String left_part = s.substring(0, found);
            String right_part = s.substring(found + part.length());
            s = left_part + right_part;
            return removeOCCRE(s, part);
        } else {
            // base case
            // all the occurences of part has been remove from s.
            return s;
        }
    }

    public static String removeOccurrences(String s, String part) {
        return removeOCCRE(s, part);
    }

    public static void main(String[] args) {
        String s1 = "daabcbaabcbc", part1 = "abc";
        System.out.println(removeOccurrences(s1, part1));
        String s2 = "axxxxyyyyb", part2 = "xy";
        System.out.println(removeOccurrences(s2, part2));
    }
}
