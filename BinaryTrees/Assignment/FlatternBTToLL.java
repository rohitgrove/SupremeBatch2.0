public class FlatternBTToLL {
    public static Node flatten(Node root, Node next) {
        if (root == null) {
            return next;
        }

        Node rightNode = flatten(root.right, next);
        Node leftNode = flatten(root.left, rightNode);

        root.right = leftNode;
        root.left = null;

        return root;
    }

    public static void flatten(Node root) {
        root = flatten(root, null);
    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int data[] = { 1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 6, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree(data);
        ct.bfs(root);
        flatten(root);
        printLL(root);
    }
}
