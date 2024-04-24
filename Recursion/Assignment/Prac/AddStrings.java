public class AddStrings {
    public static void main(String[] args) {
        String num1 = "11", num2 = "123";
        System.out.println(addStrings(num1, num2));
        num1 = "456";
        num2 = "77";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        solve(num1, num1.length() - 1, num2, num2.length() - 1, 0, ans);
        ans.reverse();
        return ans.toString();
    }

    public static void solve(String num1, int p1, String num2, int p2, int carry, StringBuilder ans) {
        if (p1 < 0 && p2 < 0) {
            if (carry != 0) {
                ans.append((char) carry + '0');
            }
            return;
        }

        int n1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
        int n2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
        int sum = n1 + n2 + carry;
        int digit = sum % 10;
        carry = sum / 10;
        ans.append(digit);
        solve(num1, p1 - 1, num2, p2 - 1, carry, ans);
    }
}