public class ReverseAString {
    public static void reverse(StringBuilder str, int start, int end) {
        // base case
        if (start >= end) {
            return;
        }

        // ek case
        char ch = str.charAt(start);
        str.setCharAt(start, str.charAt(end));
        str.setCharAt(end, ch);

        // bakki recurion sumbhal lega
        reverse(str, start + 1, end - 1);
    }
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append("abcd");
        reverse(str, 0, str.length() - 1);
        System.out.println(str);
    }
}
