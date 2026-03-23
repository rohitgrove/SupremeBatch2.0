public class SetKthBit {
    public static int setKthBit(int N, int K) {
        int mask = 1 << K;
        int ans = N | mask;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(setKthBit(10, 2));
        System.out.println(setKthBit(15, 3));
    }
}
