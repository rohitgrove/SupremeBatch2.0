import java.util.ArrayList;
import java.util.List;

public class PrintDigit {
    public static void printDigit(int num, List<Integer> digits) {
        // base case
        if (num == 0) {
            return;
        }

        //processing
        int digit = num % 10;

        //Recursive call
        printDigit(num / 10, digits);

        //processing
        digits.add(digit);
    }
    public static void main(String[] args) {
        int num = 4217;
        List<Integer> digits = new ArrayList<>();
        printDigit(num, digits);
        System.out.println(digits);
    }
}
