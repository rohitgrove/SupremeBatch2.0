public class LastOccurOfChar {
    static int ans = -1;

    public static void lastOccLTR(String str, char x, int idx) {
        // base case
        if (idx >= str.length()) {
            return;
        }
        // ek case solution
        if (str.charAt(idx) == x) {
            ans = idx;
        }

        // RE
        lastOccLTR(str, x, idx + 1);
    }

    public static void lastOccRTL(String str, char x, int idx) {
        // base case
        if (idx < 0) {
            return;
        }
        // ek case solution
        if (str.charAt(idx) == x) {
            ans = idx;
            return;
        }

        // RE
        lastOccRTL(str, x, idx - 1);
    }

    public static int lastOcc(String str, char x, int idx) {
        if (idx >= str.length()) {
            return -1;
        }

        int isFound = lastOcc(str, x, idx + 1);

        if (isFound == -1 && str.charAt(idx) == x) {
            return idx;
        }
        return isFound;
    }

    public static void main(String[] args) {
        String str = "rbcddegb";
        char x = 'd';
        lastOccRTL(str, x, str.length() - 1);
        System.out.println(ans);
    }
}