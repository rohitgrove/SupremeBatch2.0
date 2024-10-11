public class CheckPowerOf2 {
    public static boolean checkPowerOf2(int n) {
        if (n <= 0) {
            return false;
        }
        // count set bit
        int count = 0;

        while (n != 0) {
            int lastbit = n & 1;
            if (lastbit == 1) {
                count++;
            }
            n = n >> 1;
        }

        System.out.println(count);
        return count == 1;
    }

    public static boolean fastCheckPowerOf2(int n) {
        if (n <= 0) {
            return false;
        }
        // count set bit
        int count = 0;
        while (n != 0) {
            count++;
            n = (n & (n - 1));
        }
        
        System.out.println(count);
        return count == 1;
    }

    public static boolean moreFastCheckPowerOf2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int number = 1024;
        boolean isPowerOfTwo = fastCheckPowerOf2(number);
        System.out.println(number + " is a power of 2: " + isPowerOfTwo);
    }
}
