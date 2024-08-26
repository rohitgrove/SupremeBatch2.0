public class DeleteANodeFromBST {
    public static Node deleteNode1(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data == key) {
            // case 1: leaf Node
            if (root.left == null && root.right == null) {
                return null;
            } 
            // case 2: left == null && right != null
            else if (root.left == null && root.right != null) {
                root = root.right;
                return root;
            }
            // case 3: left != null && right == null
            else if (root.left != null && root.right == null) {
                root = root.left;
                return root;
            } 
            // case 4: left == null && right == null
            else {
                // RST ka min nikalo
                Node rscan = root.right;
                while (rscan.left != null) {
                    rscan = rscan.left;
                }
                rscan.left = root.left;
                root = root.right;
                return root;
            }
        } else if (key > root.data) {
            root.right = deleteNode1(root.right, key);
        } else {
            root.left = deleteNode1(root.left, key);
        }

        return root;
    }
    public static Node deleteNode2(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data == key) {
            // case 1: leaf Node
            if (root.left == null && root.right == null) {
                return null;
            } 
            // case 2: left == null && right != null
            else if (root.left == null && root.right != null) {
                root = root.right;
                return root;
            }
            // case 3: left != null && right == null
            else if (root.left != null && root.right == null) {
                root = root.left;
                return root;
            } 
            // case 4: left == null && right == null
            else {
                // LST ka max nikalo
                Node lscan = root.left;
                while (lscan.right != null) {
                    lscan = lscan.right;
                }
                lscan.right = root.right;
                root = root.left;
                return root;
            }
        } else if (key > root.data) {
            root.right = deleteNode2(root.right, key);
        } else {
            root.left = deleteNode2(root.left, key);
        }

        return root;
    }
}
