public class LastOccurenceOfchar {
    static int ans = -1;

    public static void lastOccLTR(String s, char x, int index) {
        // Base case
        if (index >= s.length()) {
            return;
        }
        // ek case solution
        if (s.charAt(index) == x) {
            ans = index;
        }

        lastOccLTR(s, x, index + 1);
    }

    public static int lastOccRTL(String s, char x, int index) {
        if (index == s.length()) {
            return -1;
        }
        int sp = lastOccRTL(s, x, index + 1);
        if (sp == -1 && s.charAt(index) == x) {
            return index;
        } else {
            return sp;
        }
    }

    public static void main(String[] args) {
        String s = "abcddedg";
        char x = 'd';
        System.out.println(lastOccRTL(s, x, 0));
    }
}