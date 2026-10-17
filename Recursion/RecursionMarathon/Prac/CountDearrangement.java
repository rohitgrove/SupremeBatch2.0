public class CountDearrangement {
    public static int derangeCount(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        int ans = (n - 1) * (derangeCount(n - 1) + derangeCount(n - 2));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(derangeCount(2));
        System.out.println(derangeCount(3));
        System.out.println(derangeCount(4));
    }
}