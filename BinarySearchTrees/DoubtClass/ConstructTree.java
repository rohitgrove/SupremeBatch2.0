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

    public static Node createBST(int data[]) {
        Node root = null;
        for (int i = 0; i < data.length; i++) {
            root = insertIntoBST(root, data[i]);
        }

        return root;
    }
}
