public class PathSum {
    public static boolean hasPath(Node root, int targetSum) {
        int sum = 0;
        return solve(root, targetSum, sum);
    }

    public static boolean solve(Node root, int targetSum, int sum) {
        // base case
        if (root == null) {
            return false;
        }
        
        sum += root.data;
        if (root.left == null && root.right == null) {
            // verify
            if (sum == targetSum) {
                return true;
            } else {
                return false;
            }
        }

        boolean leftAns = solve(root.left, targetSum, sum);
        boolean rightAns = solve(root.right, targetSum, sum);
        return leftAns || rightAns;
    }

    public static void main(String[] args) {
        int data1[] = { 5, 4, 11, 7, -1, -1, 2, -1, -1, -1, 8, 13, -1, -1, 4, -1, 1, -1, -1 };
        ConstructTree ct1 = new ConstructTree();
        Node root1 = ct1.createTree(data1);
        int targetSum1 = 22;
        System.out.println(hasPath(root1, targetSum1));

        int data2[] = { 1, 2, 4, 6, -1, -1, 7, -1, -1, -1, 3, -1, 5, 20, -1, -1, 10, -1, 8, -1, -1 };
        ConstructTree ct2 = new ConstructTree();
        Node root2 = ct2.createTree(data2);
        int targetSum2 = 27;
        System.out.println(hasPath(root2, targetSum2));
    }
}
