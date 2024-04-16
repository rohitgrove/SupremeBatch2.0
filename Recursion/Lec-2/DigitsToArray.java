import java.util.ArrayList;

public class DigitsToArray {
    public static void printDigits(int num) {
        if (num == 0) {
            return;
        }

        int digit = num % 10;
        num = num / 10;
        printDigits(num);
        System.out.println(digit);
    }

    public static void storeDigits(int num, ArrayList<Integer> ans) {
        if (num == 0) {
            return;
        }

        int digit = num % 10;
        num = num / 10;
        storeDigits(num, ans);
        ans.add(digit);
    }

    public static void main(String[] args) {
        int num = 4215;
        // printDigits(num);
        ArrayList<Integer> ans = new ArrayList<>();
        storeDigits(num, ans);
        System.out.println(ans);
    }
}
