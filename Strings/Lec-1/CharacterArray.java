import java.util.Scanner;

public class CharacterArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String str = sc.next();
        String str = sc.nextLine();
        char ch[] = new char[100];
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }

        System.out.print("Printing the value of ch: ");
        System.out.println(ch);

        // for (int i = 0; i < ch.length; i++) {
            // System.out.println("At Index: " + i + " " + ch[i]);
        // }

        // char temp = ch[6];
        // System.out.println((int) temp);
        sc.close();
    }
}