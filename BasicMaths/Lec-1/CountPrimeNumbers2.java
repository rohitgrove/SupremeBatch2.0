import java.util.Arrays;

public class CountPrimeNumbers2 {
    public static int sieveOfEratosthores(int n) {// tc: O(n (loglogn))
        if (n <= 1) {
            return 0;
        }

        boolean prime[] = new boolean[n];
        Arrays.fill(prime, true); // all are prime marked already.
        prime[0] = prime[1] = false;

        int ans = 0;
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                ans++;

                int j = 2 * i;
                while (j < n) {
                    prime[j] = false;
                    j += i;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sieveOfEratosthores(21));
    }
}
