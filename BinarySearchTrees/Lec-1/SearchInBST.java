public class SearchInBST {
    public static boolean searchInBST(Node root, int target) {
        // base case
        if (root ==  null) {
            return false;
        }

        // 1 case solve mujhe solve karna hai
        if (root.data == target) {
            return true;
        }

        // baaki recursion sambhal lega
        // left ya right
        boolean leftAns = false;
        boolean rightAns = false;
        if (target > root.data) {
            rightAns = searchInBST(root.right, target);
        } else {
            leftAns = searchInBST(root.left, target);
        }

        return leftAns || rightAns;
    }
}
