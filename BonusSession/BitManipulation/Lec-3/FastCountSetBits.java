public class FastCountSetBits {
    public static int fastCountSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n & (n-1));
        }

        return count;
    }
    public static void main(String[] args) {
        int n = 1024;
        System.out.println(fastCountSetBits(n));
    }
}
