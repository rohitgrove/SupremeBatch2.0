public class PathSum3 {
    static int ans = 0;

    public static void pathFromOneRoot(Node root, long sum) {
        if (root == null) {
            return;
        }

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
        ConstructTree ct = new ConstructTree();
        int data1[] = { 10, 5, 3, 3, -1, -1, -2, -1, -1, 2, -1, 1, -1, -1, -3, -1, 11, -1, -1 };
        Node root1 = ct.createTree(data1);
        System.out.println(pathSum(root1, 8));
        int data2[] = { 5, 4, 11, 7, -1, -1, 2, -1, -1, -1, 8, 13, -1, -1, 4, 5, -1, -1, 1, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        System.out.println(pathSum(root2, ans));
    }
}
