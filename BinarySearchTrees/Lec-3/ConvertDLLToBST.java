class ConvertDLLToBST {
    static Node head;

    public static Node convertDLLtoBST(int n) {
        if (head == null || n <= 0) {
            return null;
        }

        // LNR
        // L
        Node leftSubTree = convertDLLtoBST(n / 2);

        // N
        Node root = head;
        root.left = leftSubTree;
        // head update
        head = head.right;

        // R
        Node rightSubTree = convertDLLtoBST(n - n / 2 - 1);
        root.right = rightSubTree;
        return root;
    }

    public static int len(Node head) {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.right;
            len++;
        }

        return len;
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
