public class FirstOccurenceOfAString {
    public static int strStr(String haystack, String needle) {
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
    public static void main(String[] args) {
        String haystack1 = "sadbutsad", needle1 = "sad";
        System.out.println(strStr(haystack1, needle1));
        String haystack2 = "leetcode", needle2 = "leeto";
        System.out.println(strStr(haystack2, needle2));
        String haystack3 = "abc", needle3 = "c";
        System.out.println(strStr(haystack3, needle3));
        String haystack4 = "a", needle4 = "a";
        System.out.println(strStr(haystack4, needle4));
    }
}
