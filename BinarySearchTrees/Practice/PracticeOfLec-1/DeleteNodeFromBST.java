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
    public static Node deleteNode(Node root, int target) {
        if (root == null) {
            return root;
        }

        if (root.data == target) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
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
