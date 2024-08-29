public class CheckIfBinaryTreeIsValidHeap {
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int l = countNodes(root.left);
        int r = countNodes(root.right);
        return r + l + 1;
    }

    public static boolean isCBT(Node root, int i, int n) {
        if (root == null) {
            return true;
        }

        if (i > n) {
            return false;
        }

        return isCBT(root.left, 2 * i, n) && isCBT(root.right, 2 * i + 1, n);
    }

    public static boolean isMaxHeap(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.right == null) {
            return root.left.data < root.data && isMaxHeap(root.left);
        }

        if (root.left != null && root.right != null) {
            return root.data > root.left.data && root.data > root.right.data &&
                    isMaxHeap(root.left) && isMaxHeap(root.right);
        }

        return false;
    }

    public static boolean isHeap(Node root) {
        int n = countNodes(root);
        int i = 1;
        return isCBT(root, i, n) && isMaxHeap(root);
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(2);
        root1.right = new Node(3);
        System.out.println(isHeap(root1));

        Node root2 = new Node(5);
        root2.left = new Node(20);
        root2.right = new Node(30);
        root2.left.left = new Node(40);
        root2.left.right = new Node(60);
        System.out.println(isHeap(root2));
    }
}
