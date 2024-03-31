public class BinaryAddition {
    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0)
                carry += a.charAt(i--) - '0';
            if (j >= 0)
                carry += b.charAt(j--) - '0';
            ans.append(carry % 2);
            carry /= 2;
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1111";
        String result = addBinary(a, b);
        System.out.println("Binary sum: " + result);
    }
}
