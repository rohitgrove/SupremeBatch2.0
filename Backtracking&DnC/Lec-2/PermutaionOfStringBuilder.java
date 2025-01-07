public class PermutaionOfStringBuilder {
    public static void printPermutation(StringBuilder str, int index) {
        // base case
        if (index >= str.length()) {
            System.out.print(str + " ");
            return;
        }

        for (int j = index; j < str.length(); j++) {
            swap(str, index, j);
            // recursion bhaiya
            printPermutation(str, index + 1);
            // backtracking
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
        printPermutation(str, 0);
    }
}
