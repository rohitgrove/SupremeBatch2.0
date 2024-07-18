public class SubSequence {
    public static void subSequence(String str) {
        int num_subs = (int) Math.pow(2, str.length()); // no. of subseq

        for (int n = 0; n < num_subs; n++) {
            StringBuilder out = new StringBuilder();
            int num = n;

            // convert num to binary
            int i = 0;
            while (num > 0) {
                int b = (num & 1);
                if (b == 1) {
                    out.append(str.charAt(i));
                }
                ++i;
                num >>= 1;
            }
            System.out.println(out);
        }
    }

    public static void main(String[] args) {
        String str = "abcde";
        subSequence(str);
    }
}
