public class ConvertBSTIntoDLL {
    static Node head = null;
    public static void convertBSTToDLL(Node root) {
        if (root == null) {
            return;
        }

        convertBSTToDLL(root.right);

        root.right = head;
        if (head != null) {
            head.left = root;
        }
        head = root;

        convertBSTToDLL(root.left);
    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.right;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        int data[] = { 10, 20, 30, 40, 50, 60, 70 };
        Node root = ConstructTree.bstFromInorder(data, 0, data.length - 1);
        Traversals.levelOrderTraversal(root);
        convertBSTToDLL(root);
        printLL(head);
    }
}
