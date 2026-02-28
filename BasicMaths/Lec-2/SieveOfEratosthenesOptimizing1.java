import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEratosthenesOptimizing1 {
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (sieve[i]) {
                int j = i * i;
                while (j < n) {
                    sieve[j] = false;
                    j += i;
                }
            }
        }

        return sieve;
    }

    public static boolean[] segmentedSieve(int L, int R) {
        // Get base primes using regular sieve
        int limit = (int) Math.sqrt(R);
        boolean[] baseSieve = sieveOfEratosthenes(limit);
        ArrayList<Integer> basePrimes = new ArrayList<>();

        for (int i = 0; i < baseSieve.length; i++) {
            if (baseSieve[i]) {
                basePrimes.add(i);
            }
        }

        // Create the segmented sieve
        boolean[] segSieve = new boolean[R - L + 1];
        for (int i = 0; i < segSieve.length; i++) {
            segSieve[i] = true;
        }

        if (L == 1) {
            segSieve[0] = false;
        }

        for (int prime : basePrimes) {
            int firstMul = (L / prime) * prime;
            if (firstMul < L) {
                firstMul += prime;
            }

            int j = Math.max(firstMul, prime * prime);
            while (j <= R) {
                segSieve[j - L] = false;
                j += prime;
            }
        }

        return segSieve;
    }

    public static void main(String[] args) {
        // boolean sieve[] = sieveOfEratosthenes1(10);
        // for (int i = 0; i < sieve.length; i++) {
        //     if (sieve[i]) {
        //         System.out.print(i + " ");
        //     }
        // }

        int L = 110;
        int R = 130;
        boolean[] segSieve = segmentedSieve(L, R);
        for (int i = 0; i < segSieve.length; i++) {
            if (segSieve[i]) {
                System.out.print((L + i) + " ");
            }
        }
        System.out.println();
    }
}
