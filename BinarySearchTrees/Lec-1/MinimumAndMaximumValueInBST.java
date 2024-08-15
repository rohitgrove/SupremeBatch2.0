public class MinimumAndMaximumValueInBST {
    public static int minValue(Node root) {
        if (root == null) {
            return -1;
        }

        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }

        return temp.data;
    }

    public static int maxValue(Node root) {
        if (root == null) {
            return -1;
        }

        Node temp = root;
        while (temp.left != null) {
            temp = temp.right;
        }

        return temp.data;
    }
}
