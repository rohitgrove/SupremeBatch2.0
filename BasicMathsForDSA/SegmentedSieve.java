public class SegmentedSieve {
    public static boolean[] sieve(int n) {
        boolean[] sieve = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            sieve[i] = true;
        }
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= n; j += i) {
                    sieve[j] = false;
                }
            }
        }
        return sieve;
    }

    public static boolean[] segmentedSieve(int L, int R) {
        boolean[] sieve = sieve((int) Math.sqrt(R));
        int[] basePrimes = new int[sieve.length];
        int count = 0;
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                basePrimes[count++] = i;
            }
        }

        boolean[] segSieve = new boolean[R - L + 1];
        for (int i = 0; i <= R - L; i++) {
            segSieve[i] = true;
        }

        if (L == 1) {
            segSieve[0] = false;
        }

        for (int k = 0; k < count; k++) {
            int prime = basePrimes[k];
            int firstMul = (L / prime) * prime;
            firstMul = firstMul < L ? firstMul + prime : firstMul;
            int j = Math.max(firstMul, prime * prime);
            while (j <= R) {
                segSieve[j - L] = false;
                j += prime;
            }
        }
        return segSieve;
    }

    public static void main(String[] args) {
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
