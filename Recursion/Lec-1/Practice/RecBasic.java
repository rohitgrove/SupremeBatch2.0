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

    public static void printDI(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        printDI(n - 1);
        System.out.println(n);
    }

    public static void printID(int n, int start) {
        if (start > n) {
            return;
        }

        System.out.println(start);
        printID(n, start + 1);
        System.out.println(start);
    }

    public static void main(String[] args) {
        printID(5, 1);
    }
}
