import java.util.ArrayList;

public class ConvertBSTToMaxValidHeap {
    public static void storeInorderTraversal(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        storeInorderTraversal(root.left, inorder);
        inorder.add(root.data);
        storeInorderTraversal(root.right, inorder);
    }

    static int index = 0;
    public static Node replaceUsingPostOrderTraversal(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return null;
        }

        // LRN
        replaceUsingPostOrderTraversal(root.left, inorder);
        replaceUsingPostOrderTraversal(root.right, inorder);
        root.data = inorder.get(index++);
        return root;
    }

    public static Node convertBstToMaxValidHeap(Node root) {
        // step 1: store inorder
        ArrayList<Integer> inorder = new ArrayList<>();
        storeInorderTraversal(root, inorder);

        // replace the node values with the sorted inorder values, using the postorder traversal
        root = replaceUsingPostOrderTraversal(root, inorder);
        return root;
    }

    public static void main(String[] args) {
        Node first = new Node(100);
        Node second = new Node(50);
        Node third = new Node(150);
        Node fourth = new Node(40);
        Node fifth = new Node(60);
        Node sixth = new Node(110);
        Node seventh = new Node(200);
        Node eight = new Node(20);
        
        Node root = first;
        root.left = second;
        root.right = third;
        second.left = fourth;
        fourth.left = eight;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;

        ConstructTree ct = new ConstructTree();
        ct.bfs(root);
        root = convertBstToMaxValidHeap(root);
        ct.bfs(root);
    }
}
