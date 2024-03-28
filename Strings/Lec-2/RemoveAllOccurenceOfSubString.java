public class RemoveAllOccurenceOfSubString {
    public static String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");   
        }

        return s;
    }
    public static void main(String[] args) {
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(removeOccurrences(s, part));
        s = "axxxxyyyyb"; part = "xy";
        System.out.println(removeOccurrences(s, part));
    }    
}
