import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class UniqueBinarySearchTrees2 {
    public static List<Node> allPossibleBSTs(int start, int end) {
        List<Node> ans = new ArrayList<>();

        // Base cases
        if (start > end) {
            ans.add(null);
            return ans;
        }

        if (start == end) {
            ans.add(new Node(start));
            return ans;
        }

        // Try all numbers between start and end as the root
        for (int i = start; i <= end; i++) {
            // Recursively find all left and right subtrees
            List<Node> left = allPossibleBSTs(start, i - 1);
            List<Node> right = allPossibleBSTs(i + 1, end);

            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    Node root = new Node(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    public static List<Node> allPossibleBSTsMemo(int start, int end) {
        List<Node> ans = new ArrayList<>();

        // Base cases
        if (start > end) {
            ans.add(null);
            return ans;
        }

        if (start == end) {
            ans.add(new Node(start));
            return ans;
        }

        // Try all numbers between start and end as the root
        for (int i = start; i <= end; i++) {
            // Recursively find all left and right subtrees
            List<Node> left = allPossibleBSTs(start, i - 1);
            List<Node> right = allPossibleBSTs(i + 1, end);

            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    Node root = new Node(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    public static List<Node> allPossibleBSTsMemo(int start, int end, HashMap<String, List<Node>> dp) {
        List<Node> ans = new ArrayList<>();
        // Base cases
        if (start > end) {
            ans.add(null);
            return ans;
        }

        if (start == end) {
            ans.add(new Node(start));
            return ans;
        }

        String key = start + "," + end;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        for (int i = start; i <= end; i++) {
            List<Node> left = allPossibleBSTsMemo(start, i - 1, dp);
            List<Node> right = allPossibleBSTsMemo(i + 1, end, dp);

            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    Node root = new Node(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    ans.add(root);
                }
            }
        }

        dp.put(key, ans);
        return ans;
    }

    public static List<Node> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        // return allPossibleBSTs(1, n);
        HashMap<String, List<Node>> dp = new HashMap<>();
        return allPossibleBSTsMemo(1, n, dp);
    }

    public static void printTrees(List<Node> trees) {
        for (Node root : trees) {
            Traversals.levelOrder(root);
        }
    }

    public static void main(String[] args) {
        printTrees(generateTrees(3));
    }
}