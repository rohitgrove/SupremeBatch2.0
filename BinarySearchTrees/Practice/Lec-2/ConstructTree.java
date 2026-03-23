public class ConstructTree {
    public static Node insertAtBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (root.data < data) {
            root.right = insertAtBST(root.right, data);
        } else {
            root.left = insertAtBST(root.left, data);
        }

        return root;
    }

    public static Node createTree(int data[]) {
        Node root = null;

        for (int i = 0; i < data.length; i++) {
            root = insertAtBST(root, data[i]);
        }

        return root;
    }

    public static Node bstFromInorder(int inOrder[], int s, int e) {
        if (s > e) {
            return null;
        }

        int mid = s + (e - s) / 2;
        int element = inOrder[mid];
        Node root = new Node(element);
        root.left = bstFromInorder(inOrder, s, mid - 1);
        root.right = bstFromInorder(inOrder, mid + 1, e);

        return root;
    }
}
