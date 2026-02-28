public class CheckEvenOrOdd {
    public static boolean checkEven(int n) {
        return (n % 2 == 0);
    }

    public static boolean checkEvenBitWise(int n) {
        return (n & 1) == 0;
    }

    public static void main(String[] args) {
        int n = 22;
        boolean isEven = checkEvenBitWise(n);

        if (isEven) {
            System.out.println(n + " is Even number");
        } else {
            System.out.println(n + " is Odd number");
        }
    }
}
