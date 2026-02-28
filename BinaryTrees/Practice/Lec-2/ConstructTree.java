public class ConstructTree {
    int idx = 0;

    public Node crateTree(int data[]) {
        if (data[idx] == -1) {
            idx++;
            return null;
        }

        Node root = new Node(data[idx++]);

        root.left = crateTree(data);
        root.right = crateTree(data);

        return root;
    }
}
