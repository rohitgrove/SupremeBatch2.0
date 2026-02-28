public class PowerOf2 {
    public static boolean checkPowerOf2M1(int n) {
        // count set bit
        int count = 0;

        while (n != 0) {
            int lastbit = n&1;
            if (lastbit == 1) {
                count++;
            }
            n = n >> 1;
        }

        return count == 1;
    }

    public static boolean checkPowerOf2M2(int n) {
        return (n&(n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 1024;
        System.out.println(checkPowerOf2M2(n));
    }
}
