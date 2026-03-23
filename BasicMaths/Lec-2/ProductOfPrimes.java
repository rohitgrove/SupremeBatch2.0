public class ProductOfPrimes {
    private static final long M = 1000000007;

    // Function to create a sieve array for primes up to 'n'
    public static boolean[] sieve(long n) {
        // Create a sieve array with true values initially
        boolean[] sieve = new boolean[(int) (n + 1)];
        for (int i = 0; i <= n; i++) {
            sieve[i] = true;
        }
        sieve[0] = false; // 0 is not prime
        sieve[1] = false; // 1 is not prime

        for (long i = 2; i * i <= n; i++) {
            if (sieve[(int) i]) {
                for (long j = i * i; j <= n; j += i) {
                    sieve[(int) j] = false;
                }
            }
        }
        return sieve;
    }

    // Segmented sieve to mark primes in the range [L, R]
    public static boolean[] segmentedSieve(long L, long R) {
        // Get base primes using the standard sieve up to sqrt(R)
        boolean[] sieve = sieve((long) Math.sqrt(R));
        int basePrimeCount = 0;

        // Count the number of base primes
        for (boolean isPrime : sieve) {
            if (isPrime) {
                basePrimeCount++;
            }
        }

        // Store base primes in an array
        long[] basePrimes = new long[basePrimeCount];
        int idx = 0;
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                basePrimes[idx++] = i;
            }
        }

        // Create a boolean array for the range [L, R]
        boolean[] segSieve = new boolean[(int) (R - L + 1)];
        for (int i = 0; i < segSieve.length; i++) {
            segSieve[i] = true;
        }

        if (L == 1) {
            segSieve[0] = false; // 1 is not prime
        }

        // Mark non-prime numbers in the segmented sieve
        for (long prime : basePrimes) {
            long firstMultiple = (L / prime) * prime;
            if (firstMultiple < L) {
                firstMultiple += prime;
            }

            long start = Math.max(firstMultiple, prime * prime);
            for (long j = start; j <= R; j += prime) {
                segSieve[(int) (j - L)] = false;
            }
        }
        return segSieve;
    }

    // Function to calculate the product of primes in the range [L, R]
    public static long primeProduct(long L, long R) {
        boolean[] segSieve = segmentedSieve(L, R);
        long ans = 1;

        for (int i = 0; i < segSieve.length; i++) {
            if (segSieve[i]) {
                long actualPrime = (L + i) % M;
                ans = (ans * actualPrime) % M;
            }
        }
        return ans;
    }
}
