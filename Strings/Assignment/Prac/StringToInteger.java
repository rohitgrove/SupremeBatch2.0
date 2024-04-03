public class StringToInteger {
    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int num = 0, i = 0, sign = 1;// +ve

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
            ++i;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && s.charAt(i) > '7')) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + (s.charAt(i) - '0');
            ++i;
        }

        return num * sign;
    }

    public static void main(String[] args) {
        String s1 = "42";
        System.out.println(myAtoi(s1));
        String s2 = "   -42";
        System.out.println(myAtoi(s2));
        String s3 = "4193 with words";
        System.out.println(myAtoi(s3)); // Output: 4193
        String s4 = "words and 987";
        System.out.println(myAtoi(s4)); // Output: 0
        String s5 = "-91283472332";
        System.out.println(myAtoi(s5));
    }
}
