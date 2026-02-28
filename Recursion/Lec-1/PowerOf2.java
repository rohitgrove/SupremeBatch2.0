public class PowerOf2 {
    public static int pow(int n) {
        // base case
        if (n == 0) {
            return 1;
        }

        int ans = 2 * pow(n - 1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(pow(10));
    }
}
