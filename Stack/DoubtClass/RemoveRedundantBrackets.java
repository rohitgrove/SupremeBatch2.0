import java.util.Stack;

public class RemoveRedundantBrackets {
    public static boolean findRedundantBrackets(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                st.push(ch);
            } else if (ch == ')') {
                boolean isNoOperator = true;
                while (!st.isEmpty() && st.peek() != '(') {
                    char temp = st.peek();
                    if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
                        isNoOperator = false;
                    }
                    st.pop();
                }

                st.pop();

                if (isNoOperator) {
                    return true;
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {
        String s1 = "(a+b)";
        System.out.println(findRedundantBrackets(s1));
        String s2 = "(a+(b))";
        System.out.println(findRedundantBrackets(s2));
        String s3 = "((a+b))";
        System.out.println(findRedundantBrackets(s3));
        String s4 = "((a)+(b))";
        System.out.println(findRedundantBrackets(s4));
        String s5 = "(a+b*c)";
        System.out.println(findRedundantBrackets(s5));
        String s6 = "((a+b) * (c+d))";
        System.out.println(findRedundantBrackets(s6));
    }
}