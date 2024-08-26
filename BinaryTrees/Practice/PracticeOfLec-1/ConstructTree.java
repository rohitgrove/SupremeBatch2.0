public class ConstructTree {
    private static int idx = 0;

    public static Node createTree(int nodes[]) {
        if (nodes[idx] == -1) {
            idx++;
            return null;
        }

        Node root = new Node(nodes[idx]);
        idx++;
        root.left = createTree(nodes);
        root.right = createTree(nodes);
        return root;
    }
}
