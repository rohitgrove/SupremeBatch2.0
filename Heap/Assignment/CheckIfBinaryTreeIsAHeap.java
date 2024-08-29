public class CheckIfBinaryTreeIsAHeap {
    public static int nodeCount(Node root) {
        if (root == null) {
            return 0;
        }
        int l = nodeCount(root.left);
        int r = nodeCount(root.right);
        return 1 + l + r;
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

    public static boolean isMaxOrder(Node root) {
        if (root == null) {
            return true;
        }
    
        // If the node is a leaf node, it's trivially true
        if (root.left == null && root.right == null) {
            return true;
        }
    
        // If the node has only left child
        if (root.left != null && root.right == null) {
            return root.data > root.left.data && isMaxOrder(root.left);
        }
    
        // If the node has both children
        if (root.left != null && root.right != null) {
            return root.data > root.left.data && root.data > root.right.data &&
                   isMaxOrder(root.left) && isMaxOrder(root.right);
        }
    
        // If the node has only right child (shouldn't occur in a heap but handling it)
        return false;
    }
    

    public static boolean isHeap(Node tree) { // tc: O(n)
        int n = nodeCount(tree);
        int i = 1;
        return isCBT(tree, i, n) && isMaxOrder(tree);
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