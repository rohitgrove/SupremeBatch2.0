public class CountPrimeNumbers {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        int sqrtN = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrtN; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int countPrimes(int n) { // tc: O(n2)
        int c = 0;

        for (int i = 0; i < n; i++) {
            if (isPrime(i)) {
                c++;
            }
        }

        return c;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
