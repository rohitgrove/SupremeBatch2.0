public class LastOccurOfChar {
    static int ans = -1;

    public static void lastOccLTR(String str, char x, int idx) {
        if (idx >= str.length()) {
            return;
        }

        if (str.charAt(idx) == x) {
            ans = idx;
        }

        lastOccLTR(str, x, idx + 1);
    }

    public static void lastOccRTL(String str, char x, int idx) {
        if (idx < 0) {
            return;
        }

        if (str.charAt(idx) == x) {
            ans = idx;
            return;
        }

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
        char x = 'b';
        lastOccLTR(str, x, str.length() - 1);
        System.out.println(ans);
    }
}