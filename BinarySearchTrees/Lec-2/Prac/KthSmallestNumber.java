public class KthSmallestNumber {
    static int count;

    public static int kthSmallest_helper(Node root) {
        if (root == null) {
            return -1;
        }

        int leftAns = kthSmallest_helper(root.left);
        if (leftAns != -1) {
            return leftAns;
        }

        count--;
        if (count == 0) {
            return root.data;
        }

        int rightAns = kthSmallest_helper(root.right);

        return rightAns;
    }

    public static int kthSmallest(Node root, int k) {
        count = k;
        return kthSmallest_helper(root);
    }

    public static void main(String[] args) {
        int data1[] = { 3, 1, 4, 2 };
        int k1 = 1;
        Node root1 = ConstructTree.createTree(data1);
        System.out.println(kthSmallest(root1, k1));

        int data2[] = { 5, 3, 6, 2, 4, 1 },
                k2 = 3;
        Node root2 = ConstructTree.createTree(data2);
        System.out.println(kthSmallest(root2, k2));
    }
}
