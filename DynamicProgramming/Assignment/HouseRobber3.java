import java.util.HashMap;

public class HouseRobber3 {
    public static int solveUsingRec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int robThisHouse = 0, dontRobThisHouse = 0;

        // job curr house
        robThisHouse += root.val;
        if (root.left != null) {
            robThisHouse += solveUsingRec(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            robThisHouse += solveUsingRec(root.right.left) + rob(root.right.right);
        }

        // don't curr house
        dontRobThisHouse += solveUsingRec(root.left) + solveUsingRec(root.right);

        return Math.max(robThisHouse, dontRobThisHouse);
    }

    public static int solveUsingMemo(TreeNode root, HashMap<TreeNode, Integer> dp) {
        if (root == null) {
            return 0;
        }

        if (dp.containsKey(root)) {
            return dp.get(root);
        }

        int robThisHouse = 0, dontRobThisHouse = 0;

        robThisHouse += root.val;
        if (root.left != null) {
            robThisHouse += solveUsingMemo(root.left.left, dp) + solveUsingMemo(root.left.right, dp);
        }

        if (root.right != null) {
            robThisHouse += solveUsingMemo(root.right.left, dp) + solveUsingMemo(root.right.right, dp);
        }

        dontRobThisHouse += solveUsingMemo(root.left, dp) + solveUsingMemo(root.right, dp);

        dp.put(root, Math.max(robThisHouse, dontRobThisHouse));
        return dp.get(root);
    }

    public static int rob(TreeNode root) {
        HashMap<TreeNode, Integer> dp = new HashMap<>();
        return solveUsingMemo(root, dp);
    }

    public static void main(String[] args) {
        TreeNode first = new TreeNode(3);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(3);
        TreeNode fifth = new TreeNode(1);

        TreeNode root = first;
        root.left = second;
        root.right = third;
        root.left.right = fourth;
        root.right.right = fifth;
        System.out.println(rob(root));
    }
}
