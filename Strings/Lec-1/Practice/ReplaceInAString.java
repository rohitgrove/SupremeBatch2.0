public class ReplaceInAString {
    public static void replaceCharacter(StringBuilder str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '@') {
                str.setCharAt(i, ' ');
            }
        }
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("My@Name@is@Rohit@Grover");
        System.out.println("Before: " + str);
        replaceCharacter(str);
        System.out.println("After: " + str);
    }
}
