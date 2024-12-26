public class MaximizeTheCutSegments {
    public static int maximizeCuts(int n, int x, int y, int z) {
        if (n == 0) {
            return 0;
        }
        
        if (n < 0) {
            return Integer.MIN_VALUE;
        }
        // maine x len ka 1 segment cut krlia and baaki recursion dekhlega
        int option1 = 1 + maximizeCuts(n - x, x, y, z);
        // maine y len ka 1 segment cut krlia and baaki recursion dekhlega
        int option2 = 1 + maximizeCuts(n - y, x, y, z);
        // maine z len ka 1 segment cut krlia and baaki recursion dekhlega
        int option3 = 1 + maximizeCuts(n - z, x, y, z);
        return Math.max(option1, Math.max(option2, option3));
    }
    
    public static void main(String[] args) {
        System.out.println(maximizeCuts(4, 2, 1, 1));
        System.out.println(maximizeCuts(5, 5, 3, 2));
        System.out.println(maximizeCuts(7, 8, 9, 10));
    }
}
