public class GCDOfTwoNumbers {
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        while (a > 0 && b > 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        return a == 0 ? b : a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(3, 6));
    }
}