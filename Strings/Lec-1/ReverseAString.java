public class ReverseAString {
    public static void reverseString(char ch[]) {
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
    
    public static void main(String[] args) {
        String str = "grover";
        char ch[] = str.toCharArray();
        System.out.print("before ");
        System.out.println(ch);
        reverseString(ch);
        System.out.print("After ");
        System.out.println(ch);
    }
}
