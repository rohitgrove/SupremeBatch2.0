public class PermutationOfStringBuilder {
    public static void printPermutation(StringBuilder str, int index) {
        // Base case
        if (index >= str.length()) {
            System.out.print(str + " ");
            return;
        }

        for (int j = index; j < str.length(); j++) {
            swap(str, index, j);
            // Recursion
            printPermutation(str, index + 1);
            // Backtracking
            swap(str, index, j);
        }
    }

    public static void swap(StringBuilder str, int i, int j) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("abc");
        int index = 0;
        printPermutation(str, index);
    }
}
