import java.util.Stack;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            if (k > 0) {
                while (!st.isEmpty() && st.peek() > digit) {
                    st.pop();
                    k--;
                    if (k == 0) {
                        break;
                    }
                }
            }
            st.push(digit);
        }

        if (k > 0) {
            while (!st.isEmpty() && k > 0) {
                st.pop();
                k--;
            }
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        // removing leading 0
        while (ans.length() > 0 && ans.charAt(ans.length() - 1) == '0') {
            ans.deleteCharAt(ans.length() - 1);
        }

        ans.reverse();

        return ans.length() == 0 ? "0" : ans.toString();
    }

    public static void main(String[] args) {
        String num1 = "1432219";
        int k1 = 3;
        System.out.println(removeKdigits(num1, k1));
        String num2 = "10200";
        int k2 = 1;
        System.out.println(removeKdigits(num2, k2));
        String num3 = "10";
        int k3 = 2;
        System.out.println(removeKdigits(num3, k3));
    }
}
