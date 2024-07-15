import java.util.Stack;

public class RedundantBracket {
    public static boolean checkRedundancy(String str) {
        Stack<Character> st = new Stack<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                st.push(ch);
            } else if (ch == ')') {
                int operatorCount = 0;
                while (!st.isEmpty() && st.peek() != '(') {
                    char temp = st.pop();
                    if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
                        operatorCount++;
                    }
                }

                st.pop();
                if (operatorCount == 0) {
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        String str1 = "(a+b)";
        System.out.println(checkRedundancy(str1));
        String str2 = "(a+(b))";
        System.out.println(checkRedundancy(str2));
        String str3 = "((a+b))";
        System.out.println(checkRedundancy(str3));
        String str4 = "((a)+(b))";
        System.out.println(checkRedundancy(str4));
        String str5 = "(a+b*c)";
        System.out.println(checkRedundancy(str5));
        String str6 = "(a+(b*c))";
        System.out.println(checkRedundancy(str6));
        String str7 = "((a)+(b*c))";
        System.out.println(checkRedundancy(str7));
        String str8 = "((a+b)*(c*d))";
        System.out.println(checkRedundancy(str8));
    }
}
