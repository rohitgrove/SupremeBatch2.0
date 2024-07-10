public class RemoveAllOccurenceOfASubString {
    public static String removeOCCRE(String s, String part) {
        int found = s.indexOf(part);
        if (found != -1) {
            // part string has been located
            // Please remove it
            String LP = s.substring(0, found);
            String RP = s.substring(found + part.length());
            s = LP + RP;
            return removeOCCRE(s, part);
        } else {
            // base case
            // all the occurences of part has been removed from s.
            return s;
        }
    }

    public static String removeOccurrences(String s, String part) {
        return removeOCCRE(s, part);
    }

    public static void main(String[] args) {
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(removeOccurrences(s, part));
    }
}
