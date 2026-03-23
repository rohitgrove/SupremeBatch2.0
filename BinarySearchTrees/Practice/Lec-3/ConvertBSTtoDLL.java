public class ConvertBSTtoDLL {
    public static void convertBSTtoDLL(Node root, Node head[]) {
        if (root == null) {
            return;
        }

        convertBSTtoDLL(root.right, head);

        root.right = head[0];
        if (head[0] != null) {
            head[0].left = root;
        }
        head[0] = root;

        convertBSTtoDLL(root.left, head);
    }

    public static Node bstToDLL(Node root) {
        Node head[] = { null };
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
