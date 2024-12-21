public class UpdateIthBit {
    public static void updateIthBit(int n, int i, int target) {
        // clear ith bit
        int mask = ~(1 << i);
        n = n & mask;
        // create mask
        mask = (target << i);
        // update n
        n = n | mask;
        System.out.println("Updated number: " + n);
    }

    public static void main(String[] args) {
        updateIthBit(10, 3, 0);
    }
}
