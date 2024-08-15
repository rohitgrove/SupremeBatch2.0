public class MinimumAndMaximumInBST {
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
}
