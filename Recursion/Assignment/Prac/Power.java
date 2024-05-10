public class Power {
    public static int pow(int a, int n) {
        if (n == 0) {
            return 1;
        }

        return a * pow(a, n - 1); 
    }

    public static int lognPow(int a, int n) {
        if (n == 0) {
            return 1;
        }

        int half = lognPow(a, n / 2);
        int sqaure = half * half;

        if (n % 2 != 0) {
            sqaure = a * sqaure;
        }

        return sqaure;
    }

    public static void main(String[] args) {
        int a = 2, n = 10;
        System.out.println(pow(a, n));
    }    
}
