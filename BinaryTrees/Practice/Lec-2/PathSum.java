public class PathSum {
    public static boolean solve(Node root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }

        sum += root.data;
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }

        boolean leftAns = solve(root.left, targetSum, sum);
        boolean rightAns = solve(root.right, targetSum, sum);
        return leftAns || rightAns;
    }

    public static boolean hasPathSum(Node root, int targetSum) {
        int sum = 0;
        return solve(root, targetSum, sum);
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 5, 4, 11, 7, -1, -1, 2, -1, -1, -1, 8, 13, -1, -1, 4, -1, 1, -1, -1 };
        Node root1 = ct.crateTree(data1);
        System.out.println(hasPathSum(root1, 22));
        int data2[] = { 1, 2, 4, 6, -1, -1, 7, -1, -1, -1, 3, -1, 5, 20, -1, -1, 10, -1, 8, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.crateTree(data2);
        System.out.println(hasPathSum(root2, 27));
    }
}
