public class FindTheIndexOfFirstOccurence {
    public static int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStr2(String haystack, String needle) {
        if (haystack.length() == 1 && needle.length() == 1 && haystack.equals(needle)) {
            return 0;
        }
        int i = 0;
        int j = needle.length();
        if (j > haystack.length()) {
            return -1;
        }

        while (j <= haystack.length()) {
            String str = haystack.substring(i, j);
            if (str.equals(needle)) {
                return i;
            }
            i++;
            j++;
        }

        return -1;
    }

    public static int strStr3(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack1 = "sadbutsad", needle1 = "sad";
        System.out.println(strStr2(haystack1, needle1));
        String haystack2 = "leetcode", needle2 = "leeto";
        System.out.println(strStr2(haystack2, needle2));
        String haystack3 = "abc", needle3 = "c";
        System.out.println(strStr2(haystack3, needle3));
        String haystack4 = "a", needle4 = "a";
        System.out.println(strStr2(haystack4, needle4));
    }
}
