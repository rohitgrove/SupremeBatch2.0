public class FlattenBSTtoSortedList {
    public static void inorder(Node root, Node prev[]) {
        if (root == null) {
            return;
        }

        inorder(root.left, prev);
        prev[0].left = null;
        prev[0].right = root;
        prev[0] = root;
        inorder(root.right, prev);
    }

    public static Node flattenBST(Node root) {
        Node dummy = new Node(-1);
        Node prev[] = { dummy };
        inorder(root, prev);
        prev[0].left = prev[0].right = null;
        root = dummy.right;
        return root;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

    public static void main(String[] args) {
        int data[] = { 5, 3, 7, 2, 4, 6, 8 };
        Node root = ConstructTree.createBST(data);
        print(flattenBST(root));
    }
}
