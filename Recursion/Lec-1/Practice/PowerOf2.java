public class PowerOf2 {
    public static int powerOf2(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 2;
        }

        return 2 * powerOf2(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(powerOf2(5));
    }
}
