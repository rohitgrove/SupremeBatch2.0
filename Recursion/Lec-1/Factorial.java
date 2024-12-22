public class Factorial {
    public static int fact(int n) {
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // recursive relation
        int recursionKaAns = fact(n - 1);

        // processing
        int finalAns = n * recursionKaAns;
        return finalAns;
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
    }
}
