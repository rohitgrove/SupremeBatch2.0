public class ConstructTree {
    public static Node insertIntoBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data > root.data) {
            root.right = insertIntoBST(root.right, data);
        } else {
            root.left = insertIntoBST(root.left, data);
        }

        return root;
    }

    public static Node createBST(int[] data) {
        Node root = null;

        for (int idx = 0; idx < data.length; idx++) {
            root = insertIntoBST(root, data[idx]);
        }

        return root;
    }
}