public class ConvertToLowerCase {
    public static void convertToLowerCase1(StringBuilder str) {
        int index = 0;
        while (index < str.length()) {
            char currCharacter = str.charAt(index);
            if (currCharacter >= 'A' && currCharacter <= 'Z') {
                str.setCharAt(index, (char) (currCharacter - 'A' + 'a'));
            }
            index++;
        }    
    }

    public static void convertToLowerCase2(StringBuilder str) {
        int index = 0;
        while (index < str.length()) {
            char currCharacter = str.charAt(index);
            if (currCharacter >= 'A' && currCharacter <= 'Z') {
                str.setCharAt(index, (char) (currCharacter + 32));
            }
            index++;
        }
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println("Before: " + str);
        convertToLowerCase2(str);
        System.out.println("After: " + str);
    }
}
