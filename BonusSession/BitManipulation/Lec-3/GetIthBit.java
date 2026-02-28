public class GetIthBit {
    public static void getIthBit(int n, int i) {
        int mask = (1 << i);
        int ans = n & mask;
        if (ans == 0) {
            System.out.println("bit-> 0");
        } else {
            System.out.println("bit-> 1");
        }
    }
    public static void main(String[] args) {
        int n = 10;
        int i = 20;

        getIthBit(n, i);
    }
}
