public class StringCompression {
    public static int compress(char[] chars) {
        int count = 1;
        int index = 0;
        char prev = chars[0];

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == prev) {
                count++;
            } else {
                chars[index++] = prev;
                if (count > 1) {
                    int start = index;
                    while (count > 0) {
                        chars[index++] = (char) (count % 10 + '0');
                        count /= 10;
                    }
                    reverse(chars, start, index - 1);
                }

                prev = chars[i];
                count = 1;
            }
        }

        chars[index++] = prev;
        if (count > 1) {
            int start = index;
            while (count > 0) {
                chars[index++] = (char) (count % 10 + '0');
                count /= 10;
            }
            reverse(chars, start, index - 1);
        }

        return index;
    }

    public static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void printCharArr(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char chars[] = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        System.out.println(compress(chars));
        printCharArr(chars);
    }
}