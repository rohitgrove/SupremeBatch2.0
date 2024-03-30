public class RemoveAllOccrrenceOfString {
    public static String removeOccurrences1(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }

        return s;
    }

    public static String removeOccurrences2(String s, String part) {
        while (true) {
            int found = s.indexOf(part);
            if (found == -1) {
                break;
            }

            String LP = s.substring(0, found);
            String RP = s.substring(found + part.length());
            s = LP + RP;
        }

        return s;
    }

    public static void main(String[] args) {
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(removeOccurrences1(s, part));
    }
}
