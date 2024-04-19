package Questions;

public class Question2 {
    public double myPow(double x, int n) {
        int p = Math.abs(n);
        double ans = 1.0;
        while (p >= 1) {
            p /= 2;
            x *= x;
        }
        return n < 0 ? 1 / ans : ans;
    }
}
