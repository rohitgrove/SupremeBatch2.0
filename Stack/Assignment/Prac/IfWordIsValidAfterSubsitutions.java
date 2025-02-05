import java.util.Stack;

public class IfWordIsValidAfterSubsitutions {
    public static boolean isValidUsingRec(String s) {
        if (s.length() == 0) {
            return true;
        }

        int find = s.indexOf("abc");
        if (find != -1) {
            String tleft = s.substring(0, find);
            String tright = s.substring(find + 3);
            return isValid(tleft + tright);
        }

        return false;
    }

    public static boolean isValidUsingStack(String s) {
        if (s.charAt(0) != 'a') {
            return false;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                st.push(ch);
            } else if (ch == 'b') {
                if (!st.isEmpty() && st.peek() == 'a') {
                    st.push(ch);
                } else {
                    return false;
                }
            } else {
                if (!st.isEmpty() && st.peek() == 'b') {
                    st.pop();
                    if (!st.isEmpty() && st.peek() == 'a') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static boolean isValid(String s) {
        return isValidUsingStack(s);
    }

    public static void main(String[] args) {
        String s1 = "aabcbc";
        System.out.println(isValid(s1));
        String s2 = "abcabcababcc";
        System.out.println(isValid(s2));
        String s3 = "abccba";
        System.out.println(isValid(s3));
    }
}
