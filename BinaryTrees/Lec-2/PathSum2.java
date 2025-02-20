import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static List<List<Integer>> pathSum(Node root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(root, targetSum, ans, temp, 0);
        return ans;
    }

    public static void solve(Node root, int targetSum, List<List<Integer>> ans, List<Integer> temp, int sum) {
        // base case
        if (root == null) {
            return;
        }
        // 1 case solve karna hai
        sum += root.data;
        temp.add(root.data);

        // extra case
        if (root.left == null && root.right == null) {
            // verify
            if (sum == targetSum) {
                // store temp path in final ans array (create a copy!)
                ans.add(new ArrayList<>(temp)); // Important: Create a new list copy
            }
        }

        // baaki recursion sambhal lega
        solve(root.left, targetSum, ans, temp, sum);
        solve(root.right, targetSum, ans, temp, sum);

        // Backtrack: Remove the last added element for exploring other paths
        temp.remove(temp.size() - 1); // Crucial for correct path exploration
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 5, 4, 11, 7, -1, -1, 2, -1, -1, -1, 8, 13, -1, -1, 4, -1, 1, -1, -1 };
        Node root1 = ct.createTree(data1);
        System.out.println(pathSum(root1, 22));
        int data2[] = { 2, 4, 8, 10, -1, -1, -1, 6, 8, 12, -1, -1, -1, -1, 16, 3, -1, 3, -1, -1, 1, -1, 2, -1, 3, -1,
                -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        System.out.println(pathSum(root2, 27));
    }
}
