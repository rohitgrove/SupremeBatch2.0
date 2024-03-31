public class StringReversal {
    public static void reverseString(char[] input, int n, int start) {
        for (int i = start, j = n - 1 + start; i != j; i++, j--) {
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
    }

    public static void reverseEachWord(char[] input) {
        int start = 0, count = 1, i = 0;
        while (input[i] != '\0') {
            i++;
            count++;
            if (input[i] == '\0') {
                reverseString(input, count - 1, start);
                start = i + 1;
                count = 0;
            }
        }
    }

    public static void main(String[] args) {
        String str = "Hello World!";
        char[] charArray = str.toCharArray();

        reverseEachWord(charArray);

        String reversedString = new String(charArray);
        System.out.println("Reversed String: " + reversedString);
    }
}
