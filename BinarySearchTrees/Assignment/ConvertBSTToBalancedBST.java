import java.util.ArrayList;

public class ConvertBSTToBalancedBST {
    public static void inOrder(Node root, ArrayList<Integer> inOrder) {
        if (root == null) {
            return;
        }    

        inOrder(root.left, inOrder);
        inOrder.add(root.data);
        inOrder(root.right, inOrder);
    }

    public static Node buildTree(ArrayList<Integer> inOrder, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        Node root = new Node(inOrder.get(mid));

        root.left = buildTree(inOrder, start, mid - 1);
        root.right = buildTree(inOrder, mid + 1, end);
        return root;
    }


    public static Node balanceBST(Node root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrder(root, inOrder);

        // build balanced BST using inorder traversl.
        return buildTree(inOrder, 0, inOrder.size() - 1);
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        Node root = first;
        root.right = second;
        second.right = third;
        third.right = fourth;
        Traversals.levelOrderTraversal(root);

        Traversals.levelOrderTraversal(balanceBST(root));
    }
}
