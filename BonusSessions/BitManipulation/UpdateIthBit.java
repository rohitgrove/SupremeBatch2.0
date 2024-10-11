public class UpdateIthBit {
    public static void updateIthBit(int n, int i, int target) {
        // clear ith bit
        int mask1 = ~(1 << i);
        n = n & mask1;
        // create mask
        int mask = (target << i);
        // update n
        n = n | mask;
        System.out.println("Updated number: " + n);
    }

    public static void main(String[] args) {
        int n = 10;
        int i = 3;
        int target = 0;
        updateIthBit(n, i, target);
    }
}
