public class CleatBitInRange {
    public static void clearBitsInRange(int n, int i, int j) {
        int a = (-1 << (i + 1));
        int b = ~(-1 << j);
        int mask = a | b;
        n = n & mask;
        System.out.println("Updated number: " + n);
    }

    public static void main(String[] args) {
        int n = 1023;
        clearBitsInRange(n, 8, 1);
    }
}
