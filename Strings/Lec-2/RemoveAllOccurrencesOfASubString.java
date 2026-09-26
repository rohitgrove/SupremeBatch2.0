public class RemoveAllOccurrencesOfASubString {
    public static String removeOccurrences1(String s, String part) {
        while (s.contains(part)) {
            int idxPart = s.indexOf(part);
            String left = s.substring(0, idxPart);
            String right = s.substring(idxPart + part.length());
            s = left + right;
        }
        return s;
    }

    public static String removeOccurrences2(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
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
