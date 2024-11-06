import java.util.ArrayList;
import java.util.Collections;

public class FactorialOfLargeNumbers {
    public static ArrayList<Integer> factorial(int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        int carry = 0;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < ans.size(); j++) {
                int x = ans.get(j) * i + carry;
                ans.set(j, x % 10);
                carry = x / 10;
            }

            while (carry > 0) {
                ans.add(carry % 10);
                carry /= 10;
            }
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println(factorial(N));
    }
}
