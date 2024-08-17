import java.util.ArrayList;

public class TwoSumInBST {
    public static void storeInInorder(Node root, ArrayList<Integer> inOrder) {
        // base case
        if (root == null) {
            return;
        }

        // LNR
        storeInInorder(root.left, inOrder);
        // N
        inOrder.add(root.data);
        // R
        storeInInorder(root.right, inOrder);
    }

    public static boolean findTarget(Node root, int k) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        storeInInorder(root, inOrder);

        // find targetnusing 2 pointer approach
        int start = 0;
        int end = inOrder.size() - 1;
        while (start < end) {
            int sum = inOrder.get(start) + inOrder.get(end);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                end--;
            } else {
                start++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int data[] = { 5, 3, 6, 2, 4, 7 };
        Node root = ConstructTree.createTree(data);
        System.out.println(findTarget(root, 9));
        System.out.println(findTarget(root, 28));
    }
}