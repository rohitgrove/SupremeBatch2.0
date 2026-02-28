public class DeleteNodeFromBSTThirdApproach {
    public static Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data == key) {
            // case 1: leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2: left null && right != null
            else if (root.left == null) {
                root = root.right;
                return root;
            }
            // case 3: left != null && right == null
            else if (root.right == null) {
                root = root.left;
                return root;
            }
            // case 4: left != null && right != null
            else {
                // RST ka min nikal lo
                Node rscan = root.right;
                while (rscan.left != null) {
                    rscan = rscan.left;
                }
                rscan.left = root.left;
                root = root.right;
                return root;
            }
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
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
