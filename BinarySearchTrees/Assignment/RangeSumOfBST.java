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
        Node root1 = ConstructTree.createTree(data1);
        int low1 = 7, high1 = 15;
        System.out.println(rangeSumBST(root1, low1, high1));

        int data2[] = { 10, 5, 15, 3, 7, 13, 18, 1, 6 };
        Node root2 = ConstructTree.createTree(data2);
        int low2 = 6, high2 = 10;
        System.out.println(rangeSumBST(root2, low2, high2));
    }
}
