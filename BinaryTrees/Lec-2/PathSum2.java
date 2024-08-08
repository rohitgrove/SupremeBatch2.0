import java.util.List;
import java.util.ArrayList;

public class PathSum2 {
    public static void solve(Node root, int targetSum, List<List<Integer>> ans, List<Integer> temp, int sum) {
        // base case
        if (root == null) {
            return;
        }

        // process current node
        sum += root.data;
        temp.add(root.data);

        // if leaf node and sum matches targetSum
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                // add the path to the final result
                ans.add(new ArrayList<>(temp));
            }
        }
        // recurse for left and right subtrees
        solve(root.left, targetSum, ans, temp, sum);
        solve(root.right, targetSum, ans, temp, sum);

        // backtrack to explore other paths
        temp.remove(temp.size() - 1);
    }

    public static List<List<Integer>> pathSum(Node root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(root, targetSum, ans, temp, 0);
        return ans;
    }

    public static void main(String[] args) {
        int data[] = { 5, 4, 11, 7, -1, -1, 2, -1, -1, -1, 8, 13, -1, -1, 4, -1, 1, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree(data);
        int targetSum = 22;
        System.out.println(pathSum(root, targetSum));

        int data1[] = { 2, 4, 8, 10, -1, -1, -1, 6, 8, 12, -1, -1, -1, -1, 16, 3, -1, 3, -1, -1, 1, -1, 2, -1, 3, -1,
                -1 };
        ConstructTree ct1 = new ConstructTree();
        Node root1 = ct1.createTree(data1);
        int targetSum1 = 24;
        System.out.println(pathSum(root1, targetSum1));
    }
}
