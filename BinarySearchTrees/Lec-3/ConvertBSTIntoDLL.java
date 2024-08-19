public class ConvertBSTIntoDLL {
    static Node head = null;

    public static void convertBSTToDLLFromrighttSide(Node root) {
        if (root == null) {
            return;
        }

        // RNL

        // R
        convertBSTToDLLFromrighttSide(root.right);

        // N
        // attaching next pointer of current node to head of ll
        root.right = head;
        // attaching prev pointer of head of ll
        if (head != null) {
            head.left = root;
        }
        // update head
        head = root;

        // L
        convertBSTToDLLFromrighttSide(root);
    }

    public static void convertBSTToDLLFromLeftSide(Node root) {
        if (root == null) {
            return;
        }

        // LNR
        // L
        convertBSTToDLLFromLeftSide(root.left);

        // N
        // attaching next pointer of current node to head of ll
        root.left = head;
        // attaching prev pointer of head of ll
        if (head != null) {
            head.right = root;
        }
        // update head
        head = root;

        // R
        convertBSTToDLLFromLeftSide(root.right);

    }

    public static Node bToDLL(Node root) {
        convertBSTToDLLFromrighttSide(root);
        // return head;
        convertBSTToDLLFromLeftSide(root);
        Node temp = head;
        while (temp.left != null) {
            temp = temp.left;
        }
        head = temp;
        return temp;
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
        printLL(bToDLL(root));
    }
}
