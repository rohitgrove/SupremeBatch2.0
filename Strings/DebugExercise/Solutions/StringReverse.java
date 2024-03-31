public class StringReverse {
    public static void reverseString(char[] input, int n, int start) {
        for (int i = start, j = n - 1 + start; i < j; i++, j--) {
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
    }

    public static void reverseEachWord(char[] input) {
        int start = 0, count = 1, i = 0;
        while (i < input.length) {
            if (input[i] == ' ' || input[i] == '\0') {
                reverseString(input, count - 1, start);
                start = i + 1;
                count = 0;
            }
            i++;
            count++;
        }
        reverseString(input, count - 1, start);  // Reverse the last word
    }

    public static void main(String[] args) {
        char[] input = "Hello World".toCharArray();
        reverseEachWord(input);
        String reversed = new String(input);
        System.out.println("Reversed String: " + reversed);
    }
}
