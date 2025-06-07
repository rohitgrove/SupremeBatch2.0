public class ConstructTree {
    int idx = 0;

    public Node createTree(int data[]) {
        if (data[idx] == -1) {
            idx++;
            return null;
        }

        Node root = new Node(data[idx++]);

        root.left = createTree(data);
        root.right = createTree(data);

        return root;
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}
