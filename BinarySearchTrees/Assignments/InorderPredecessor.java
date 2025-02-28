public class InorderPredecessor {
    public static Node inorderPredecessor(Node root, Node x) {
        Node pred = null;
        Node curr = root;

        while (curr != null) {
            if (curr.data < x.data) {
                pred = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        return pred;
    }

    public static void main(String[] args) {
        int data1[] = { 5, 3, 7, 2, 4, 6, 9, 1, 8, 10 };
        Node root1 = ConstructTree.createBST(data1);
        System.out.println(inorderPredecessor(root1, root1.right.right).data);

        int data2[] = { 20, 8, 22, 4, 12, 10, 14 };
        Node root2 = ConstructTree.createBST(data2);
        System.out.println(inorderPredecessor(root2, root2.left).data);
    }
}
