public class MergeStrings {
    public static String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;

        while (i < m || j < n) {
            if (i < m) {
                result.append(word1.charAt(i++));
            }
            if (j < n) {
                result.append(word2.charAt(j++));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        String merged = mergeAlternately(word1, word2);
        System.out.println("Merged string: " + merged);
    }
}
