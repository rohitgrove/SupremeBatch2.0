public class ConvertToUpperCase {
    public static void convertToUpperCase1(StringBuilder str) {
        int index = 0;
        while (index < str.length()) {
            char currCharacter = str.charAt(index);
            // chech if lowercase, then convert to upper case
            if (currCharacter >= 'a' && currCharacter <= 'z') {
                str.setCharAt(index, (char) (currCharacter - 'a' + 'A'));
            }
            index++;
        }
    }

    public static void convertToUpperCase2(StringBuilder str) {
        int index = 0;
        while (index < str.length()) {
            char currCharacter = str.charAt(index);
            if (currCharacter >= 'a' && currCharacter <= 'z') {
                str.setCharAt(index, (char) (currCharacter - 32));
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
