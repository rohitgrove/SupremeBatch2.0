public class SearchInBST {
    public static boolean searchBST(Node root, int target) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }

        boolean leftAns = false;
        boolean rightAns = false;
        if (root.data > target) {
            leftAns = searchBST(root.left, target);
        } else {
            rightAns = searchBST(root.right, target);
        }

        return leftAns || rightAns;
    }
}
