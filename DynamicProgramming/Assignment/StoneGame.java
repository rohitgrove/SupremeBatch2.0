public class StoneGame {
    public static boolean stoneGame(int[] piles) {
        // there will be at least one way by whicj Alice will win.
        // that means, we should return true
        // bcz problem is asking is there any way that alice can win.
        return true;
    }

    public static void main(String[] args) {
        int piles1[] = { 5, 3, 4, 5 };
        System.out.println(stoneGame(piles1));
        int piles2[] = { 3, 7, 2, 3 };
        System.out.println(stoneGame(piles2));
    }
}
