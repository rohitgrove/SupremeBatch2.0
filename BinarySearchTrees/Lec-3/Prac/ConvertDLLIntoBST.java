public class ConvertDLLIntoBST {
    static Node head;

    public static int len(Node head) {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.right;
            size++;
        }
        return size;
    }

    public static Node convertDLLtoBST(int len) {
        if (head == null || len <= 0) {
            return null;
        }

        Node leftSubTree = convertDLLtoBST(len / 2);

        Node root = head;
        root.left = leftSubTree;
        head = head.right;

        Node rightSubTree = convertDLLtoBST(len - len / 2 - 1);
        root.right = rightSubTree;
        return root;
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);
        Node sixeth = new Node(60);

        first.right = second;
        second.left = first;
        second.right = third;
        third.left = second;
        third.right = fourth;
        fourth.left = third;
        fourth.right = fifth;
        fifth.left = fourth;
        fifth.right = sixeth;
        sixeth.left = fifth;

        head = first;

        int len = len(head);
        Node root = convertDLLtoBST(len);
        Traversals.levelOrderTraversal(root);
    }
}
