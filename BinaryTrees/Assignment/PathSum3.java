public class PathSum3 {
    public static int ans = 0;

    public static void pathFromOneRoot(Node root, long sum) {
        if (root == null) return;

        if (sum == root.data) {
            ans++;
        }

        pathFromOneRoot(root.left, sum - root.data);
        pathFromOneRoot(root.right, sum - root.data);
    }

    public static int pathSum(Node root, long targetSum) {
        if (root != null) {
            pathFromOneRoot(root, targetSum);
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int data1[] = { 10, 5, 3, 3, -1, -1, -2, -1, -1, 2, -1, 1, -1, -1, -3, -1, 11, -1, -1 };
        int target1 = 8;
        ConstructTree ct1 = new ConstructTree();
        Node root1 = ct1.createTree(data1);
        System.out.println(pathSum(root1, target1));
        ans = 0;

        int data2[] = { 5, 4, 11, 7, -1, -1, 2, -1, -1, -1, 8, 13, -1, -1, 4, 5, -1, -1, 1, -1, -1 };
        int target2 = 22;
        ConstructTree ct2 = new ConstructTree();
        Node root2 = ct2.createTree(data2);
        System.out.println(pathSum(root2, target2));
    }
}
