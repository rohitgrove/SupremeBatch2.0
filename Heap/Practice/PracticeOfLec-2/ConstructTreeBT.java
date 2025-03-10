public class ConstructTreeBT {
    int idx = 0;

    public Node createTree(int data[]) {
        if (data[idx] == -1) {
            idx++;
            return null;
        }

        // step1: create Node
        Node root = new Node(data[idx++]);
        // Step2: create left subtree
        root.left = createTree(data);
        // Step3: create right subtree
        root.right = createTree(data);

        return root;
    }
}