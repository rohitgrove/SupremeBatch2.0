import java.util.Arrays;

public class SieveOfEratosthenesOptimizing2 {
    public static int sieveOfEratosthenes(int n) {
        if (n <= 1) {
            return 0;
        }

        boolean isPrime[] = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                int j = i * i;
                while (j < n) {
                    isPrime[j] = false;
                    j += i;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(sieveOfEratosthenes(10));
    }
}