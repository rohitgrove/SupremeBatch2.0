import java.util.Stack;

public class CheckIfWordVelidAfterSubsitution {
    public static boolean solveRec(String s) {
        if (s.length() == 0) {
            return true;
        }

        int find = s.indexOf("abc");

        if (find != -1) {
            String tleft = s.substring(0, find);
            String tright = s.substring(find + 3);
            return solveRec(tleft + tright);
        }

        return false;
    }

    public static boolean solveItr(String s) {
        if (s.charAt(0) != 'a') {
            return false;
        }

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                st.add(ch);
            } else if (ch == 'b') {
                if (!st.empty() && st.peek() == 'a') {
                    st.push(ch);
                } else {
                    return false;
                }
            } else {
                if (!st.empty() && st.peek() == 'b') {
                    st.pop();
                    if (!st.empty() && st.peek() == 'a') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return st.empty();
    }

    public static boolean isValid(String s) {
        return solveItr(s);
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
