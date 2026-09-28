public class UpperCaseToLowerCase {
    public static void upperCaseToLowerCase1(StringBuilder str) {
        int index = 0;
        while (index < str.length()) {
            char character = str.charAt(index);
            if (character >= 'A' && character <= 'Z') {
                str.setCharAt(index, (char) (character - 'A' + 'a'));
            }
            index++;
        }
    }

    public static void upperCaseToLowerCase2(StringBuilder str) {
        int index = 0;
        while (index < str.length()) {
            char character = str.charAt(index);
            if (character >= 'A' && character <= 'Z') {
                str.setCharAt(index, (char) (character + 32));
            }
            index++;
        }
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println("Before: " + str);
        upperCaseToLowerCase2(str);
        System.out.println("After: " + str);
    }
}
