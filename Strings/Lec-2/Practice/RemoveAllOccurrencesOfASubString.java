public class RemoveAllOccurrencesOfASubString {
    public static String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            int idxPart = s.indexOf(part);
            String left = s.substring(0, idxPart);
            String right = s.substring(idxPart + part.length());
            s = left + right;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
        System.out.println(removeOccurrences("axxxxyyyyb", "xy"));
    }
}
