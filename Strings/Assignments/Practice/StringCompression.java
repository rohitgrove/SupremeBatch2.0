public class StringCompression {
    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        int n = chars.length;
        int ans = 0;

        int i = 0;

        while (i < n) {
            char ch = chars[i];
            int count = 0;

            // Count consecutive occurrences of the same character
            while (i < n && chars[i] == ch) {
                count++;
                i++;
            }

            // Store the character
            chars[ans++] = ch;

            // Store the count only if it is greater than 1
            if (count > 1) {
                String str = String.valueOf(count);

                for (int j = 0; j < str.length(); j++) {
                    chars[ans++] = str.charAt(j);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        char chars1[] = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        System.out.println(compress(chars1));
        compress(chars1);
        char chars2[] = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
        System.out.println(compress(chars2));
        System.out.println();
        compress(chars2);
    }
}
