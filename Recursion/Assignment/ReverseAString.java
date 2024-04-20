public class ReverseAString {
    public static void reverse(StringBuilder str, int s, int e) {
        if (s >= e) {
            return;
        }

        char ch = str.charAt(s);
        str.setCharAt(s, str.charAt(e));
        str.setCharAt(e, ch);
        reverse(str, s + 1, e - 1);
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("abcd");
        reverse(s, 0, s.length() - 1);
        System.out.println(s);
    }
}
