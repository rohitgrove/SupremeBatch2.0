public class StringToInteger {
    public static int myAtoi(String s) {
        int num = 0, i = 0, sign = 1; //+ve
        while (s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && s.charAt(i) > '7')) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + (s.charAt(i) - '0');
            i++;
        }

        return num * sign;
    }

    public static void main(String[] args) {
        String s1 = "42";
        System.out.println(myAtoi(s1));
        String s2 = " -42";
        System.out.println(myAtoi(s2));
    }
}
