import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                String stringToRepeat = "";
                while (!st.empty() && !Character.isDigit(st.peek().charAt(0))) {
                    String top = st.peek();
                    stringToRepeat += top.equals("[") ? "" : top;
                    st.pop();
                }

                StringBuilder numaricTimes = new StringBuilder();
                while (!st.empty() && Character.isDigit(st.peek().charAt(0))) {
                    numaricTimes.append(st.peek());
                    st.pop();
                }

                numaricTimes.reverse();
                int n = Integer.parseInt(String.valueOf(numaricTimes));

                // final decoding
                String currnetDecode = "";
                while (n-- > 0) {
                    currnetDecode += stringToRepeat;
                }
                st.push(currnetDecode);
            } else {
                st.push(String.valueOf(ch));
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!st.empty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        System.out.println(decodeString(s1));
        String s2 = "3[a2[c]]";
        System.out.println(decodeString(s2));
        String s3 = "2[abc]3[cd]ef";
        System.out.println(decodeString(s3));
    }
}
