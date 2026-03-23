public class InorderSuccessor {
    public static Node inorderSuccessor(Node root, Node x) {
        Node succ = null;
        Node curr = root;

        while (curr != null) {
            if (curr.data > x.data) {
                succ = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return succ;
    }

    public static void main(String[] args) {
        int data1[] = { 5, 3, 7, 2, 4, 6, 9, 1, 8, 10 };
        Node root1 = ConstructTree.createBST(data1);
        System.out.println(inorderSuccessor(root1, root1.right.right).data);

        int data2[] = { 20, 8, 22, 4, 12, 10, 14 };
        Node root2 = ConstructTree.createBST(data2);
        System.out.println(inorderSuccessor(root2, root2.left).data);
    }
}