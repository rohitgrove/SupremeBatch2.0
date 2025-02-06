import java.util.Stack;

public class SimplifyPath {
    public static void buildAns(Stack<String> st, StringBuilder ans) {
        if (st.isEmpty()) {
            return;
        }

        String minPath = st.pop();
        buildAns(st, ans);
        ans.append(minPath);
    }

    public static String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        int i = 0;
        while (i < path.length()) {
            int start = i;
            int end = i + 1;
            while (end < path.length() && path.charAt(end) != '/') {
                end++;
            }
            i = end;
            String minPath = path.substring(start, end);
            if (minPath.equals("/") || minPath.equals("/.")) {
                continue;
            }

            if (!minPath.equals("/..")) {
                st.push(minPath);
            } else if (!st.isEmpty()) {
                st.pop();
            }
        }

        StringBuilder ans = new StringBuilder();
        if (st.isEmpty()) {
            ans.append("/");
        }
        buildAns(st, ans);

        return ans.toString();
    }

    public static void main(String[] args) {
        String path1 = "/home/";
        System.out.println(simplifyPath(path1));
        String path2 = "/home//foo/";
        System.out.println(simplifyPath(path2));
        String path3 = "/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(path3));
        String path4 = "/../";
        System.out.println(simplifyPath(path4));
        String path5 = "/.../a/../b/c/../d/./";
        System.out.println(simplifyPath(path5));
    }
}
