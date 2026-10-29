public class PermutaionOfStringBuilder {
    public static void printPermutation(StringBuilder str, int index) {
        if (index >= str.length()) {
            System.out.print(str +" ");
            return;
        }

        for (int i = index; i < str.length(); i++) {
            swap(str, index, i);
            printPermutation(str, index + 1);
            swap(str, index, i);
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