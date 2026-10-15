public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static int bruteForce(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int optimalSolution(String haystack, String needle) {
        if (haystack.length() == 1 && needle.length() == 1 && haystack.equals(needle)) {
            return 0;
        }

        int i = 0;
        int j = needle.length();
        if (j > haystack.length()) {
            return -1;
        }

        while (j <= haystack.length()) {
            if (needle.equals(haystack.substring(i, j))) {
                return i;
            }
            i++;
            j++;
        }

        return -1;
    }

    public static int strStr(String haystack, String needle) {
        return optimalSolution(haystack, needle);
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
    }
}
