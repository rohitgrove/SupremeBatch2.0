import java.util.Arrays;

public class CountPrimeNumbers2 {
    public static int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        boolean prime[] = new boolean[n];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        int cnt = 0;

        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                cnt++;
                int j = i * 2;
                while (j < n) {
                    prime[j] = false;
                    j += i;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
