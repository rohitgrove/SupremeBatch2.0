public class DecimalToBinary {
    public static int decimalToBinaryM1(int n) {
        // devision Method.
        int binaryno = 0;
        int i = 0;
        while (n > 0) {
            int bit = n % 2;
            binaryno = (int) (bit * Math.pow(10, i)) + binaryno;
            i++;
            n = n / 2;
        }

        return binaryno;
    }

    public static int decimalToBinaryM2(int n) {
        // left shift Method.
        int binaryno = 0;
        int i = 0;
        while (n > 0) {
            int bit = n & 1;
            binaryno = (int) (bit * Math.pow(10, i)) + binaryno;
            i++;
            n = n >> 1;
        }

        return binaryno;
    }

    public static void main(String[] args) {
        int n = 26;
        int binary = decimalToBinaryM2(n);
        System.out.println(binary);
    }
}
