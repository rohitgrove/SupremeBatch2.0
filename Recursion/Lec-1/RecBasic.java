public class RecBasic {
    public static void printD(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        printD(n - 1);
    }

    public static void printI(int n) {
        if (n == 0) {
            return;
        }

        printI(n - 1);
        System.out.println(n);
    }

    public static void printID(int s, int n) {
        if (s > n) {
            return;
        }

        System.out.println(s);
        printID(s + 1, n);
        System.out.println(s);
    }

    public static void printDI(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        printDI(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        printDI(5);
    }
}
