public class ClearIthBitFromLast {
    public static void clearLastIBits(int n, int i) {
        int mask = (-1 << i);
        n = n & mask;
        System.out.println("Updated number: " + n);
    }
    public static void main(String[] args) {
        clearLastIBits(15, 2);
    }
}
