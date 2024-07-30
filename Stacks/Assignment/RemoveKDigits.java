import java.util.Stack;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if (k > 0) {
                while (!st.empty() && st.peek() > ch) {
                    st.pop();
                    k--;
                    if (k == 0) {
                        break;
                    }
                }
            }
            st.push(ch);
        }

        if (k > 0) {
            while (!st.empty() && k > 0) {
                st.pop();
                k--;
            }
        }

        StringBuilder res = new StringBuilder();
        while (!st.empty()) {
            res.append(st.pop());
        }

        // removing leading zeros
        while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }

        res.reverse();
        return res.length() == 0 ? "0" : res.toString();
    }

    public static void main(String[] args) {
        String num1 = "1432219";
        int k1 = 3;
        System.out.println(removeKdigits(num1, k1));
        String num2 = "10200";
        int k2 = 1;
        System.out.println(removeKdigits(num2, k2));
        String num3 = "1432219";
        int k3 = 2;
        System.out.println(removeKdigits(num3, k3));
    }
}
