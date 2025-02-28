import java.util.ArrayList;
import java.util.List;

public class BrothersFromDifferentRootsMethod1 {
    public static void inOrder(Node root, List<Integer> inOrder) {
        // LNR
        if (root == null) {
            return;
        }

        inOrder(root.left, inOrder);
        inOrder.add(root.data);
        inOrder(root.right, inOrder);
    }

    public static void inOrderReverse(Node root, List<Integer> inOrderRev) {
        // LNR
        if (root == null) {
            return;
        }

        inOrderReverse(root.right, inOrderRev);
        inOrderRev.add(root.data);
        inOrderReverse(root.left, inOrderRev);
    }

    public static int countPairsUsingInoreder(Node root1, Node root2, int x) {
        int count = 0;
        List<Integer> inOrder = new ArrayList<>();
        inOrder(root1, inOrder);
        List<Integer> inOrderRev = new ArrayList<>();
        inOrderReverse(root2, inOrderRev);

        int i = 0;
        int j = 0;
        while (i < inOrder.size() && j < inOrderRev.size()) {
            if (inOrder.get(i) + inOrderRev.get(j) == x) {
                count++;
                i++;
                j++;
            } else if (inOrder.get(i) + inOrderRev.get(j) < x) {
                i++;
            } else {
                j++;
            }
        }
        return count;
    }

    public static int countPairs(Node root1, Node root2, int x) {
        return countPairsUsingInoreder(root1, root2, x);
    }

    public static void main(String[] args) {
        int data1[] = { 5, 3, 7, 2, 4, 6, 8 };
        Node root1 = ConstructTree.createBST(data1);
        int data2[] = { 10, 6, 15, 3, 8, 11, 18 };
        Node root2 = ConstructTree.createBST(data2);
        System.out.println(countPairs(root1, root2, 16));
    }
}
