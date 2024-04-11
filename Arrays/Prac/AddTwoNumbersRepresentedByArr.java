public class AddTwoNumbersRepresentedByArr {
    public static String calc_Sum(int a[], int n, int b[], int m) {
        int i = n - 1;
        int j = m - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int sum = a[i] + b[j] + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ans.append(digit);
            i--;
            j--;
        }

        while (i >= 0) {
            int sum = a[i] + carry;
            int digit = sum % 10;
            carry += carry;
            ans.append(digit);
            i--;
        }

        while (j >= 0) {
            int sum = b[j] + carry;
            int digit = sum % 10;
            carry += carry;
            ans.append(digit);
            j--;
        }

        if (carry > 0) {
            ans.append(carry);
        }
        
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        int A[] = { 9, 5, 4, 9 }, B[] = { 2, 1, 4 };
        System.out.println(calc_Sum(A, A.length, B, B.length));
    }
}
