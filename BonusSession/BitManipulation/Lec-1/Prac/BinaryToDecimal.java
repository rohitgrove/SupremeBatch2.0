public class BinaryToDecimal {
    public static int binaryToDecimal(int n) {
        int decimal = 0;
        int i = 0;
        while (n > 0) {
            int bit = n % 10;
            if (bit == 1) {
                decimal = (int) (decimal + Math.pow(2, i));
            }
            n = n / 10;
            i++;
        }

        return decimal;
    }

    public static void main(String[] args) {
        int n = 10110;
        int decimal = binaryToDecimal(n);
        System.out.println(decimal);
    }
}