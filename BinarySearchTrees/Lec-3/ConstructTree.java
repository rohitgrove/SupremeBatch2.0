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

    public static Node bstFromInorder(int inorder[], int s, int e) {
        // base case
        if (s > e) {
            return null;
        }

        // 1 case solve karna hai
        int mid = s + (e - s) / 2;
        int element = inorder[mid];
        Node root = new Node(element);

        // baaki recursion
        root.left = bstFromInorder(inorder, s, mid - 1);
        root.right = bstFromInorder(inorder, mid + 1, e);

        return root;
    }
}
