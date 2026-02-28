public class SubsequenceOfString {
    public static void subsequncesOfString(String s) {
        int num_sub = (int) Math.pow(2, s.length()); // no. of subseq

        for (int n = 0; n < num_sub; n++) {
            String out = "";
            int num = n;

            // convert num to binary
            int i = 0;
            while (num > 0) {
                int b = (num & 1);
                if (b == 1) {
                    out += s.charAt(i);
                }
                i++;
                num >>= 1;
            }
            System.out.println(out);
        }
    }

    public static void main(String[] args) {
        String s = "abcde";
        subsequncesOfString(s);
    }
}