public class ReverseAString {
    public static void reverseString1(char ch[]) {
        int i = 0;
        int j = ch.length - 1;
        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }

    public static void reverseString2(StringBuilder str) {
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            char temp = str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j, temp);
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
        // String str = "grover";
        // char ch[] = str.toCharArray();
        // System.out.print("before ");
        // System.out.println(ch);
        // reverseString1(ch);
        // System.out.print("After ");
        // System.out.println(ch);

        StringBuilder str = new StringBuilder("grover");
        System.out.print("before ");
        System.out.println(str);
        reverseString2(str);
        System.out.print("After ");
        System.out.println(str);
    }
}

