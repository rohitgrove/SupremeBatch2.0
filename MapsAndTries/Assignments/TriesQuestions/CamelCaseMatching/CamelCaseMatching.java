import java.util.ArrayList;
import java.util.List;

public class CamelCaseMatching {
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        Trie trie = new Trie();
        trie.insertWord(pattern);
        for (String query : queries) {
            ans.add(trie.searchWord(query));
        }

        return ans;
    }

    public static void main(String[] args) {
        String queries1[] = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" }, pattern1 = "FB";
        System.out.println(camelMatch(queries1, pattern1));
        String queries2[] = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" }, pattern2 = "FoBa";
        System.out.println(camelMatch(queries2, pattern2));
        String queries3[] = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" }, pattern3 = "FoBaT";
        System.out.println(camelMatch(queries3, pattern3));
    }
}