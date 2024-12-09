public class RemoveAllOccurrencesOfASubString {
    public static String removeOccurrences1(String s, String part) {
        while (s.contains(part)) {
            int found = s.indexOf(part);
            String lp = s.substring(0, found);
            String rp = s.substring(found + part.length());

            s = lp + rp;
        }

        return s;
    }

    public static String removeOccurrences2(String s, String part) {
        while (true) {
            int found = s.indexOf(part);
            if (found == -1) {
                break;
            }

            // remove karna hai
            String LP = s.substring(0, found);
            String RP = s.substring(found + part.length());

            // concat bath Parts
            s = LP + RP;
        }

        return s;
    }

    public static void main(String[] args) {
        String s1 = "daabcbaabcbc", part1 = "abc";
        System.out.println(removeOccurrences1(s1, part1));
        String s2 = "axxxxyyyyb", part2 = "xy";
        System.out.println(removeOccurrences1(s2, part2));
    }
}
