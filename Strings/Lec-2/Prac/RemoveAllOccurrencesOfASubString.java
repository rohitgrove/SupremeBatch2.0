public class RemoveAllOccurrencesOfASubString {
    public static String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replace(part, "");
        }

        return s;
    }

    public static void main(String[] args) {
        String s1 = "daabcbaabcbc", part1 = "abc";
        System.out.println(removeOccurrences(s1, part1));
        String s2 = "axxxxyyyyb", part2 = "xy";
        System.out.println(removeOccurrences(s2, part2));
    }
}
