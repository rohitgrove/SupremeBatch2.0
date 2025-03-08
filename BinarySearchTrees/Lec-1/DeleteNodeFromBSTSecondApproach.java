// Explain in lecture by Love Bhaiya
public class DeleteNodeFromBSTSecondApproach {
    public static Node minValue(Node root) {
        if (root == null) {
            return null;
        }

        Node temp = root;

        while (temp.left != null) {
            temp = temp.left;
        }

        return temp;
    }

    public static Node deleteNode(Node root, int key) {
        // target ko dhundo
        // taget ko delete karo

        if (root == null) {
            return null;
        }

        if (root.data == key) {
            // ab delete karenge
            // 4 cases
            if (root.left == null && root.right == null) {
                // 1 case -> leaf node
                return null;
            } else if (root.left != null && root.right == null) {
                // 2 case -> left non null and right null
                Node childSubtree = root.left;
                return childSubtree;
            } else if (root.left == null && root.right != null) {
                // 3 case -> left null and right non null
                Node childSubtree = root.right;
                return childSubtree;
            } else {
                // 4 case -> left non null and right non null
                // a -> left subtree ki mini value lao
                Node mini = minValue(root.right);
                // replacement
                root.data = mini.data;

                // delete mini wali node
                root.right = deleteNode(root.right, mini.data);
                return root;
            }
        } else if (root.data > key) {
            // left me chalo
            root.left = deleteNode(root.left, key);
        } else {
            // right me jao
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    public static void main(String[] args) {
        int data1[] = { 100, 50, 30, 90, 70, 95, 200, 300, 400 };
        Node root1 = ConstructTree.createBST(data1);
        System.out.println("Level Order Tree 1: ");
        Traversals.levelOrder(deleteNode(root1, 300));
        System.out.println("InOrder Tree 1: ");
        Traversals.inOrder(root1);
        System.out.println();
        System.out.println();

        int data2[] = { 100, 50, 500, 40, 60, 400, 600, 300, 350, 310, 360 };
        Node root2 = ConstructTree.createBST(data2);
        System.out.println("Level Order Tree 2: ");
        Traversals.levelOrder(deleteNode(root2, 100));
        System.out.println("InOrder Tree 2: ");
        Traversals.inOrder(root1);
    }
}
