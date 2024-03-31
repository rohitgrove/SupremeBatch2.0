public class StringToIntConverter {
    public int mystoi(String s) {
        int len = s.length();
        double num = 0;
        int i = 0;

        while (s.charAt(i) == ' ') {
            i++;
        }

        boolean negative = s.charAt(i) == '-';
        if (negative) {
            i++;
        }

        while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            num = num * 10 + (s.charAt(i) - '0');
            i++;
        }

        num = negative ? -num : num;
        num = (num > Integer.MAX_VALUE) ? Integer.MAX_VALUE : num;
        num = (num < Integer.MIN_VALUE) ? Integer.MIN_VALUE : num;

        return (int) num;
    }
}
