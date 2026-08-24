public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(ch);
        }

        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }

        if (index == sb.length()) {
            return "0";
        }

        return sb.substring(index);
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
    }
}
