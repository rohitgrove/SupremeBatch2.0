public class SumOfTwoIntegers {
    public static int getSum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
        System.out.println(getSum(2, 3));
    }
}