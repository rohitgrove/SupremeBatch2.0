public class CutIntoSegments {
    public static int solve(int N, int x, int y, int z) {
        if (N == 0) {
            return 0;
        }

        if (N < 0) {
            return Integer.MIN_VALUE;
        }

        int option1 = 1 + solve(N - x, x, y, z);
        int option2 = 1 + solve(N - y, x, y, z);
        int option3 = 1 + solve(N - z, x, y, z);
        return Math.max(option1, Math.max(option2, option3));
    }
    public static void main(String[] args) {
        int N = 4, x = 2, y = 1, z = 1;
        System.out.println(solve(N, x, y, z));
    }
}
