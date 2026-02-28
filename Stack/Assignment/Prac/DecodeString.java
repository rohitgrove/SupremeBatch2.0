import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                String stringToRepeat = "";
                while (!st.isEmpty() && !Character.isDigit(st.peek().charAt(0))) {
                    String top = st.peek();
                    stringToRepeat += top.equals("[") ? "" : top;
                    st.pop();
                }

                StringBuilder number = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                    number.append(st.pop());
                }

                number.reverse();
                int n = Integer.parseInt(number.toString());

                String repeat = "";
                while (n-- > 0) {
                    repeat += stringToRepeat;
                }

                st.push(repeat);
            } else {
                st.push(String.valueOf(ch));
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        ans.reverse();
        return ans.toString();
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
