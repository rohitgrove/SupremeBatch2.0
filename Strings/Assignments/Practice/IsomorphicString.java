public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        char hash[] = new char[256];
        boolean issbCharMapped[] = new boolean[256];

        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] == 0 && issbCharMapped[t.charAt(i)] == false) {
                hash[s.charAt(i)] = t.charAt(i);
                issbCharMapped[t.charAt(i)] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] != t.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("f11", "b23"));
        System.out.println(isIsomorphic("paper", "title"));
    }
}
