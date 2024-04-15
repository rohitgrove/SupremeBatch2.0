public class Power {
    public static int pow(int n) {
        if (n == 0) {
            return 1;
        }

        int ans = 2 * pow(n - 1);
        return ans;
    }

    public static int pow(int a, int b) {
        if (b == 0) {
            return 1;
        }

        int ans = a * pow(a, b - 1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 5));
    }
}
