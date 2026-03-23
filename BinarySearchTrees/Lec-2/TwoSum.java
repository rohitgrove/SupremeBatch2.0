import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public static void storeInOrder(Node root, List<Integer> inorder) {
        // base case
        if (root == null) {
            return;
        }
        // LNR
        storeInOrder(root.left, inorder);
        // N
        inorder.add(root.data);
        // R
        storeInOrder(root.right, inorder);
    }

    public static boolean findTarget(Node root, int k) {
        List<Integer> inorder = new ArrayList<>();
        storeInOrder(root, inorder);

        // find targeting 2 pointer
        int start = 0;
        int end = inorder.size() - 1;

        while (start < end) {
            int sum = inorder.get(start) + inorder.get(end);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                end--;
            } else if (sum < k) {
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
