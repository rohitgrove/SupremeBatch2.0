public class ReverseAString {
    public static void solveUsingRec(char[] s, int start, int end) {
        if (start > end) {
            return;
        }

        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        solveUsingRec(s, start + 1, end - 1);
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        solveUsingRec(s, start, end);
    }

    public static void printAns(char[] s) {
        for (char c : s) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char s1[] = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(s1);
        printAns(s1);
        char s2[] = { 'H', 'a', 'n', 'n', 'a', 'h' };
        reverseString(s2);
        printAns(s2);
    }
}
