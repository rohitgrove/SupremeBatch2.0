public class SearchInBST {
    public static boolean search(Node root, int target) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }

        boolean leftAns = false;
        boolean rightAns = false;

        if (root.data < target) {
            rightAns = search(root.right, target);
        } else {
            leftAns = search(root.left, target);
        }

        return leftAns || rightAns;
    }
}
