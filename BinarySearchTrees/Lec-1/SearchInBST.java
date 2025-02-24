public class SearchInBST {
    public static boolean search(Node root, int target) { // tc: O(n)
        // base case
        if (root == null) {
            return false;
        }

        // 1 case mujhe solve karna hai
        if (root.data == target) {
            return true;
        }

        // baaki recursion sambhal lega
        // left ya right
        boolean leftAns = false;
        boolean rightAns = false;
        if (target > root.data) {
            leftAns = search(root.right, target);
        } else {
            rightAns = search(root.left, target);
        }

        return leftAns || rightAns;
    }
}
