public class FindTheIndexOfFirstIndex {
    public static int strStr1(String haystack, String needle) {
        int i = 0;
        int j = needle.length() - 1;
        while (j < haystack.length()) {
            if (haystack.substring(i, j + 1).equals(needle)) {
                return i;
            }
            i++;
            j++;
        }

        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            for (int j = 0; j < m; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
                if (j == m - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack1 = "sadbutsad", needle1 = "sad";
        System.out.println(strStr2(haystack1, needle1));
        String haystack2 = "leetcode", needle2 = "leeto";
        System.out.println(strStr2(haystack2, needle2));
    }
}
