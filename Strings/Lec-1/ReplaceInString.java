public class ReplaceInString {
    public static void replaceCharacter(StringBuilder str) {
        int index = 0;

        while (index < str.length()) {
            char curr = str.charAt(index);

            if (curr == '@') {
                // insert space
                str.setCharAt(index, ' '); 
            }
            index++;
        }
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("My@Name@is@Rohit@Grover");
        System.out.println("Before: " + str);
        replaceCharacter(str);
        System.out.println("After: " + str);   
    }
}
