import java.util.ArrayList;
import java.util.List;

public class PrintDigit {
    public static void printDigit(int num, List<Integer> digits) {
        if (num == 0) {
            return;
        }

        int digit = num % 10;

        printDigit(num / 10, digits);

        digits.add(digit);
    }

    public static void main(String[] args) {
        int num = 4217;
        List<Integer> digits = new ArrayList<>();
        printDigit(num, digits);
        System.out.println(digits);
    }
}
