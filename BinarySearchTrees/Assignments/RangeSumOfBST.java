public class RangeSumOfBST {
    public static int rangeSumBST(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int ans = 0;

        boolean wasInRange = false;
        if (root.data >= low && root.data <= high) {
            wasInRange = true;
            ans += root.data;
        }

        if (wasInRange) {
            ans += rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.data < low) {
            ans += rangeSumBST(root.right, low, high);
        } else if (root.data > high) {
            ans += rangeSumBST(root.left, low, high);
        }
        return ans;
    }

    public static void main(String[] args) {
        int data1[] = { 10, 5, 15, 3, 7, 18 };
        Node root1 = ConstructTree.createBST(data1);
        System.out.println(rangeSumBST(root1, 7, 15));
        int data2[] = { 10, 5, 15, 3, 7, 13, 18, 1, 6 };
        Node root2 = ConstructTree.createBST(data2);
        System.out.println(rangeSumBST(root2, 6, 10));
    }
}
