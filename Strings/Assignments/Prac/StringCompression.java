public class StringCompression {
    public static int compress(char chars[]) {
        int index = 0, count = 1;
        char prev = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == prev) {
                count++;
            } else {
                chars[index++] = prev;
                if (count > 1) {
                    int start = index;
                    while (count > 0) {
                        int digit = count % 10;
                        chars[index++] = (char) (digit + '0');
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
                int digit = count % 10;
                chars[index++] = (char) (digit + '0');
                count /= 10;
            }
            reverse(chars, start, index - 1);
        }

        return index;
    }

    public static void reverse(char chars[], int start, int end) {
        while (start < end) { 
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char chars1[] = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress(chars1));
        char chars2[] = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(chars2));
    }
}
