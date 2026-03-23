import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ReplaceWords {
    public static String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder ans = new StringBuilder();
        Trie trie = new Trie();

        // insert dictionary into trie
        for (String root : dictionary) {
            trie.insert(root);
        }

        // pick each word and find in trie whether the root it available or not.
        String[] words = sentence.split(" ");
        for (String word : words) {
            int trieMatchIndex = trie.search(word);
            if (trieMatchIndex != -1 && trieMatchIndex > 0) {
                ans.append(word.substring(0, trieMatchIndex));
            } else {
                ans.append(word);
            }
            ans.append(" ");
        }

        return ans.toString().trim();
    }

    public static void main(String[] args) {
        List<String> dictionary1 = new ArrayList<>(Arrays.asList("cat", "bat", "rat"));
        String sentence1 = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary1, sentence1));
        List<String> dictionary2 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        String sentence2 = "aadsfasf absbs bbab cadsfafs";
        System.out.println(replaceWords(dictionary2, sentence2));
    }
}