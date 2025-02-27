public class ConvertBSTtoDLL {
    public static void convertBSTtoDLL(Node root, Node[] head) {
        if (root == null) {
            return;
        }

        // RNL

        // R
        convertBSTtoDLL(root.right, head);

        // N
        // attaching next pointer of current node to head of LL
        root.right = head[0];
        // attaching prev pointer of head of LL to current node
        if (head[0] != null) {
            head[0].left = root;
        }
        // head update
        head[0] = root;

        // L
        convertBSTtoDLL(root.left, head);
    }

    public static Node bstToDLL(Node root) {
        Node[] head = new Node[1];
        head[0] = null;
        convertBSTtoDLL(root, head);
        return head[0];
    }

    public static void printLinkedLL(Node head) {
        Node temp = head;
        System.out.println("Printing the entire List: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.right;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        int data1[] = { 100, 50, 200, 5, 60, 300 };
        Node root1 = ConstructTree.createTree(data1);
        printLinkedLL(bstToDLL(root1));
        int data2[] = { 5, 3, 7, 2, 4, 6, 10, 1, 8 };
        Node root2 = ConstructTree.createTree(data2);
        printLinkedLL(bstToDLL(root2));
        int data3[] = { 10, 20, 30, 40, 50, 60, 70 };
        Node root3 = ConstructTree.bstFromInorder(data3, 0, data3.length - 1);
        printLinkedLL(bstToDLL(root3));
    }
}
