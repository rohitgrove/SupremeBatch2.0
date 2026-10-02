public class SumOfNNumbers {
    public static int sumOfNNaturalNumbers(int n) {
        if (n == 0) {
            return 0;
        }

        return n + sumOfNNaturalNumbers(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumOfNNaturalNumbers(5));
    }
}
