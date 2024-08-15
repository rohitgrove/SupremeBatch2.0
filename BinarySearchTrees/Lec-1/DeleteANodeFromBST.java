public class DeleteANodeFromBST {
    public static Node maxValue(Node node) {
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public static Node deleteNode(Node root, int target) {
        if (root == null) {
            return null;
        }

        if (root.data == target) {
            // Leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // Left non-null, right null
            else if (root.left != null && root.right == null) {
                return root.left;
            }
            // Left null, right non-null
            else if (root.left == null && root.right != null) {
                return root.right;
            }
            // Both left and right non-null
            else {
                Node maxi = maxValue(root.left);
                root.data = maxi.data;
                root.left = deleteNode(root.left, maxi.data);
                return root;
            }
        } else if (root.data > target) {
            root.left = deleteNode(root.left, target);
        } else {
            root.right = deleteNode(root.right, target);
        }

        return root;
    }
}
