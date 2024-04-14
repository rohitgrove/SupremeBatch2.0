import java.util.Arrays;

public class CountPrimes {
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        int sqrtN = (int) Math.sqrt(num);

        for (int i = 2; i <= sqrtN; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int countPrimes(int n) {
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(i)) {
                c++;
            }
        }

        return c;
    }

    public static int sieveOfEratosthenes(int n) {
        if (n <= 1) {
            return 0;
        }

        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true); // all are prime mark All ready.
        prime[0] = prime[1] = false;

        int ans = 0;

        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                ans++;

                int j = i * i;
                while (j < n) {
                    prime[j] = false;
                    j += i;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }
}