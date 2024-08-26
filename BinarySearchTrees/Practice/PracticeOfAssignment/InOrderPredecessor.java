public class InOrderPredecessor {
    public static Node inOrederPredeccur(Node root, Node x) {
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
        int data[] = { 5, 3, 7, 2, 4, 6, 9, 1, 8, 10 };
        Node root = ConstructTree.createTree(data);
        Traversals.levelOrderTraversal(root);
        System.out.println(inOrederPredeccur(root, root.right).data);
    } 
}
