public class InOrederSuccseor {
    public static Node inOrederSuccseor(Node root, Node x) {
        Node curr = root;
        Node succ = null;
        while (curr != null) {
            if (curr.data > x.data) {
                succ = curr;
                curr = succ.left;
            } else {
                curr = curr.right;
            }
        }
        return succ;
    }

    public static void main(String[] args) {
        int data[] = { 5, 3, 7, 2, 4, 6, 9, 1, 8, 10 };
        Node root = ConstructTree.createTree(data);
        Traversals.levelOrderTraversal(root);
        System.out.println(inOrederSuccseor(root, root.right).data);
    }
}
