public class PermutationOfString {
    public static void printPermutation(String str, int index) {
        // Base case
        if (index >= str.length()) {
            System.out.print(str + " ");
            return;
        }

        for (int j = index; j < str.length(); j++) {
            str = swap(str, index, j);
            // Recursion
            printPermutation(str, index + 1);
        }
    }

    public static String swap(String str, int i, int j) {
        char strArr[] = str.toCharArray();
        char temp = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = temp;
        return String.valueOf(strArr);
    }

    public static void main(String[] args) {
        String str = "abc";
        int index = 0;
        printPermutation(str, index); 
    }
}
