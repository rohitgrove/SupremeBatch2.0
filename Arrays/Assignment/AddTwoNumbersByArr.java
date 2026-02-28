public class AddTwoNumbersByArr {
    public static String calc_Sum(int a[], int n, int b[], int m) {
        int i = n - 1;
        int j = m - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int x = a[i] + b[j] + carry;
            int digit = x % 10;
            carry = x / 10;
            ans.append(digit);
            i--;
            j--;
        }

        while (i >= 0) {
            int x = a[i] + carry;
            int digit = x % 10;
            carry = x / 10;
            ans.append(digit);
            i--;
        }

        while (j >= 0) {
            int x = b[j] + carry;
            int digit = x % 10;
            carry = x / 10;
            ans.append(digit);
            j--;
        }

        if (carry > 0) {
            ans.append(carry);
        }

        while (ans.charAt(ans.length() - 1) == '0') {
            ans.deleteCharAt(ans.length() - 1);
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        int A[] = { 9, 5, 4, 9 }, B[] = { 2, 1, 4 };
        System.out.println(calc_Sum(A, A.length, B, B.length));
    }
}