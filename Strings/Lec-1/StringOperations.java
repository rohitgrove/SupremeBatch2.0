public class StringOperations {
    public static void reverseString(char[] ch) {
        int i = 0;
        int j = ch.length - 1;

        while (i <= j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }

    public static void convertToUpperCase(char[] ch) {
        for (int index = 0; index < ch.length; index++) {
            if (ch[index] >= 'a' && ch[index] <= 'z') {
                ch[index] = (char) (ch[index] - 'a' + 'A');
            }
        }
    }

    public static void replaceCharacter(char[] ch) {
        for (int index = 0; index < ch.length; index++) {
            if (ch[index] == '@') {
                ch[index] = ' ';
            }
        }
    }

    public static boolean checkPalindrome(char[] ch) {
        int i = 0;
        int j = ch.length - 1;

        while (i <= j) {
            if (ch[i] == ch[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "hello@olleh";
        char[] charArray = input.toCharArray();

        // Example usage of the functions
        reverseString(charArray);
        System.out.println("Reversed String: " + new String(charArray));

        convertToUpperCase(charArray);
        System.out.println("Uppercase String: " + new String(charArray));

        replaceCharacter(charArray);
        System.out.println("String with replaced characters: " + new String(charArray));

        boolean isPalindrome = checkPalindrome(charArray);
        System.out.println("Is Palindrome? " + isPalindrome);
    }
}
