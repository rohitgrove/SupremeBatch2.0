public class LastOccurOfChar {
    public static void lastOccLTR(String str, char x, int idx, int ans[]) {
        if (idx >= str.length()) {
            return;
        }

        if (str.charAt(idx) == x) {
            ans[0] = idx;
        }

        lastOccLTR(str, x, idx + 1, ans);
    }

    public static int lastOccRTL(String str, char x, int idx) {
        if (idx < 0) {
            return -1;
        }

        if (str.charAt(idx) == x) {
            return idx;
        }

        return lastOccRTL(str, x, idx - 1);
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

    public static int lastIndex(String s, char c) {
        // int ans[] = new int[] { -1 };
        // lastOccLTR(s, c, 0, ans);
        // return ans[0];
        // return lastOccRTL(s, c, s.length() - 1);
        return lastOcc(s, c, 0);
    }

    public static void main(String[] args) {
        String str = "rbcddegb";
        char x = 'b';
        System.out.println(lastIndex(str, x));
    }
}