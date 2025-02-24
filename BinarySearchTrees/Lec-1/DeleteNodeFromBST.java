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
                // a -> left subtree ki max value lao
                Node maxi = maxValue(root.left);
                // replacement
                root.data = maxi.data;

                // delete maxi wali node
                root.left = deleteNode(root.left, maxi.data);
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
}
