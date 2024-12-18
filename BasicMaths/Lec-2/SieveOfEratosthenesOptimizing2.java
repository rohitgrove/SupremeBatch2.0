import java.util.Arrays;

public class SieveOfEratosthenesOptimizing2 {
    public static int sieveOfEratosthenes(int n) {
        if (n <= 2) {
            return 0;
        }

        int count = 0;
        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (sieve[i]) {
                int j = i * i;
                while (j < n) {
                    sieve[j] = false; // Mark as not prime
                    j += i;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (sieve[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(sieveOfEratosthenes(10));
    }
}
