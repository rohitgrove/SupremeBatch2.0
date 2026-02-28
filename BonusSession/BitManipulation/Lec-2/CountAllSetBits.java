public class CountAllSetBits {
    public static int countSetBits1(int n) {
        int count = 0;
        while (n > 0) {
            int bit = n % 2;
            if (bit == 1) {
                count++;
            }

            n = n / 2;
        }

        return count;
    }

    public static int countSetBits2(int n) {
        int count = 0;

        while (n > 0) {
            int bit = n & 1;
            if (bit == 1) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits2(34));
        System.out.println(countSetBits2(10));
        System.out.println(countSetBits2(5));
        System.out.println(countSetBits2(7));
    }
}
