public class CutIntoSegments {
    public static int maximizeCuts(int n, int x, int y, int z) {
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        int option1 = 1 + maximizeCuts(n - x, x, y, z);
        int option2 = 1 + maximizeCuts(n - y, x, y, z);
        int option3 = 1 + maximizeCuts(n - z, x, y, z);
        return Math.max(option1, Math.max(option2, option3));
    }
    public static void main(String[] args) {
        int N = 4, x = 2, y = 1, z = 1;
        System.out.println(maximizeCuts(N, x, y, z));
    }
}
