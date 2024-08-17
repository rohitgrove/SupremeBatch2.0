public class ConstructTree {
    public static Node insertData(Node root, int element) {
        if (root == null) {
            return new Node(element);
        }

        if (root.data < element) {
            root.right = insertData(root.right, element);
        } else {
            root.left = insertData(root.left, element);
        }

        return root;
    }

    public static Node createTree(int data[]) {
        Node root = null;
        for (int i = 0; i < data.length; i++) {
            root = insertData(root, data[i]);
        }

        return root;
    }

    public static Node bstFromInorder(int inorder[], int s, int e) {
        // base case
        if (s > e) {
            return null;
        }

        // 1 case solve krna hai
        int mid = s + (e - s) / 2;
        int element = inorder[mid];
        Node root = new Node(element);

        // baaki recursion sumbhal lega
        root.left = bstFromInorder(inorder, s, mid - 1);
        root.right = bstFromInorder(inorder, mid + 1, e);
        return root;
    }

    public static void main(String[] args) {
        int inOrder[] = { 10, 20, 30, 40, 50, 60, 70 };
        int size = inOrder.length;
        int start = 0;
        int end = size - 1;
        Node root = bstFromInorder(inOrder, start, end);
        Traversals.levelOrderTraversal(root);
    }
}
