public class LowerCaseToUpperCase {
    public static void convertToUpperCase1(StringBuilder str) {
        int index = 0;
        while (index < str.length()) {
            char character = str.charAt(index);
            if (character >= 'a' && character <= 'z') {
                str.setCharAt(index, (char) (character - 'a' + 'A'));
            }
            index++;
        }
    }

    public static void convertToUpperCase2(StringBuilder str) {
        int index = 0;
        while (index < str.length()) {
            char character = str.charAt(index);
            if (character >= 'a' && character <= 'z') {
                str.setCharAt(index, (char) (character - 32));
            }
            index++;
        }
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append("abcdefghijklmnopqrstuvwxyz");
        System.out.println("Before: " + str);
        convertToUpperCase2(str);
        System.out.println("After: " + str);
    }
}
