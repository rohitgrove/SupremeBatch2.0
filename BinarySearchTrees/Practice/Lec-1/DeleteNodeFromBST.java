public class DeleteNodeFromBST {
    public static Node maxValue(Node root) {
        if (root == null) {
            return null;
        }

        Node temp = root;

        while (temp.right != null) {
            temp = temp.right;
        }

        return temp;
    }

    public static Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null && root.right != null) {
                Node childTree = root.right;
                return childTree;
            } else if (root.left != null && root.right == null) {
                Node childTree = root.left;
                return childTree;
            } else {
                Node maxNode = maxValue(root.left);
                root.data = maxNode.data;
                root.left = deleteNode(root.left, maxNode.data);
                return root;
            }
        } else if (root.data > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}
