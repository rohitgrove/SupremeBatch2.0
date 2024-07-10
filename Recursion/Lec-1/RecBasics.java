public class RecBasics {
    public static void PD(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        PD(n - 1);
    }

    public static void PI(int s, int e) {
        if (s > e) {
            return;
        }

        System.out.println(s);
        PI(s + 1, e);
    }

    public static void PDI(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        PDI(n - 1);
        System.out.println(n);
    }

    public static void PID(int s, int e) {
        if (s > e) {
            return;
        }

        System.out.println(s);
        PID(s + 1, e);
        System.out.println(s);
    }

    public static void main(String[] args) {
        // PD(5);
        // PI(1, 5);
        // PDI(5);
        PID(1, 5);
    }
}
