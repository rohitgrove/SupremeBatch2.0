import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBST2 {
    public static List<TreeNode> allPossibleBSTsUsingRec(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();

        // Base cases
        if (start > end) {
            ans.add(null);
            return ans;
        }

        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }

        // Try all numbers between start and end as the root
        for (int i = start; i <= end; i++) {
            // Recursively find all left and right subtrees
            List<TreeNode> left = allPossibleBSTsUsingRec(start, i - 1);
            List<TreeNode> right = allPossibleBSTsUsingRec(i + 1, end);

            // Combine all left and right subtrees with i as root
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    public static List<TreeNode> allPossibleBSTsMemo(int start, int end, Map<String, List<TreeNode>> dp) {
        if (start > end) {
            List<TreeNode> baseList = new ArrayList<>();
            baseList.add(null);
            return baseList;
        }
        if (start == end) {
            List<TreeNode> baseList = new ArrayList<>();
            baseList.add(new TreeNode(start));
            return baseList;
        }

        String key = start + "," + end;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        List<TreeNode> ans = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = allPossibleBSTsMemo(start, i - 1, dp);
            List<TreeNode> rightSubtrees = allPossibleBSTsMemo(i + 1, end, dp);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }

        dp.put(key, ans);
        return ans;
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        Map<String, List<TreeNode>> dp = new HashMap<>();
        return allPossibleBSTsMemo(1, n, dp);
    }

    public static void printList(List<TreeNode> res) {
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i).val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printList(generateTrees(3));
        printList(generateTrees(1));
    }
}
