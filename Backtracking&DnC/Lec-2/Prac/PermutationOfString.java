public class PermutationOfString {
    public static void printPermutation(String str, int index) {
        if (index >= str.length()) {
            System.out.print(str + " ");
            return;
        }

        for (int i = index; i < str.length(); i++) {
            str = swap(str, index, i);
            printPermutation(str, index + 1);
        }
    }

    public static String swap(String str, int i, int j) {
        char strChar[] = str.toCharArray();
        char temp = strChar[i];
        strChar[i] = strChar[j];
        strChar[j] = temp;
        return String.valueOf(strChar);
    }

    public static void main(String[] args) {
        String str = "abc";
        printPermutation(str, 0);
    }
}
