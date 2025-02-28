import java.util.ArrayList;
import java.util.List;

public class ConvertBSTtoABalancedBST {
    public static void inOrderTraversal(Node root, List<Integer> inOrder) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left, inOrder);
        inOrder.add(root.data);
        inOrderTraversal(root.right, inOrder);
    }

    public static Node buildBTFromInOrder(List<Integer> inOrder, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        Node root = new Node(inOrder.get(mid));
        root.left = buildBTFromInOrder(inOrder, start, mid - 1);
        root.right = buildBTFromInOrder(inOrder, mid + 1, end);
        return root;
    }

    public static Node balanceBST(Node root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root, inOrder);

        // build balanced BST using inorder Traversal
        return buildBTFromInOrder(inOrder, 0, inOrder.size() - 1);
    }

    public static void main(String[] args) {
        int data[] = { 1, 2, 3, 4 };
        Node root = ConstructTree.createBST(data);
        System.out.println("Before balance BST: ");
        Traversals.levelOrder(root);
        System.out.println("After balance BST: ");
        Traversals.levelOrder(balanceBST(root));
    }
}
